package com.auroratracker.desktop.controller;

import com.auroratracker.desktop.model.AuroraData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AuroraDataController {

    private static String API_URL = "http://localhost:8080/api/aurora/predic";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public AuroraDataController(){
        httpClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public AuroraData fetchAuroraData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(API_URL))
                .setHeader("Accept", "application/json")
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() != 200) {
            throw new RuntimeException("Misslyckades att hämta data: HTTP " + response.statusCode());
        }

        return  objectMapper.readValue(response.body(), AuroraData.class);

    }
}
