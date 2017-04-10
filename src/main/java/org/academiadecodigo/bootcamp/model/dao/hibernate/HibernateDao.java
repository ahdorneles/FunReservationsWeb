package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.dao.Dao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public abstract class HibernateDao<T> implements Dao<T> {




    private Class<T> type;

    @Autowired
    protected HibernateSessionManager hibernateSessionManager;



    public HibernateDao() {
    }

    public HibernateDao(Class<T> type, HibernateSessionManager hibernateSessionManager) {
        this.type = type;
        this.hibernateSessionManager = hibernateSessionManager;
    }

    /**
     * @see Dao#save(Object)
     */
    @Override
    public void save(T dao) {

        try {

            hibernateSessionManager.getSession().saveOrUpdate(dao);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    /**
     * @see Dao#delete(Object)
     */
    @Override
    public void delete(T dao) {

        try {

            hibernateSessionManager.

                    getSession().

                    delete(dao);

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    /**
     * Returns a new dao object corresponding to the first row found
     * in the database table according to the provided query
     * or null if no record was found
     *
     * @param query the object query to use
     * @return the dao object
     */
    @SuppressWarnings("unchecked")
    public T findOne(Query query) {

        try {

            return (T) query.uniqueResult();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    /**
     * Returns a collection view of dao objects corresponding to all database table rows
     * matching the provided object query
     *
     * @param query the object query to use
     * @return the list view
     */
    @SuppressWarnings("unchecked")
    public List<T> findMany(Query query) {

        try {

            return (List<T>) query.list();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {

        try {

            return hibernateSessionManager.getSession().createCriteria(type)
                    .list();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

    /**
     * @see Dao#count()
     */
    public long count() {

        try {

            return (Long) hibernateSessionManager.getSession().createCriteria(type)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }

    }

}
