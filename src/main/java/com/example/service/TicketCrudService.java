package com.example.service;

import com.example.dto.Client;
import com.example.dto.Planet;
import com.example.dto.Ticket;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TicketCrudService {

    public Ticket getTicketById(long id) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket == null) {
                throw new RuntimeException("Ticket not found");
            }
            return ticket;
        }
    }

    public void createTicket(Client client, Planet planetTo, Planet planetFrom) {
        Transaction transaction = null;
        Ticket ticket = new Ticket();
        setTicketAttributes(client, planetTo, planetFrom, ticket);
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.remove(ticket);
            } else {
                throw new RuntimeException("Ticket not found by id");
            }
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public void updateById(Long id, String nameClient, String planetToName, String planetFromName) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                Client client = ticket.getClient();
                client.setName(nameClient);

                Planet toPlanet = ticket.getToPlanet();
                toPlanet.setName(planetToName);

                Planet fromPlanet = ticket.getFromPlanet();
                fromPlanet.setName(planetFromName);

                ticket.setCreatedAt(new Timestamp(new Date().getTime()));

                session.persist(ticket);
                transaction.commit();
            } else {
                throw new RuntimeException("Ticket not found, you need to create");
            }
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public List<Ticket> getAll() {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private void setTicketAttributes(Client client, Planet planetTo, Planet planetFrom, Ticket ticket) {
        ticket.setClient(client);
        ticket.setToPlanet(planetTo);
        ticket.setFromPlanet(planetFrom);
        ticket.setCreatedAt(new Timestamp(new Date().getTime()));
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
    }
}
