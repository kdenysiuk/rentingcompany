package com.solvd.rentalcompany.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "UserList")
@XmlType(propOrder = {"user", "idUser", "uName", "telephone", "email", "license"})
@JsonPropertyOrder({"idUser", "uName", "telephone", "email", "license"})
public class User {
    private long idUser;
    @JsonProperty
    private String uName;
    @JsonProperty
    private String telephone;
    @JsonProperty
    private String email;
    @JsonProperty
    private License license;

    public List<User> user = new ArrayList<>();

    public User(long idUser, String uName, String telephone, String email, License license) {
        this.idUser = idUser;
        this.uName = uName;
        this.telephone = telephone;
        this.email = email;
        this.license = license;
    }

    public User() {
    }

    public User(String uName, String telephone, String email, License license) {
        this.uName = uName;
        this.telephone = telephone;
        this.email = email;
        this.license = license;
    }

    public User(long idUser, String uName, String telephone, String email) {
        this.idUser = idUser;
        this.uName = uName;
        this.telephone = telephone;
        this.email = email;
    }

    public long getIdUser() {
        return idUser;
    }
    @XmlAttribute
    public void setIdUser(long idUser) {
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

    @Override
    public String toString() {
        return "User{" +
                "User Name='" + uName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", license=" + license +
                '}';
    }
}
