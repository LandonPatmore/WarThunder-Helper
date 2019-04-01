package com.csc495.landonpatmore.utils;

import org.json.JSONObject;

import java.util.Random;

public class MockNetworking implements Network {

    private final JSONObject currentState;
    private final JSONObject currentIndicators;

    public MockNetworking() {
        currentState = createMockState();
        currentIndicators = createMockIndicators();
    }

    @Override
    public JSONObject retrieveData(String endpoint) {
        return null;
    }

    @Override
    public JSONObject getState() {
        return mockStateData();
    }

    @Override
    public JSONObject getIndicators() {
        return mockIndicatorsData();
    }

    private JSONObject createMockState() {
        final JSONObject state = new JSONObject();
        state.put("valid", true);
        state.put("aileron, %", generateIntValue(-101, 101));
        state.put("elevator, %", generateIntValue(-101, 101));
        state.put("flaps, %", generateIntValue(-101, 101));
        state.put("rudder, %", generateIntValue(-101, 101));
        state.put("gear, %", generateIntValue(-101, 101));
        state.put("H, m", generateIntValue(500, 1001));
        state.put("IAS, km/h", generateIntValue(300, 500));
        state.put("TAS, km/h", generateIntValue(300, 500));

        return state;
    }

    private JSONObject createMockIndicators() {
        final JSONObject state = new JSONObject();
        state.put("valid", true);
        state.put("compass1", generateDoubleValue(0, 360));
        state.put("aviahorizon_roll", generateDoubleValue(-180, 181));

        return state;
    }

    private int generateIntValue(int lowerBound, int upperBound) {
        return new Random().nextInt(upperBound - lowerBound) + lowerBound;
    }

    private double generateDoubleValue(int lowerBound, int upperBound) {
        return (double) new Random().nextInt(upperBound - lowerBound) + lowerBound;
    }

    private JSONObject mockStateData() {
        changeIntValue(currentState, "aileron, %", -101, 101);
        changeIntValue(currentState, "elevator, %", -101, 101);
        changeIntValue(currentState, "flaps, %", -101, 101);
        changeIntValue(currentState, "rudder, %", -101, 101);
        changeIntValue(currentState, "gear, %", -101, 101);
        changeIntValue(currentState, "H, m", 0, 1001);
        changeIntValue(currentState, "IAS, km/h", 300, 500);
        changeIntValue(currentState, "TAS, km/h", 300, 500);

        return currentState;
    }

    private JSONObject mockIndicatorsData() {
        changeDoubleValue(currentIndicators, "compass1", 0, 360);
        changeDoubleValue(currentIndicators, "aviahorizon_roll", -180, 181);

        return currentIndicators;
    }

    private void changeIntValue(JSONObject json, String key, int lowerBound, int upperBound) {
        int valueToChange = json.getInt(key);
        int random = new Random().nextInt(20);

        changeValue(json, key, random, valueToChange, lowerBound, upperBound, true);
    }

    private void changeDoubleValue(JSONObject json, String key, int lowerBound, int upperBound) {
        double valueToChange = json.getDouble(key);
        int random = new Random().nextInt(20);

        changeValue(json, key, random, (int) valueToChange, lowerBound, upperBound, false);
    }

    private void changeValue(JSONObject json, String key, int random, int valueToChange, int lowerBound, int upperBound, boolean isInt) {
        if (Math.random() >= .8) { // change value

            if (Math.random() >= .5) {
                random *= -1;
            }

            if ((valueToChange + random) < upperBound && (valueToChange + random) > lowerBound) { // can change with random value
                if (isInt) {
                    valueToChange += random;
                    json.put(key, valueToChange);
                } else {
                    valueToChange += random;
                    json.put(key, (double) valueToChange);
                }
            } else {
                if (isInt) {
                    valueToChange += (random * -1);
                    json.put(key, valueToChange);
                } else {
                    valueToChange += (random * -1);
                    json.put(key, (double) valueToChange);
                }
            }
        }
    }
}
