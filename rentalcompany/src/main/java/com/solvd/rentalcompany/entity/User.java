package com.solvd.rentalcompany.entity;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"idUser", "uName", "telephone", "email", "license"})
public class User {
    private int idUser;
    private String uName;
    private String telephone;
    private String email;
    private License license;

    public User(String uName, String telephone, String email, License licenseIdlicense) {
        this.uName = uName;
        this.telephone = telephone;
        this.email = email;
        this.license = licenseIdlicense;
    }

    public User() {

    }

    public int getIdUser() {
        return idUser;
    }
    @XmlAttribute
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getuName() {
        return uName;
    }
    @XmlElement(name = "uName")
    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getTelephone() {
        return telephone;
    }
    @XmlElement(name = "telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }
    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    public License getLicense() {
        return license;
    }
    @XmlElement(name = "license")
    public void setLicense(License license) {
        this.license = license;
    }
}
