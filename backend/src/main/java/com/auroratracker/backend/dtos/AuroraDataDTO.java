package com.auroratracker.backend.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuroraDataDTO {

    private double kpIndex;
    private double solarWindSpeed;
    private double solarWindDensity;
    private double imfBz;
    private double dst;
    private String analysis;

    public AuroraDataDTO(double kpIndex, double solarWindSpeed, double solarWindDensity, double imfBz, double dst, String analysis) {
        this.kpIndex = kpIndex;
        this.solarWindSpeed = solarWindSpeed;
        this.solarWindDensity = solarWindDensity;
        this.imfBz = imfBz;
        this.dst = dst;
        this.analysis = analysis;
    }

    public AuroraDataDTO() {}

}
