package org.ccasro.service;

import org.ccasro.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class SystemServiceTest {

    private SystemService service;
    @BeforeEach
    void setup() {
        service = new SystemService();

        service.addBody(new Star("Sun",10000000.0,0,5778,"G2V-type"));
        service.addBody(new Moon("Moon",3474.0,708,"Earth",true));
        service.addBody(new Moon("Moon2",3474.0,708,"Earth",true));
        service.addBody(new Planet("Earth",12742.0,24,1,true));
        service.addBody(new Planet("Saturn",100002.0,10,274,true));
    }

    @Test
    void testListScientificDescriptions(){
        List<String> descriptions = service.listScientificDescriptions();

        assertThat(descriptions).hasSize(5).anySatisfy(desc -> assertThat(desc).contains("G2V-type"))
                .anySatisfy(desc->assertThat(desc).contains("Earth"));
    }

    @Test
    void testFilterPlanetsWithAtmosphere(){
        List<Planet> planetsAtmosphere = service.getPlanetsWithAtmosphere();

        assertThat(planetsAtmosphere).hasSize(2).allSatisfy(planet -> assertThat(planet.isPotentiallyHabitable()).isTrue());
    }

    @Test
    void testFilterMoonsByPlanet(){
        List<Moon> planetMoons = service.getMoonsOrbitPlanet("Earth");

        assertThat(planetMoons).hasSize(2).allSatisfy(moon -> assertThat(moon.getOrbitPlanet()).isEqualTo("Earth"));
    }
}
