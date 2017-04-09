package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by codecadet on 08/04/2017.
 */

@Repository
@Transactional
public class HibernateUserDao extends HibernateDao<User> implements UserDao {

    @Autowired
    private HibernateSessionManager sessionManager;

    public HibernateUserDao() {
    }

    public HibernateSessionManager getSessionManager() {
        return sessionManager;
    }

    public HibernateUserDao(Class<User> type, HibernateSessionManager hibernateSessionManager) {
        super(type, hibernateSessionManager);
    }

    public void setSessionManager(HibernateSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }



    @Override
    public User findByName(String name) {



        try {

            Query query = sessionManager.getSession().createQuery("FROM User WHERE username =:username");
            query.setString("username", name);

            return (User) query.uniqueResult();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

}