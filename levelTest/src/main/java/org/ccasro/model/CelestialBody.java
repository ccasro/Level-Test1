package org.ccasro.model;

import org.ccasro.interfaces.ScientificDescribable;

public abstract class CelestialBody implements ScientificDescribable {

    private String name;
    private double diameter;
    private int dayLength;

    public CelestialBody(String name, double diameter, int dayLength){
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or empty");
        if (diameter <= 0.0) throw new IllegalArgumentException("diameter must be positive");
        if (dayLength < 0) throw new IllegalArgumentException("dayLength must be positive");
        this.name = name;
        this.diameter = diameter;
        this.dayLength = dayLength;
    }

    public String getName() {
        return name;
    }

    public double getDiameter() {
        return diameter;
    }

    public int getDayLength() {
        return dayLength;
    }

    @Override
    public abstract String getScientificDescription();

}
