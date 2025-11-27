package org.ccasro.model;

public class Star extends CelestialBody{

    private double surfaceTemperatureK;
    private String spectral_Type;

    public Star(String name, double diameter, int dayLength, double surfaceTemperatureK, String spectral_Type){
        super(name,diameter,dayLength);
        if (surfaceTemperatureK < 0.0) throw new IllegalArgumentException("surface temperature must be positive");
        if (spectral_Type == null || spectral_Type.isBlank()) throw new IllegalArgumentException("spectral type cannot be null");
        this.surfaceTemperatureK = surfaceTemperatureK;
        this.spectral_Type = spectral_Type;
    }


    public double getSurfaceTemperatureK() {
        return surfaceTemperatureK;
    }

    public String getSpectral_Type() {
        return spectral_Type;
    }

    @Override
    public String getScientificDescription() {
        return "The " + getName() + " is a " + spectral_Type + "star with a surface temperature of " + surfaceTemperatureK + " It is the main source of energy for the solar system. ";
    }

}
