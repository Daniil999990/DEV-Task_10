package test;

import com.example.dto.Planet;
import com.example.service.PlanetCrudService;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlanetCrudServiceTest {
    private PlanetCrudService planetService;

    @Before
    public void init() {
        planetService = new PlanetCrudService();
    }

    @Test
    public void successfulFindPlanetById() {
        Planet mars = planetService.getPlanetById("MARS");
        Assert.assertEquals("Mars", mars.getName());
    }

    @Test
    public void unSuccessfulFindPlanetById() {
        Assert.assertThrows(Exception.class, () -> planetService.getPlanetById("adadada"));
    }

    @Test
    public void unSuccessfulUpdatePlanetTest() {
        Assert.assertThrows(Exception.class, () -> planetService.updatePlanetById("LIAK", "Mercury"));
    }

    @Test
    public void unSuccessfulDeletePlanetTest() {
        Assert.assertThrows(Exception.class, () -> planetService.deletePlanetById("UDA"));
    }

    @Test
    public void createPlanetTest() {
        Session session = HibernateUtil.getConfiguration().openSession();
        planetService.createPlanet("KARS", "Kars");
        Planet planet = session.find(Planet.class, "KARS");
        Assert.assertEquals("Kars", planet.getName());
        session.close();
    }

    @Test
    public void deletePlanetTest() {
        planetService.createPlanet("KAFS", "Kars");
        planetService.deletePlanetById("KAFS");

        Assert.assertThrows(RuntimeException.class, () -> planetService.getPlanetById("KAFS"));
    }

    @After
    public void destroy() {
        planetService = null;
    }
}
