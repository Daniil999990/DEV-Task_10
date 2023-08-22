package com.example.service;

import com.example.dto.Planet;
import org.hibernate.Session;
import com.example.utils.HibernateUtil;

public class PlanetCrudService {
    public void createOrUpdatePlanet(Planet planet) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(planet);
            session.getTransaction().commit();
        }
    }

    public Planet getPlanetById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void deletePlanetById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.delete(planet);
            }
            session.getTransaction().commit();
        }
    }
}
