package com.solvd.rentalcompany.entity;

import java.util.LinkedList;

public class Category {
    private int idCategory;
    private String vehicleType;
    private LinkedList<Model> models;

    public Category(int idCategory, String vehicleType) {
        this.idCategory = idCategory;
        this.vehicleType = vehicleType;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
