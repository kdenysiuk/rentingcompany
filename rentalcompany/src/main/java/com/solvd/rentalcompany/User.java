package com.solvd.rentalcompany;

public class User {
    private int idUser;
    private String uName;
    private String telephone;
    private String email;
    private int licenseIdlicense;

    public User(int idUser, String uName, String telephone, String email, int licenseIdlicense) {
        this.idUser = idUser;
        this.uName = uName;
        this.telephone = telephone;
        this.email = email;
        this.licenseIdlicense = licenseIdlicense;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLicenseIdlicense() {
        return licenseIdlicense;
    }

    public void setLicenseIdlicense(int licenseIdlicense) {
        this.licenseIdlicense = licenseIdlicense;
    }
}
