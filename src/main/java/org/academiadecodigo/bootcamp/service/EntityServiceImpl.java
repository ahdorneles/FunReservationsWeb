package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Entity;
import org.academiadecodigo.bootcamp.model.dao.EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by codecadet on 09/04/2017.
 */

@Service
public class EntityServiceImpl implements EntityService<Entity> {

    @Autowired
    private EntityDao entityDao;

    public EntityServiceImpl() {
    }

    public EntityServiceImpl(EntityDao entityDao) {
        this.entityDao = entityDao;
    }


    @Override
    public void edit(Entity type) {

    }

    @Override
    public void delete(Entity type) {

    }

    @Override
    public Entity findById(Integer id) {
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

        Entity entity = entityDao.findByName(username);
        return entity != null && entity.getPassword().equals(password);

    }

    @Override
    public void add(Entity type) {

    }

    @Override
    public Entity findByName(String username) {
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
    public List<Entity> findAll() {
        return null;
    }
}
