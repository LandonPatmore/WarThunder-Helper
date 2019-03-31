package com.csc495.landonpatmore;

import com.csc495.landonpatmore.utils.Helpers;
import com.csc495.landonpatmore.utils.Networking;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import org.json.JSONObject;

import java.io.IOException;

public class Controller {

    @FXML
    private Rectangle aileron;

    @FXML
    private Rectangle elevator;

    @FXML
    private Rectangle rudder;

    @FXML
    private Rectangle flaps;

    @FXML
    private Rectangle gear;

    public void initialize() {
        final Task task = getState();

        final Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    private Task getState() {
        return new Task<>() {
            @Override
            protected Void call() throws InterruptedException {
                while (true) {
                    Thread.sleep(100);
                    final JSONObject json;
                    try {
                        json = Networking.getState("129.3.168.233:8111");
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                    final com.csc495.landonpatmore.models.State state = Helpers.buildState(json);

                    if (state.isValid()) {
                        System.out.println("hi");
                        aileron.setHeight(state.getAileronPercentage() * 2);
                        elevator.setHeight(state.getElevatorPercentage() * 2);
                        rudder.setHeight(state.getRudderPercentage() * 2);
                        flaps.setHeight(state.getFlapsPercentage() * 2);
                        gear.setHeight(state.getGearPercentage() * 2);
                    } else {
                        System.out.println("State is not valid...");
                        aileron.setHeight(0);
                        elevator.setHeight(0);
                        rudder.setHeight(0);
                        flaps.setHeight(0);
                        gear.setHeight(0);
                    }
                }
            }
        };
    }
}

