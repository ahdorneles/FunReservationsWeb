package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.ReservationService;
import org.academiadecodigo.bootcamp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;

/**
 * Created by codecadet on 09/04/17.
 */
public class UserHomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public String listReservations(Model model, @ModelAttribute("user")User user) {
        model.addAttribute("LISTA DE RESERVAS", reservationService.findReservations(user.getId()));
        return "/home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/freereservation/{date}/{facility}")
    public String getAvailableReservations(Model model, @PathVariable("date")GregorianCalendar date,
                                           @PathVariable("facility")Integer facilityID) {

        model.addAttribute("LISTA DE RESERVAS LIVRES", reservationService.freeReservations(facilityID, date));

        return "/home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addreservation/{date}/{facility}")
    public String makeReservation(Model model, @PathVariable("date")GregorianCalendar date,
                                           @PathVariable("facility")Integer facilityID) {

        reservationService.makeReservation(facilityID, date);

        return "/home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deletereservation/{reservation}")
    public String removeReservations(Model model, @PathVariable("reservation")Integer reservationID) {

        reservationService.deleteReservation(reservationID);

        return "/home";
    }


}
