package org.ccasro.model;

import org.ccasro.interfaces.Habitable;

public class Planet extends CelestialBody implements Habitable {

    private int moonCount;
    private boolean hasAtmosphere;

    public Planet(String name, double diameter, int dayLength, int moonCount, boolean hasAtmosphere){
        super(name,diameter,dayLength);
        if (moonCount < 0 ) throw new IllegalArgumentException("moon count must be positive");

        this.moonCount = moonCount;
        this.hasAtmosphere = hasAtmosphere;
    }

    public int getMoonCount() {
        return moonCount;
    }


    @Override
    public boolean isPotentiallyHabitable() {
        return hasAtmosphere;
    }

    @Override
    public String getHabitabilityReport(){
        return hasAtmosphere ? getName() + " Potentially habitable. " : getName() + " Not habitable.";
    }
    @Override
    public String getScientificDescription() {
        String hasAtmospherePart = hasAtmosphere ? "Possesses an atmosphere" : "Does not possess an atmosphere.";
        return "The " + getName() + " has a diameter of  " + getDiameter() + "km and " + hasAtmospherePart + " It has " + moonCount;
    }
}
