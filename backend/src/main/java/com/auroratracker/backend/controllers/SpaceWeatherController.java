package com.auroratracker.backend.controllers;


import com.auroratracker.backend.models.space.SpaceWeather;
import com.auroratracker.backend.models.space.weatherfactors.SolarWind;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/aurora")
public class SpaceWeatherController {
    //https://services.swpc.noaa.gov/json/3-day-geomag-forecast.json
    // Uppdaterad URL för NOAA API
    private static final String NOAA_API_KP_INDEX_URL = "https://services.swpc.noaa.gov/json/planetary_k_index_1m.json";
    private static final String NOAA_API_SOLAR_WIND_DENSITY_URL = "https://services.swpc.noaa.gov/json/rtsw/rtsw_wind_1m.json";
    private static final String NOAA_API_BT_BZ_URL = "https://services.swpc.noaa.gov/json/rtsw/rtsw_mag_1m.json";
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @GetMapping
    public SpaceWeather getSpaceWeatherData() throws IOException {
        try {
            // Skapa och skicka en GET-förfrågan till NOAA API
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(NOAA_API_KP_INDEX_URL))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            // Kontrollera om svaret är OK och i JSON-format
            if (response.statusCode() == 200 && response.body().startsWith("[")) {  // Uppdaterat för att hantera en JSON-array
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response.body());
                JsonNode latestData = rootNode.get(rootNode.size() - 1);

                SpaceWeather weatherData = new SpaceWeather();
                weatherData.setKpIndex((latestData.get("kp_index").asDouble())); // Kp-index
                weatherData.setSolarWindSpeed(new SolarWind(800));
                //weatherData.setTimeStamp(latestData.get("time_tag").asText());

                System.out.println("test weather data: " + weatherData);
                System.out.println(latestData);

                return weatherData;
            } else {
                System.err.println("Fel vid hämtning av data från NOAA API: " + response.statusCode());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
