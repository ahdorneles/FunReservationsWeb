package org.academiadecodigo.bootcamp.utils;

import org.academiadecodigo.bootcamp.model.Facility;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.UserService;

/**
 * Created by codecadet on 05/04/2017.
 */
public class Authenticator {

    private UserService userService;

    public  boolean authenticate(String username, String password) {

        if (userService.findByName(username) instanceof User) {

            User user = (User) userService.findByName(username);
            return user != null && user.getPassword().equals(password);

        } else if (userService.findByName(username) instanceof Facility) {
            Facility facility = (Facility) userService.findByName(username);
            return facility != null && facility.getPassword().equals(password);


        }
        return false;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

