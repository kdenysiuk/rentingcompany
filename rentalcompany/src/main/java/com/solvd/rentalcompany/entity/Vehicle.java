package com.solvd.rentalcompany.entity;

public class Vehicle {
    private int idVehicle;
    private String licensePlate;
    private Model model;

    public Vehicle(int idVehicle, String licensePlate, Model model) {
        this.idVehicle = idVehicle;
        this.licensePlate = licensePlate;
        this.model = model;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
