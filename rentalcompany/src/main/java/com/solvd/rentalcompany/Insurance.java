package com.solvd.rentalcompany;

public class Insurance {
    private int idUser;
    private String iName;
    private int price;
    private String insuranceType;

    public Insurance(int idUser, String iName, int price, String insuranceType) {
        this.idUser = idUser;
        this.iName = iName;
        this.price = price;
        this.insuranceType = insuranceType;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }
}
