package org.academiadecodigo.bootcamp.model;

import java.util.GregorianCalendar;

/**
 * Created by codecadet on 09/04/17.
 */
public class Reservation {

    private Integer id;
    private String facility;
    private String user;
    private GregorianCalendar date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
