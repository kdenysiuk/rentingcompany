package com.solvd.rentalcompany;

public class Vehicles {
    private int idVechicles;
    private String licensePlate;
    private int licenseIdLicense;

    public Vehicles(int idVechicles, String licensePlate, int licenseIdLicense) {
        this.idVechicles = idVechicles;
        this.licensePlate = licensePlate;
        this.licenseIdLicense = licenseIdLicense;
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

    public int getLicenseIdLicense() {
        return licenseIdLicense;
    }

    public void setLicenseIdLicense(int licenseIdLicense) {
        this.licenseIdLicense = licenseIdLicense;
    }
}
