package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Entity;
import org.academiadecodigo.bootcamp.model.Reservation;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by codecadet on 09/04/17.
 */
public interface ReservationService {
    List<Reservation> findReservations(Integer id);

    List<Reservation> freeReservations(Integer facilityID, GregorianCalendar date);

    void makeReservation(Integer facilityID, GregorianCalendar date);

    void deleteReservation(Integer reservationID);
}
