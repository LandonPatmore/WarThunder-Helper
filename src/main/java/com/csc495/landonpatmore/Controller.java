package com.csc495.landonpatmore;

import com.csc495.landonpatmore.models.AircraftIndicators;
import com.csc495.landonpatmore.models.AircraftState;
import com.csc495.landonpatmore.utils.Helpers;
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
        final Thread thread = new Thread(getState());
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


    private Task getState() {
        return new Task<>() {
            @Override
            protected Void call() throws InterruptedException {
                double angle = 0;
                while (true) {
                    Thread.sleep(500);
                    double finalAngle = angle;
                    Platform.runLater(() -> {
                        setText(String.valueOf(finalAngle), heading);
                        rotateShape(finalAngle, headingIndicator);
                    });
                    angle++;
                }
            }
        };
    }
}

