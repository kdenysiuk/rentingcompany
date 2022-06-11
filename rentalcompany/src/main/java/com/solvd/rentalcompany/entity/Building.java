package com.solvd.rentalcompany.entity;

import java.util.ArrayList;

public class Building {
    private long idBuilding;
    private String bName;
    private String address;
    private Location location;
    private ArrayList<Worker> workers;

    public Building(long idBuilding, String bName, String address, Location location) {
        this.idBuilding = idBuilding;
        this.bName = bName;
        this.address = address;
        this.location = location;
    }

    public Building(String bName, String address, Location location) {
        this.bName = bName;
        this.address = address;
        this.location = location;
    }

    public Building(long idBuilding, String bName, String address) {
        this.idBuilding = idBuilding;
        this.bName = bName;
        this.address = address;
    }

    public Building() {
    }

    public long getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(long idBuilding) {
        this.idBuilding = idBuilding;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Building{" +
                "idBuilding=" + idBuilding +
                ", bName='" + bName + '\'' +
                ", address='" + address + '\'' +
                ", location=" + location +
                ", workers=" + workers +
                '}';
    }
}
