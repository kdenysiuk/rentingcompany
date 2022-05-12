package com.solvd.rentalcompany.entity;

import java.util.ArrayList;

public class VehiclesHasOrder {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Order> order;
    private String dateOfOrder;

    public VehiclesHasOrder(ArrayList<Vehicle> vehicles, ArrayList<Order> orders, String dateOfOrder) {
        this.vehicles = vehicles;
        this.order = orders;
        this.dateOfOrder = dateOfOrder;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Order> order) {
        this.order = order;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}
