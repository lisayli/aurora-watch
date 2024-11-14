package com.auroratracker.backend.controllers.weatherfactors;

import com.auroratracker.backend.models.space.weatherfactors.IMFData;
import com.auroratracker.backend.services.weatherfactors.IMFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/aurora")
public class IMFController {


    private final IMFService imfService;

    @Autowired
    public IMFController(IMFService imfService) {
        this.imfService = imfService;
    }

    @GetMapping("/imf")
    public ResponseEntity<IMFData> getIMFData() {
        IMFData imfData = imfService.fetchLatestIMFData();

        if (imfData != null) {
            System.out.println("Bt: " + imfData.getBt() + "\n" + "Bz: " + imfData.getBz());
            return ResponseEntity.ok(imfData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
