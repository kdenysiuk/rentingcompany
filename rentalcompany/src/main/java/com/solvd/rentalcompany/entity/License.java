package com.solvd.rentalcompany.entity;

public class License {
    private int idLicense;
    private String num;
    private int expirationDate;

    public License(String num, int expirationDate) {
        this.num = num;
        this.expirationDate = expirationDate;
    }

    public License() {

    }

    public void setIdLicense(int idLicense) {
        this.idLicense = idLicense;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getIdLicense() {
        return idLicense;
    }

    public String getNum() {
        return num;
    }

    public int getExpirationDate() {
        return expirationDate;
    }
}
