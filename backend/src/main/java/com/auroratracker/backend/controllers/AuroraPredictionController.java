package com.auroratracker.backend.controllers;

import com.auroratracker.backend.dtos.AuroraDataDTO;
import com.auroratracker.backend.services.AuroraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aurora/predic")
public class AuroraPredictionController {


    private final AuroraService auroraService;

    public AuroraPredictionController(AuroraService auroraService) {
        this.auroraService = auroraService;
    }

    @GetMapping
    public AuroraDataDTO predictAurora() {
        return auroraService.calculateAuroraPrediction();
    }
}
