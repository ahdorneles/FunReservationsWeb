package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.Reservation;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.model.dao.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by codecadet on 09/04/17.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationDao reservationDao;


    @Override
    public List<Reservation> findUserReservations(Integer userID) {
        return reservationDao.findByUserid(userID);
    }

    @Override
    public List<Reservation> freeReservations(Integer facilityID, Date date) {
        return null;
    }


    @Override
    public void makeReservation(User user, Integer facilityID, Date date) {
        reservationDao.save(new Reservation(user.getId(), facilityID, date));

    }

    @Override
    public void deleteReservation(Integer reservationID) {
        reservationDao.delete(reservationDao.findByID(reservationID));

    }
}
