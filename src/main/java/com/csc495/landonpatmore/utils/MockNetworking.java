package com.csc495.landonpatmore.utils;

import org.json.JSONObject;

public class MockNetworking implements Network {

    @Override
    public JSONObject retrieveData(String endpoint) {
        return null;
    }

    @Override
    public JSONObject getState() {
        return null;
    }

    @Override
    public JSONObject getIndicators() {
        return null;
    }
}
