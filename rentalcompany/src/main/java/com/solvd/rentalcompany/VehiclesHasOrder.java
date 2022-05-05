package com.solvd.rentalcompany;

public class VehiclesHasOrder {
    private int vehiclesIdVehicles;
    private int orderIdOrder;
    private String dateOfOrder;

    public VehiclesHasOrder(int vehiclesIdVehicles, int orderIdOrder, String dateOfOrder) {
        this.vehiclesIdVehicles = vehiclesIdVehicles;
        this.orderIdOrder = orderIdOrder;
        this.dateOfOrder = dateOfOrder;
    }

    public int getVehiclesIdVehicles() {
        return vehiclesIdVehicles;
    }

    public void setVehiclesIdVehicles(int vehiclesIdVehicles) {
        this.vehiclesIdVehicles = vehiclesIdVehicles;
    }

    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }
}
