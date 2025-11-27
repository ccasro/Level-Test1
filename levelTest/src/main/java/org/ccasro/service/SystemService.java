package org.ccasro.service;

import org.ccasro.exceptions.DuplicateCelestialBodyException;
import org.ccasro.interfaces.Habitable;
import org.ccasro.model.CelestialBody;
import org.ccasro.model.Moon;
import org.ccasro.model.Planet;
import org.ccasro.printer.HabitabilityPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SystemService {

    private final List<CelestialBody> bodies = new ArrayList<>();

    public void addBody(CelestialBody celestialBody){

        Optional<CelestialBody> duplicate = bodies.stream()
                .filter(b -> b.getName().equalsIgnoreCase(celestialBody.getName()))
                .findAny();

        duplicate.ifPresent(b -> {
            throw new DuplicateCelestialBodyException("A celestial body with name '%s' is already registered".formatted(celestialBody.getName()));
        });
        bodies.add(celestialBody);
    }

    public List<String> listScientificDescriptions(){
        return bodies.stream().map(CelestialBody::getScientificDescription).toList();
    }

    public List<CelestialBody> getBodies() {
        return List.copyOf(bodies);
    }

    public List<Planet> getPlanetsWithAtmosphere(){
        return bodies.stream().filter(b-> b instanceof Planet planet && planet.isPotentiallyHabitable()).map(b -> (Planet) b).toList();
    }

    public List<Moon> getMoonsOrbitPlanet(String planet){
        if (planet == null || planet.isBlank()){
            return List.of();
        }
        return bodies.stream().filter(b -> b instanceof Moon moon && moon.getOrbitPlanet().equalsIgnoreCase(planet)).map( b-> (Moon) b).toList();
    }

    public void printHabitabilityReports(){
        HabitabilityPrinter printer = new HabitabilityPrinter();

        bodies.stream().filter(b -> b instanceof Habitable).map(b -> (Habitable) b).forEach(printer::printReport);
    }




}
