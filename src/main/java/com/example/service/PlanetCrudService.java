package com.example.service;

import com.example.dto.Planet;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {

    public Planet getPlanetById(String id) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Planet planet = session.get(Planet.class, id);
            if (planet == null) {
                throw new RuntimeException("Planet not found");
            }
            return planet;
        }
    }

    public void createPlanet(String id, String name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Planet planet = new Planet();
            planet.setId(id);
            planet.setName(name);
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public void deletePlanetById(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.remove(planet);
                transaction.commit();
            } else {
                throw new RuntimeException("Planet not found");
            }
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public void updatePlanetById(String id, String name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                planet.setName(name);
                transaction.commit();
            } else {
                throw new RuntimeException("Planet not found");
            }
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public List<Planet> getAllPlanets() {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
    }
}
