package com.csc495.landonpatmore.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Networking implements Network {

    public Networking() {
        
    }

    @Override
    public JSONObject retrieveData(String endpoint) {
        final HttpResponse<String> response;
        try {
            response = Unirest.get("http://localhost:8111/" + endpoint)
                    .asString();
            return new JSONObject(response.getBody());
        } catch (UnirestException e) {
            return null;
        }
    }

    @Override
    public JSONObject getState() {
        return retrieveData("state");
    }

    @Override
    public JSONObject getIndicators() {
        return retrieveData("indicators");
    }
}
