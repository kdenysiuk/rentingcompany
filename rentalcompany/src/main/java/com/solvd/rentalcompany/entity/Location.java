package com.solvd.rentalcompany.entity;

import java.util.LinkedList;

public class Location {
    private long idLocation;
    private String city;
    private LinkedList<Building> buildings;

    public Location(long idLocation, String city) {
        this.idLocation = idLocation;
        this.city = city;
    }

    public Location(String city) {
        this.city = city;
    }

    public Location() {
    }

    public long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(long idLocation) {
        this.idLocation = idLocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
