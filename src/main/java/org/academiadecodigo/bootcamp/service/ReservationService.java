package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Reservation;
import org.academiadecodigo.bootcamp.model.User;

import java.sql.Date;
import java.util.List;

/**
 * Created by codecadet on 09/04/17.
 */
public interface ReservationService {
    List<Reservation> findUserReservations(Integer userID);

    List<Reservation> freeReservations(Integer facilityID, Date date);

    void makeReservation(User user, Integer facilityID, Date date);

    void deleteReservation(Integer reservationID);
}
