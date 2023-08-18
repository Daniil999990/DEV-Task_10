package com.example.service;

import com.example.dto.Client;
import com.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientCrudService {
    public Client getClientById(long id) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void createOrUpdateClient(Client client) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Transaction transaction = session.getTransaction();
            try {
                transaction.begin();
                session.saveOrUpdate(client);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                throw e;
            }
        }
    }

    public void deleteClientById(long id) {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            Transaction transaction = session.getTransaction();
            try {
                transaction.begin();
                Client client = session.get(Client.class, id);
                if (Objects.nonNull(client)) {
                    session.remove(client);
                } else {
                    throw new RuntimeException("Client not found");
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

    public List<Client> getAllClients() {
        try (Session session = HibernateUtil.getConfiguration().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }
}
