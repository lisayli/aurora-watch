package com.auroratracker.backend.models.space.weatherfactors;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SolarWind {

    private double speed;    // Hastighet i km/s
    private double density;  // Täthet i partiklar per kubikcentimeter

    public SolarWind(double speed, double density) {
        this.speed = speed;
        this.density = density;
    }


    @Override
    public String toString() {
        return "Solar wind speed: " + speed + "<br>" + "density: " + density;
    }


}

