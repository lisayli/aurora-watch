package com.auroratracker.backend.controllers;

import com.auroratracker.backend.models.space.weatherfactors.KPIndex;
import com.auroratracker.backend.services.KPIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/aurora/kp")
public class KPIndexController {

    private final KPIndexService kpIndexService;

    @Autowired
    public KPIndexController(KPIndexService kpIndexService) {
        this.kpIndexService = kpIndexService;
    }

    @GetMapping()
    public ResponseEntity<String> getKpIndex() {
        Optional<KPIndex> kpIndexOptional = kpIndexService.fetchLatestKpIndex();

        if (kpIndexOptional.isPresent()) {
            KPIndex kpIndex = kpIndexOptional.get();
            System.out.println(kpIndex);
            return ResponseEntity.ok(kpIndex.toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Could not retrieve KP Index data.");
        }
    }
}
