package com.auroratracker.backend.models.space.weatherfactors;

public class SolarWind {

    private double speed;

    public SolarWind(double speed) {
        this.speed = speed;
    }


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "SolarWind speed***:" + speed;
    }
}
