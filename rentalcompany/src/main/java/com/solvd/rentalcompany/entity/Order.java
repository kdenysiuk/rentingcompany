package com.solvd.rentalcompany.entity;

import java.util.ArrayList;

public class Order {
    private long idOrder;
    private String orderDate;
    private User user;
    private Insurance insurance;
    private Worker worker;
    private ArrayList<Vehicle> vehicles;

    public Order(long idOrder, String orderDate, User user, Insurance insurance, Worker worker) {
        this.idOrder = idOrder;
        this.orderDate = orderDate;
        this.user = user;
        this.insurance = insurance;
        this.worker = worker;
    }

    public Order(String orderDate, User user, Insurance insurance, Worker worker) {
        this.orderDate = orderDate;
        this.user = user;
        this.insurance = insurance;
        this.worker = worker;
    }

    public Order() {
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }



    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", orderDate='" + orderDate + '\'' +
                ", user=" + user +
                ", insurance=" + insurance +
                ", worker=" + worker +
                '}';
    }
}
