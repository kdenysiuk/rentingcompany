package com.solvd.rentalcompany;

public class License {
    private int idLicense;
    private String num;
    private int expirationDate;

    public License(int idLicense, String num, int expirationDate) {
        this.idLicense = idLicense;
        this.num = num;
        this.expirationDate = expirationDate;
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
