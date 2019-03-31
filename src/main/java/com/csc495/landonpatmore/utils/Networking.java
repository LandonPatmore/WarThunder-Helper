package com.csc495.landonpatmore.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import java.io.IOException;

public class Networking {

    private static JSONObject retrieveData(String server, String endpoint) throws IOException {
        final CloseableHttpClient client = HttpClientBuilder.create().build();
        final HttpGet request = new HttpGet("http://" + server + "/" + endpoint);
        request.addHeader("accept", "application/json");

        final CloseableHttpResponse response = client.execute(request);

        try {
            final String json = IOUtils.toString(response.getEntity().getContent());
            return new JSONObject(json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
            response.close();
        }
    }

    public static JSONObject getState(String server) throws IOException {
        return retrieveData(server, "state");
    }

    public static JSONObject getIndicators(String server) throws IOException {
        return retrieveData(server, "indicators");
    }
}
