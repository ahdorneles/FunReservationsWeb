package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService<User> {

    public UserServiceImpl() {
    }

    @Autowired
    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findById(Integer id) {
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

        User user = userDao.findByName(username);
        return user != null && user.getPassword().equals(password);

    }

    @Override
    public void add(User user) {
        if (userDao.findByName(user.getUsername()) == null) {
            userDao.save(user);
        }

    }


    /**
     * Finds a user by name
     *
     * @param username the user name used to lookup a user
     * @return a new User if found, null otherwise
     */
    @Override
    public User findByName(String username) {

        return userDao.findByName(username);

    }

    /**
     * Count the number of existing users
     *
     * @return the number of users
     */
    @Override
    public long count() {

        return userDao.count();

    }

    @Override
    public List<User> findAll() {
        return null;
    }

}
