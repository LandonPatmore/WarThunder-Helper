package com.csc495.landonpatmore.utils;

import com.csc495.landonpatmore.models.Indicators;
import com.csc495.landonpatmore.models.State;
import org.json.JSONException;
import org.json.JSONObject;

public class Helpers {

    public static State buildState(JSONObject json) {
        final State state = new State();

        final boolean isValid = (boolean) getValue(json, "valid");

        if (isValid) {
            state.setValid(true);
            state.setAileronPercentage(getInt(json, "aileron, %"));
            state.setElevatorPercentage(getInt(json, "elevator, %"));
            state.setRudderPercentage(getInt(json, "rudder, %"));
            state.setFlapsPercentage(getInt(json, "flaps, %"));
            state.setGearPercentage(getInt(json, "gear, %"));

            return state;
        } else {
            state.setValid(false);
            return state;
        }
    }

    public static Indicators buildIndicators(JSONObject json) {
        final Indicators indicators = new Indicators();

        final boolean isValid = getBoolean(json, "valid");

        if (isValid) {
            indicators.setValid(true);


            return indicators;
        } else {
            indicators.setValid(false);
            return indicators;
        }
    }

    private static Object getValue(JSONObject json, String key) {
        try {
            return json.get(key);
        } catch (JSONException e) {
            return null;
        }
    }

    private static boolean getBoolean(JSONObject json, String key) {
        return (boolean) getValue(json, key);
    }

    private static int getInt(JSONObject json, String key) {
        return (int) getValue(json, key);
    }

    private static double getDouble(JSONObject json, String key) {
        return (double) getValue(json, key);
    }

    private static String getString(JSONObject json, String key) {
        return (String) getValue(json, key);
    }
}
