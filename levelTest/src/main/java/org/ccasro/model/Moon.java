package org.ccasro.model;

import org.ccasro.interfaces.Habitable;

public class Moon extends CelestialBody implements Habitable {

    private String orbitPlanet;
    private boolean rockySurface;

    public Moon(String name, double diameter, int dayLength, String orbitPlanet, boolean rockySurface){
        super(name, diameter, dayLength);
        if (orbitPlanet == null || orbitPlanet.isBlank()) throw new IllegalArgumentException("orbitPlanet cannot be null or empty");
        this.orbitPlanet = orbitPlanet;
        this.rockySurface = rockySurface;
    }

    public String getOrbitPlanet() {
        return orbitPlanet;
    }

    @Override
    public boolean isPotentiallyHabitable() {
        return rockySurface;
    }

    @Override
    public String getHabitabilityReport(){
        return rockySurface ? getName() + "Potentially habitable. " : getName() + "Not habitable. ";
    }
    @Override
    public String getScientificDescription() {
        String rockySurfacePart = rockySurface ? "Its surface is rocky" : "Its surface is not rocky.";
        return "The " + getName() + " orbits around the " + orbitPlanet + ". " + rockySurfacePart + " and its diameter is " + getDiameter();
    }
}
