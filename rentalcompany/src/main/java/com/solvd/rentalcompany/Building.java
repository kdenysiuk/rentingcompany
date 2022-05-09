package com.solvd.rentalcompany;

import java.util.ArrayList;

public class Building {
    private int idBuilding;
    private String bName;
    private String address;
    private Location location;
    private ArrayList<Worker> workers;

    public Building(int idBuilding, String bName, String address, Location location) {
        this.idBuilding = idBuilding;
        this.bName = bName;
        this.address = address;
        this.location = location;
    }

    public int getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(int idBuilding) {
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
}
