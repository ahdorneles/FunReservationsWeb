package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.util.List;


/**
 * user service
 */
public interface UserService<T> {


    public void edit(T type);
    public void delete(T type);
    public T findById(Integer id);

    /**
     * Authenticates the user using the given username and password
     * @param username the user name
     * @param password the user password
     * @return true if authenticated
     */
    boolean authenticate(String username, String password);


    public void add (T type);



    public T findByName(String username);

    /**
     * Count the number of existing users
     * @return the number of users
     */
    public long count();


  public List<T> findAll();

}
