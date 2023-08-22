package test;

import com.example.dto.Planet;
import com.example.service.PlanetCrudService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PlanetCrudServiceTest {

    private PlanetCrudService planetService;

    @Before
    public void setUp() {
        planetService = new PlanetCrudService();
    }

    @Test
    public void testCreateOrUpdatePlanet() {
        Planet planet = new Planet("MARS", "Mars");
        planetService.createOrUpdatePlanet(planet);

        Planet retrievedPlanet = planetService.getPlanetById(planet.getId());
        assertEquals("Mars", retrievedPlanet.getName());
    }

    @Test
    public void testDeletePlanet() {
        Planet planet = new Planet("VEN", "Venus");
        planetService.createOrUpdatePlanet(planet);

        planetService.deletePlanetById(planet.getId());

        assertNull(planetService.getPlanetById(planet.getId()));
    }

    @After
    public void tearDown() {
        planetService = null;
    }
}
