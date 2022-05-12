package com.solvd.rentalcompany.entity;

public class License {
    private int idLicense;
    private String num;
    private String expirationDate;

    public License(int idLicense, String num, String expirationDate) {
        this.idLicense = idLicense;
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

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getIdLicense() {
        return idLicense;
    }

    public String getNum() {
        return num;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
