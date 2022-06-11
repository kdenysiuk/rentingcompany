package com.solvd.rentalcompany.entity;

public class JobPosition {
    private long idPosition;
    private String pName;
    private int payPerHour;

    public JobPosition(long idPosition, String pName, int payPerHour) {
        this.idPosition = idPosition;
        this.pName = pName;
        this.payPerHour = payPerHour;
    }

    public JobPosition(String pName, int payPerHour) {
        this.pName = pName;
        this.payPerHour = payPerHour;
    }

    public JobPosition() {
    }

    public long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(long idPosition) {
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

    @Override
    public String toString() {
        return "JobPosition{" +
                "idPosition=" + idPosition +
                ", pName='" + pName + '\'' +
                ", payPerHour=" + payPerHour +
                '}';
    }
}
