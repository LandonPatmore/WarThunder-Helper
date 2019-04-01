package com.csc495.landonpatmore.utils;

import org.json.JSONObject;

public interface Network {

    /**
     * Grabs data from a specified endpoint
     *
     * @param endpoint endpoint name
     * @return JSONObject containing data from endpoint
     */
    JSONObject retrieveData(String endpoint);

    /**
     * Gets the state of the aircraft
     *
     * @return JSONObject containing data from the state endpoint
     */
    JSONObject getState();

    /**
     * Gets the indicators of the aircraft
     *
     * @return JSONObject containing data from the indicators endpoint
     */
    JSONObject getIndicators();
}
