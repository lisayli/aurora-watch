package com.auroratracker.backend.controllers.weatherfactors;


import com.auroratracker.backend.models.space.weatherfactors.Dst;
import com.auroratracker.backend.services.weatherfactors.DstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/aurora")
public class DstController {

    private final DstService dstService;

    @Autowired
    public DstController(DstService dstService) {
        this.dstService = dstService;
    }


    @GetMapping("/dst")
    public ResponseEntity<Dst> getDstIndex() {
        Dst dst = dstService.fetchLatestDstData();

        if (dst != null) {
            System.out.println(dst);
            return ResponseEntity.ok(dst);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
