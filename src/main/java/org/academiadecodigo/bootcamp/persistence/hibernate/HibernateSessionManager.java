package org.academiadecodigo.bootcamp.persistence.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class HibernateSessionManager {

    private final static String HIBERNATE_CONFIG = "persistence/hibernate.cfg.xml";

    /**
     * Factory of hibernate Sessions, which consist on single-threaded,
     * short-lived objects, conceptually modeling a "Unit of Work"
     */

    @Autowired
    private SessionFactory sessionFactory;

    private HibernateSessionManager() {
    }

    /**
     * Initiates a new transaction
     *
     * @return the session associated with the transaction
     */
    public Session beginTransaction() {
        Session session = getSession();
        session.beginTransaction();
        return session;
    }

    /**
     * Terminates the current transaction
     */
    public void commitTransaction() {
        getSession().getTransaction().commit();
    }

    /**
     * Rollback the current transaction
     */
    public void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }

    /**
     * Obtains the current session from the hibernate session factory
     *
     * @return The current session
     */
    public Session getSession() {


        return sessionFactory.getCurrentSession();
    }

    /**
     * Closes the hibernate Session factory,
     * necessary for application to quit
     */
    public void close() {
        sessionFactory.close();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
