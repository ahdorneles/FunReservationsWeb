package org.academiadecodigo.bootcamp.model;

import org.springframework.stereotype.Component;

/**
 * Created by codecadet on 08/04/2017.
 */
@Component

public class Facility {
    private int ID;
    private String name;
    private FacilityType type;
    private String info;
    private String address;
    private int phone;
    private String password;

    public Facility() {
    }

    public Facility(int ID, String password, FacilityType type, String name, String address, int phone, String info){

        this.ID = ID;
        this.password = password;
        this.type = type;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.info = info;

    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(FacilityType type) {
        this.type = type;
    }

    public FacilityType getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getInfo() {
        return info;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pw) {
        this.password = pw;
        // Manager.saveFacilities();
    }


    public void setInfo(String info) {
        this.info = info;
        //Manager.saveFacilities();
    }

    public void setAddress(String address) {
        this.address = address;
        //Manager.saveFacilities();
    }

    public void setPhone(int phone) {
        this.phone = phone;
        //  Manager.saveFacilities();
    }
}
