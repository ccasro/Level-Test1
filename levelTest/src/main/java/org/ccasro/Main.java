package org.ccasro;

import org.ccasro.exceptions.DuplicateCelestialBodyException;
import org.ccasro.model.CelestialBody;
import org.ccasro.model.Moon;
import org.ccasro.model.Planet;
import org.ccasro.model.Star;
import org.ccasro.service.SystemService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SystemService service = new SystemService();

        List<CelestialBody> bodies = List.of(
                new Star("Sun",10000000.0,0,5778,"G2V-type"),
                new Moon("Moon",3474.0,708,"Earth",true),
                new Moon("Moon2",3474.0,708,"Earth",false),
                new Planet("Earth",12742.0,24,1,true),
                new Planet("Earth",12742.0,24,1,true),
                new Planet("Saturn",100002.0,10,274,true));

        for (CelestialBody body : bodies){
            try {
                service.addBody(body);
            } catch (DuplicateCelestialBodyException e){
                System.out.println("Warning: " + e.getMessage());
            }
        }

        service.listScientificDescriptions().forEach(System.out::println);

        System.out.println("Planets with atmosphere");
        for (Planet planet : service.getPlanetsWithAtmosphere()){
            System.out.println(planet.getName());
        }

        String planet = "Earth";
        System.out.println("Moons for planet: " + planet);
        for (Moon moon : service.getMoonsOrbitPlanet(planet)){
            System.out.println(moon.getName());
        }

        service.printHabitabilityReports();
    }
}