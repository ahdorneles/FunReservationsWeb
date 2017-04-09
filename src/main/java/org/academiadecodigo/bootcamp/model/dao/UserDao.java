package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.TransactionException;

public interface UserDao extends Dao<User> {

    public User findByName(String name);

}
