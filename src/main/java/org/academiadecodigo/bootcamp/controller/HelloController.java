package org.academiadecodigo.bootcamp.controller;


import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.ReservationDao;

import org.academiadecodigo.bootcamp.service.EntityService;
import org.academiadecodigo.bootcamp.service.EntityServiceImpl;
import org.academiadecodigo.bootcamp.service.UserService;

import org.academiadecodigo.bootcamp.utils.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

/**
 * Created by codecadet on 04/04/2017.
 */

@Controller
@SessionAttributes

public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private EntityService entityService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String showLogin(Model model, @ModelAttribute(Names.USER) User user) {

        return Names.LOGIN;


    }

    @RequestMapping(method = RequestMethod.POST, value = {"/login", "/"})
    public String doLogin(Model model,  @Valid @ModelAttribute(Names.USER) User user, BindingResult bindingResult) {



        if (bindingResult.hasErrors()) {
            System.out.println("binding");
            return Names.LOGIN;
        }

        // If auth succeeds, render a new view
        if (userService.authenticate(user.getUsername(), user.getPassword())) {



            User tempUser = (User) userService.findByName(user.getUsername());

            System.out.println("HELLO CONTROLLER " + tempUser.getUsername());
            System.out.println("HELLO CONTROLLER " + tempUser.getPassword());
            System.out.println("HELLO CONTROLLER " + tempUser.getId());

            model.addAttribute("user", tempUser);
            model.addAttribute(Names.USER_LIST, reservationDao.findByUserid(tempUser.getId()));


/*
            model.addAttribute(Names.USER_LIST, userService.findAll());
*/
            model.addAttribute(Names.GREETING, "Welcome, darling");
            return Names.MAIN;

            // If auth fails, render the same view with error message
        } else {
            model.addAttribute(Names.ERROR, "Authentication Failure");
            return Names.LOGIN;

        }
    }



    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}


