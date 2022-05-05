package com.solvd.rentalcompany;

public class Building {
    private int idBuilding;
    private String bName;
    private String address;
    private int locationIdLocation;

    public Building(int idBuilding, String bName, String address, int locationIdLocation) {
        this.idBuilding = idBuilding;
        this.bName = bName;
        this.address = address;
        this.locationIdLocation = locationIdLocation;
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

    public int getLocationIdLocation() {
        return locationIdLocation;
    }

    public void setLocationIdLocation(int locationIdLocation) {
        this.locationIdLocation = locationIdLocation;
    }
}
