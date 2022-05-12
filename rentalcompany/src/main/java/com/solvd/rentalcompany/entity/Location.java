package com.solvd.rentalcompany.entity;

import java.util.LinkedList;

public class Location {
    private int idLocation;
    private String city;
    private LinkedList<Building> buildings;

    public Location(int idLocation, String city) {
        this.idLocation = idLocation;
        this.city = city;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
