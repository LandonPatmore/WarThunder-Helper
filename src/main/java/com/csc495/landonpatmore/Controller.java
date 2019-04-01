package com.csc495.landonpatmore;

import com.csc495.landonpatmore.models.AircraftIndicators;
import com.csc495.landonpatmore.models.AircraftState;
import com.csc495.landonpatmore.utils.Helpers;
import com.csc495.landonpatmore.utils.MockNetworking;
import com.csc495.landonpatmore.utils.Network;
import com.csc495.landonpatmore.utils.Networking;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import org.json.JSONObject;

import java.io.IOException;

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
    private Polygon headingIndicator;

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


    public void initialize() {
        final Thread thread = new Thread(getState(new MockNetworking()));
        thread.setDaemon(true);
        thread.start();
    }

    private void setVerticalControlSurface(int value, Rectangle positive, Rectangle negative) {
        if (value >= 0) {
            negative.setHeight(0);
            positive.setHeight(value * 1.5);
        } else {
            positive.setHeight(0);
            negative.setHeight(value * -1 * 1.5);
        }
    }

    private void setHorizontalControlSurface(int value, Rectangle positive, Rectangle negative) {
        if (value >= 0) {
            negative.setWidth(0);
            positive.setWidth(value * 1.5);
        } else {
            positive.setWidth(0);
            negative.setWidth(value * -1 * 1.5);
        }
    }

    private void rotateShape(double angle, Polygon polygon) {
        polygon.setRotate(angle);
    }

    private void setText(Object value, Text text) {
        text.setText(String.valueOf(value));
    }

    private void setText(Object value, Text text, String postFix) {
        text.setText(value + postFix);
    }


    private Task getState(Network networking) {
        return new Task<>() {
            @Override
            protected Void call() throws InterruptedException {
                while (true) {
                    Thread.sleep(10);
                    JSONObject stateJson;
                    JSONObject indicatorsJson;
                    stateJson = networking.getState();
                    indicatorsJson = networking.getIndicators();
                    final AircraftState aircraftState = Helpers.buildState(stateJson);
                    final AircraftIndicators aircraftIndicators = Helpers.buildIndicators(indicatorsJson);

                    if (true) {
                        Platform.runLater(() -> {
                            setVerticalControlSurface(aircraftState.getElevatorPercentage(), elevatorUp, elevatorDown);
                            setText(aircraftState.getElevatorPercentage(), elevatorPercentage, "%");
                            setHorizontalControlSurface(aircraftState.getAileronPercentage(), aileronRight, aileronLeft);
                            setText(aircraftState.getAileronPercentage(), aileronPercentage, "%");
                            setHorizontalControlSurface(aircraftState.getRudderPercentage(), rudderRight, rudderLeft);
                            setText(aircraftState.getRudderPercentage(), rudderPercentage);

                            setText(aircraftState.getIAS(), iasSpeed);
                            setText(aircraftState.getTAS(), tasSpeed);
                            setText(aircraftState.getAltitude(), aircraftHeight);

                            setText(Math.floor(aircraftIndicators.getCompass()), heading, "°");
                            rotateShape(Math.floor(aircraftIndicators.getCompass()), headingIndicator);
                        });
                    } else {
                        System.out.println("AircraftState is not valid...");
                    }
                }
            }
        };
    }
}

