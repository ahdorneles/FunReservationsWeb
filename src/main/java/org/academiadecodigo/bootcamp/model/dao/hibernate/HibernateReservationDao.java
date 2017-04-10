package org.academiadecodigo.bootcamp.model.dao.hibernate;

import org.academiadecodigo.bootcamp.model.Reservation;
import org.academiadecodigo.bootcamp.model.dao.ReservationDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.hibernate.HibernateSessionManager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by codecadet on 09/04/17.
 */

@Repository
@Transactional
public class HibernateReservationDao extends HibernateDao<Reservation> implements ReservationDao {

    @Autowired
    private HibernateSessionManager sessionManager;

    @Override
    public Reservation findByID(Integer reservationID) {
        try {

            Query query = sessionManager.getSession().createQuery("FROM Reservation WHERE reservation_id =:reservationID");
            query.setInteger("reservationID", reservationID);

            return (Reservation) query.uniqueResult();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }

    @Override
    public List<Reservation> findByUserid(Integer userId) {
        try {

            Query query = sessionManager.getSession().createQuery("FROM Reservation WHERE client_id =:clientId");
            query.setInteger("clientId", userId);

            return  query.list();

        } catch (HibernateException hex) {
            throw new TransactionException(hex);
        }
    }



    @Override
    public Reservation findByName(String name) {


        return null;
    }
}
