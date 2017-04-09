package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.util.List;

/**
 * Created by codecadet on 05/04/2017.
 */
public class MockUserService implements UserService {

    public List<User> userList;

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public void add(Object type) {

    }

    /* @Override
         public boolean authenticate(String username, String password) {

             return findByName(username) != null && findByName(username).getPassword().equals(password);
         }
     */
    public void addUser(User u) {

        if (u.getId() == null) {
            u.setId((int)count() + 1);

        }
        System.out.println("Adding user" + u.getUsername());
        userList.add(u);
    }


    public void deleteUser(User user) {
        userList.remove(user);

    }

    public void editUser(User user) {


        User user1 = (User) findById(user.getId());

        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());

    }

    @Override
    public List<User> findAll() {
        return userList;
    }


    @Override
    public User findByName(String username) {

        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void edit(Object type) {

    }

    @Override
    public void delete(Object type) {

    }

    @Override
    public Object findById(Integer id) {
        return null;
    }




    @Override
    public long count() {
        return (long) userList.size();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
