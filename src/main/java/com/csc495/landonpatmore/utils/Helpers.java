package com.csc495.landonpatmore.utils;

import com.csc495.landonpatmore.models.AircraftState;
import com.csc495.landonpatmore.models.AircraftIndicators;
import org.json.JSONException;
import org.json.JSONObject;

public class Helpers {

    public static AircraftState buildState(JSONObject json) {
        final AircraftState aircraftState = new AircraftState();

        final boolean isValid = (boolean) getValue(json, "valid");

        if (isValid) {
            aircraftState.setValid(true);
            aircraftState.setAileronPercentage(getInt(json, "aileron, %"));
            aircraftState.setElevatorPercentage(getInt(json, "elevator, %"));
            aircraftState.setRudderPercentage(getInt(json, "rudder, %"));
            aircraftState.setFlapsPercentage(getInt(json, "flaps, %"));
            aircraftState.setGearPercentage(getInt(json, "gear, %"));
            aircraftState.setIAS(getInt(json, "IAS, km/h"));
            aircraftState.setTAS(getInt(json, "TAS, km/h"));
            aircraftState.setAltitude(getInt(json, "H, m"));

            return aircraftState;
        } else {
            aircraftState.setValid(false);
            return aircraftState;
        }
    }

    public static AircraftIndicators buildIndicators(JSONObject json) {
        final AircraftIndicators aircraftIndicators = new AircraftIndicators();

        final boolean isValid = getBoolean(json, "valid");

        if (isValid) {
            aircraftIndicators.setValid(true);
            aircraftIndicators.setCompass(getDouble(json, "compass1"));
            aircraftIndicators.setAviahorizon_roll(getDouble(json, "aviahorizon_roll"));

            return aircraftIndicators;
        } else {
            aircraftIndicators.setValid(false);
            return aircraftIndicators;
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
