package com.solvd.rentalcompany.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"idLicense", "num", "expirationDate"})
@JsonPropertyOrder({"idLicense", "num", "expirationDate"})
public class License {
    @JsonProperty
    private long idLicense;
    @JsonProperty("License Number")
    private String num;
    @JsonProperty
    private int expirationDate;

    public License(String num, int expirationDate) {
        this.num = num;
        this.expirationDate = expirationDate;
    }

    public License() {

    }

    public License(long idLicense, String num, int expirationDate) {
        this.idLicense = idLicense;
        this.num = num;
        this.expirationDate = expirationDate;
    }

    @XmlAttribute
    public void setIdLicense(long idLicense) {
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

    public long getIdLicense() {
        return idLicense;
    }

    public String getNum() {
        return num;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "License{" +
                "num='" + num + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
