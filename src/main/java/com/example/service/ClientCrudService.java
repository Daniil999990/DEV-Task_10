package com.example.service;

import com.example.dto.Client;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {

    public Client getClientById(long id) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Client client = session.get(Client.class, id);
            if (client == null) {
                throw new RuntimeException("Client not found");
            }
            return client;
        }
    }

    public void createClient(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public void updateClient(long id, String name) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                client.setName(name);
                session.persist(client);
                transaction.commit();
            } else {
                throw new RuntimeException("Client not found");
            }
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public void deleteById(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.remove(client);
                transaction.commit();
            } else {
                throw new RuntimeException("Client not found");
            }
        } catch (Exception e) {
            rollbackTransaction(transaction);
        }
    }

    public List<Client> getAllClients() {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
    }
}
