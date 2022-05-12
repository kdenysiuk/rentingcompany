package com.solvd.rentalcompany.entity;

public class Insurance {
    private int idInsurance;
    private String iName;
    private int price;
    private String insuranceType;

    public Insurance(int idUser, String iName, int price, String insuranceType) {
        this.idInsurance = idUser;
        this.iName = iName;
        this.price = price;
        this.insuranceType = insuranceType;
    }

    public Insurance() {

    }

    public int getIdInsurance() {
        return idInsurance;
    }

    public void setIdInsurance(int idInsurance) {
        this.idInsurance = idInsurance;
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
