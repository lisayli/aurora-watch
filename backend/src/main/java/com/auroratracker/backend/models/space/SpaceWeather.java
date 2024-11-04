package com.auroratracker.backend.models.space;

import com.auroratracker.backend.models.space.weatherfactors.SolarWind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpaceWeather  {
    /**
     * TODO: Skapa underklasser med dess relevanta data
     * Koppla ihop dessa klasser
     */
    private double kpIndex;
    private SolarWind solarWindSpeed;
    private double solarWindDensity;
    private double imf; // Interplanetary Magnetic Field
    private double dstIndex;
    private String timeStamp;




    @Override
    public String toString() {
        return "\n Date***: " + timeStamp + "\n Kp-index**: " + kpIndex;
    }


}
