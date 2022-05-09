package com.solvd.rentalcompany;

import java.util.LinkedList;

public class Model {
    private int idModel;
    private String mName;
    private int pricePerDay;
    private Category category;
    private LinkedList<Vehicles> vehicles;

    public Model(int idModel, String mName, int pricePerDay, Category category) {
        this.idModel = idModel;
        this.mName = mName;
        this.pricePerDay = pricePerDay;
        this.category = category;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
