package com.solvd.rentalcompany.entity;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"idLicense", "num", "expirationDate"})
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
    @XmlAttribute
    public void setIdLicense(int idLicense) {
        this.idLicense = idLicense;
    }
    @XmlElement
    public void setNum(String num) {
        this.num = num;
    }
    @XmlElement
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
