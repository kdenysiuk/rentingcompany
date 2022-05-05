package com.solvd.rentalcompany;

public class JobPosition {
    private int idPosition;
    private String pName;
    private int payPerHour;

    public JobPosition(int idPosition, String pName, int payPerHour) {
        this.idPosition = idPosition;
        this.pName = pName;
        this.payPerHour = payPerHour;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(int payPerHour) {
        this.payPerHour = payPerHour;
    }
}
