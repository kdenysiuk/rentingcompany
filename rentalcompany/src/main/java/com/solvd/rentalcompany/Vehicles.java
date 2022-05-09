package com.solvd.rentalcompany;

public class Vehicles {
    private int idVechicles;
    private String licensePlate;
    private License license;

    public Vehicles(int idVechicles, String licensePlate, License license) {
        this.idVechicles = idVechicles;
        this.licensePlate = licensePlate;
        this.license = license;
    }

    public int getIdVechicles() {
        return idVechicles;
    }

    public void setIdVechicles(int idVechicles) {
        this.idVechicles = idVechicles;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}
