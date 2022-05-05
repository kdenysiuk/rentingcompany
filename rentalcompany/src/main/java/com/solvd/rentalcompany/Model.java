package com.solvd.rentalcompany;

public class Model {
    private int idModel;
    private String mName;
    private int pricePerDay;
    private int categoryIdCategory;

    public Model(int idModel, String mName, int pricePerDay, int categoryIdCategory) {
        this.idModel = idModel;
        this.mName = mName;
        this.pricePerDay = pricePerDay;
        this.categoryIdCategory = categoryIdCategory;
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

    public int getCategoryIdCategory() {
        return categoryIdCategory;
    }

    public void setCategoryIdCategory(int categoryIdCategory) {
        this.categoryIdCategory = categoryIdCategory;
    }
}
