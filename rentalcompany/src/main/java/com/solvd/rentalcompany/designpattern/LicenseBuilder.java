package com.solvd.rentalcompany.designpattern;


import com.solvd.rentalcompany.entity.License;

public class LicenseBuilder {
    private long idLicense;
    private String num;
    private int expirationDate;

    public LicenseBuilder(long idLicense, String num, int expirationDate) {
        this.idLicense = idLicense;
        this.num = num;
        this.expirationDate = expirationDate;
    }

    public LicenseBuilder() {
    }

    public LicenseBuilder setIdLicense(long idLicense) {
        this.idLicense = idLicense;
        return this;
    }

    public LicenseBuilder setNum(String num) {
        this.num = num;
        return this;
    }

    public LicenseBuilder setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public License build(){
        return new License(num, expirationDate);
    }

    @Override
    public String toString() {
        return "LicenseBuilder{" +
                ", License ID ='" + num + '\'' +
                ", Expiration Date =" + expirationDate +
                '}';
    }
}
