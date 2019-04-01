package com.csc495.landonpatmore;

import com.csc495.landonpatmore.models.AircraftIndicators;
import com.csc495.landonpatmore.models.AircraftState;
import com.csc495.landonpatmore.utils.Helpers;
import com.csc495.landonpatmore.utils.MockNetworking;
import com.csc495.landonpatmore.utils.Network;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {

    @FXML
    private Text iasSpeed; // initially km/h
    @FXML
    private Text tasSpeed; // initially km/h
    @FXML
    private Text aircraftHeight;
    @FXML
    private Text heading;
    @FXML
    private Text elevatorPercentage;
    @FXML
    private Text aileronPercentage;
    @FXML
    private Text rudderPercentage;
    @FXML
    private Text roll;

    @FXML
    private Polygon headingIndicator;

    @FXML
    private VBox rollIndicator;

    @FXML
    private Rectangle elevatorUp;
    @FXML
    private Rectangle elevatorDown;
    @FXML
    private Rectangle aileronLeft;
    @FXML
    private Rectangle aileronRight;
    @FXML
    private Rectangle rudderLeft;
    @FXML
    private Rectangle rudderRight;

    @FXML
    private LineChart<String, Number> speedTestChart;

    // setup a scheduled executor to periodically put data into the chart
    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

    private final int WINDOW_SIZE = 500;


    public void initialize() {
        speedTestChart.setHorizontalGridLinesVisible(false);
        speedTestChart.setVerticalGridLinesVisible(false);
        speedTestChart.setCreateSymbols(false);

        getState(new MockNetworking());
    }

    private void setVerticalControlSurface(Rectangle positive, Rectangle negative, int value) {
        if (value >= 0) {
            negative.setHeight(0);
            positive.setHeight(value * 1.5);
        } else {
            positive.setHeight(0);
            negative.setHeight(value * -1 * 1.5);
        }
    }

    private void setHorizontalControlSurface(Rectangle positive, Rectangle negative, int value) {
        if (value >= 0) {
            negative.setWidth(0);
            positive.setWidth(value * 1.5);
        } else {
            positive.setWidth(0);
            negative.setWidth(value * -1 * 1.5);
        }
    }

    private void rotateShape(Polygon polygon, double angle) {
        polygon.setRotate(angle);
    }

    private void rotatePane(Pane pane, double angle) {
        pane.setRotate(angle);
    }

    private void setText(Text text, Object value) {
        text.setText(String.valueOf(value));
    }

    private void setText(Text text, Object value, String postFix) {
        text.setText(value + postFix);
    }


    private void getState(Network networking) {
        final XYChart.Series<String, Number> series = new XYChart.Series<>();
        speedTestChart.getData().add(series);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            Date now = new Date();
            JSONObject stateJson = networking.getState();
            JSONObject indicatorsJson = networking.getIndicators();
            final AircraftState aircraftState = Helpers.buildState(stateJson);
            final AircraftIndicators aircraftIndicators = Helpers.buildIndicators(indicatorsJson);

            if (aircraftState.isValid() && aircraftIndicators.isValid()) {
                Platform.runLater(() -> {
                    setVerticalControlSurface(elevatorUp, elevatorDown, aircraftState.getElevatorPercentage());
                    setText(elevatorPercentage, aircraftState.getElevatorPercentage(), "%");
                    setHorizontalControlSurface(aileronRight, aileronLeft, aircraftState.getAileronPercentage());
                    setText(aileronPercentage, aircraftState.getAileronPercentage(), "%");
                    setHorizontalControlSurface(rudderRight, rudderLeft, aircraftState.getRudderPercentage());
                    setText(rudderPercentage, aircraftState.getRudderPercentage(), "%");

                    setText(iasSpeed, aircraftState.getIAS());
                    series.getData().add(new XYChart.Data<>(simpleDateFormat.format(now), aircraftState.getIAS()));
                    if (series.getData().size() > WINDOW_SIZE) {
                        series.getData().remove(0);
                    }
                    setText(tasSpeed, aircraftState.getTAS());
                    setText(aircraftHeight, aircraftState.getAltitude());

                    setText(heading, Math.floor(aircraftIndicators.getCompass()), "°");
                    rotateShape(headingIndicator, Math.floor(aircraftIndicators.getCompass()));

                    setText(roll, Math.floor(aircraftIndicators.getAviahorizon_roll()), "°");
                    rotatePane(rollIndicator, Math.floor(aircraftIndicators.getAviahorizon_roll()));
                });
            } else {
                System.out.println("Not valid data...");
            }
        }, 0, 10, TimeUnit.MILLISECONDS);
    }
}

