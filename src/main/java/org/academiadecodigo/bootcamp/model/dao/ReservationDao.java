package org.academiadecodigo.bootcamp.model.dao;

import org.academiadecodigo.bootcamp.model.Reservation;
import org.academiadecodigo.bootcamp.model.dao.Dao;

/**
 * Created by codecadet on 09/04/17.
 */
public interface ReservationDao extends Dao<Reservation>{

    Reservation findByID(Integer reservationID);
}
