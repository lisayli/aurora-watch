package com.auroratracker.desktop.model;

public class AuroraData {

    private double kpIndex;
    private double solarWindSpeed;
    private double solarWindDensity;
    private double imfBz;
    private double dst;
    private String analysis;



    public double getKpIndex() {
        return kpIndex;
    }

    public void setKpIndex(double kpIndex) {
        this.kpIndex = kpIndex;
    }

    public double getSolarWindSpeed() {
        return solarWindSpeed;
    }

    public void setSolarWindSpeed(double solarWindSpeed) {
        this.solarWindSpeed = solarWindSpeed;
    }

    public double getSolarWindDensity() {
        return solarWindDensity;
    }

    public void setSolarWindDensity(double solarWindDensity) {
        this.solarWindDensity = solarWindDensity;
    }

    public double getImfBz() {
        return imfBz;
    }

    public void setImfBz(double imfBz) {
        this.imfBz = imfBz;
    }

    public double getDst() {
        return dst;
    }

    public void setDst(double dst) {
        this.dst = dst;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}
