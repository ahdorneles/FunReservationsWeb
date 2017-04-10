package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Facility;
import org.academiadecodigo.bootcamp.model.dao.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by codecadet on 09/04/2017.
 */

@Service
public class EntityServiceImpl implements EntityService<Facility> {

    @Autowired
    private EntityDao entityDao;

    public EntityServiceImpl() {
    }

    public EntityServiceImpl(EntityDao entityDao) {
        this.entityDao = entityDao;
    }


    @Override
    public void edit(Facility type) {

    }

    @Override
    public void delete(Facility type) {

    }

    @Override
    public Facility findById(Integer id) {
        return null;
    }


    /**
     * Authenticates the user using the given username and password
     *
     * @param username the user name
     * @param password the user password
     * @return true if authenticated
     */

    public boolean authenticate(String username, String password) {

        Facility facility = entityDao.findByName(username);
        return facility != null && facility.getPassword().equals(password);

    }

    @Override
    public void add(Facility type) {

    }

    @Override
    public Facility findByName(String username) {
        return null;
    }


    /**
     * Finds a user by name
     *
     * @param username the user name used to lookup a user
     * @return a new User if found, null otherwise
     */


    /**
     * Count the number of existing users
     *
     * @return the number of users
     */
    @Override
    public long count() {

        return entityDao.count();

    }

    @Override
    public List<Facility> findAll() {
        return entityDao.findAll();
    }
}
