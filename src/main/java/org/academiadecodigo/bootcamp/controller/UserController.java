package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.UserService;
import org.academiadecodigo.bootcamp.utils.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by codecadet on 05/04/2017.
 */

@Controller
@SessionAttributes

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public String listUsers(Model model) {
        model.addAttribute(Names.USER_LIST, userService.findAll());
        return "main";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    public String addUser(Model model, @ModelAttribute ("user") User user,  RedirectAttributes redirectAttributes) {

        User tempUser = (User) userService.findByName(user.getUsername());


        System.out.println(user.getId());
        System.out.println(user.getUsername());

        tempUser.setEmail(user.getEmail());
        tempUser.setUsername(user.getUsername());
        tempUser.setPassword(user.getPassword());

        if (tempUser.getId() == null) {
            tempUser.setId(userService.findAll().size() + 1);
            userService.add(tempUser);
        }

        redirectAttributes.addFlashAttribute(user);
        return "redirect:/users";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") Integer id, User user, RedirectAttributes redirectAttributes) {

        User user1 = (User) userService.findById(id);
        userService.delete(user1);
        redirectAttributes.addFlashAttribute(user1);
        return "redirect:/users";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/reset")
    public String resetUser(Model model, @ModelAttribute User user, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/users";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {

        System.out.println("id que vem " + id);
        User user = (User) userService.findById(id);




        System.out.println(user.getId());

        System.out.println(user.getUsername());

        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/users";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public String logout(Model model, @ModelAttribute User user, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(user);
        return "redirect:/login";

    }


}
