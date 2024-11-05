package com.auroratracker.backend.services.weatherfactors;


import com.auroratracker.backend.models.space.weatherfactors.Dst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DstService {

    private static final String NOAA_API_DST_INDEX_URL = "https://services.swpc.noaa.gov/json/geospace/geospace_dst_1_hour.json";
    private static final Logger logger = LoggerFactory.getLogger(DstService.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;


    public DstService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    private Optional<String> fetchApiData(){
        try {
            return Optional.ofNullable(restTemplate.getForObject(NOAA_API_DST_INDEX_URL, String.class));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Dst> fetchLatestDstData() {
        return fetchApiData()
                .flatMap(this::parseDstData);
    }

    private Optional<Dst> parseDstData(String jsonData) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonData);
            JsonNode latestData = rootNode.get(rootNode.size() - 1);
            double value = latestData.get("dst").asDouble();
            return Optional.of(new Dst(value));
        } catch (JsonProcessingException e) {
            logger.error("Error parsing DST data", e);
            return Optional.empty();
        }
    }


}
