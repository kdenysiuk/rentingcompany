package com.solvd.rentalcompany.entity;

public class Insurance {
    private long idInsurance;
    private String iName;
    private int price;
    private String insuranceType;

    public Insurance(long idInsurance, String iName, int price, String insuranceType) {
        this.idInsurance = idInsurance;
        this.iName = iName;
        this.price = price;
        this.insuranceType = insuranceType;
    }

    public Insurance(String iName, int price, String insuranceType) {
        this.iName = iName;
        this.price = price;
        this.insuranceType = insuranceType;
    }

    public Insurance() {
    }

    public long getIdInsurance() {
        return idInsurance;
    }

    public void setIdInsurance(long idInsurance) {
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
