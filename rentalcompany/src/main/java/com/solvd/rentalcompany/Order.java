package com.solvd.rentalcompany;

import java.util.ArrayList;

public class Order {
    private int idOrder;
    private User user;
    private Insurance insurance;
    private Worker worker;
    private ArrayList<Vehicles> vehicles;
    public ArrayList<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public Order(int idOrder, User user, Insurance insurance, Worker worker) {
        this.idOrder = idOrder;
        this.user = user;
        this.insurance = insurance;
        this.worker = worker;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
