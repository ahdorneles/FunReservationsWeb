package org.academiadecodigo.bootcamp.model;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.GregorianCalendar;

/**
 * Created by codecadet on 09/04/17.
 */
public class Reservation {

    private Integer id;
    private Integer facilityID;
    private Integer userID;
    private Date date;


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public Reservation() {
    }

    public Integer getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(Integer facilityID) {
        this.facilityID = facilityID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Reservation(Integer userID, Integer facilityID, Date date) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFacility() {
        return facilityID;
    }

    public void setFacility(Integer facilityID) {
        this.facilityID = facilityID;
    }

    public Integer getUser() {
        return userID;
    }

    public void setUser(Integer userID) {
        this.userID = userID;
    }

}
