package com.solvd.rentalcompany.designpattern;

import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;

public class UserBuilder {
    private long idUser;
    private String uName;
    private String telephone;
    private String email;
    private License license;

    public UserBuilder(long idUser, String uName, String telephone, String email, License license) {
        this.idUser = idUser;
        this.uName = uName;
        this.telephone = telephone;
        this.email = email;
        this.license = license;
    }

    public UserBuilder(){
    }

    public UserBuilder setIdUser(long idUser) {
        this.idUser = idUser;
        return this;

    }

    public UserBuilder setuName(String uName) {
        this.uName = uName;
        return this;
    }

    public UserBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setLicense(License license) {
        this.license = license;
        return this;
    }

    public User build() {
        return new User(uName, telephone, email, license);
    }

    @Override
    public String toString() {
        return "UserBuilder{" +
                ", User Name ='" + uName + '\'' +
                ", Telephone ='" + telephone + '\'' +
                ", Email ='" + email + '\'' +
                ", License:" + license +
                '}';
    }
}
