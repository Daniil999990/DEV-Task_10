package com.example.service;


import com.example.dto.Planet;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetCrudService {
    public Planet getPlanetById(String id) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void createOrUpdatePlanet(Planet planet) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Transaction transaction = session.getTransaction();
            try {
                transaction.begin();
                session.saveOrUpdate(planet);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw e;
            }
        }
    }

    public void deletePlanetById(String id) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Transaction transaction = session.getTransaction();
            try {
                transaction.begin();
                Planet planet = session.get(Planet.class, id);
                if (Objects.nonNull(planet)) {
                    session.remove(planet);
                } else {
                    throw new RuntimeException("Planet not found");
                }
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw e;
            }
        }
    }

    public List<Planet> getAllPlanets() {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }
}
