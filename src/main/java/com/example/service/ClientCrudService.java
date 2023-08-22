package com.example.service;

import com.example.dto.Client;
import org.hibernate.Session;
import com.example.utils.HibernateUtil;

public class ClientCrudService {
    public void createOrUpdateClient(Client client) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        }
    }

    public Client getClientById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void deleteClientById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null) {
                session.delete(client);
            }
            session.getTransaction().commit();
        }
    }
}
