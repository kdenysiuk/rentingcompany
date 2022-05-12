package com.solvd.rentalcompany.entity;

public class WorkShift {
    private int idWorkShift;
    private String timeRange;

    public WorkShift(int idWorkShift, String timeRange) {
        this.idWorkShift = idWorkShift;
        this.timeRange = timeRange;
    }

    public int getIdWorkShift() {
        return idWorkShift;
    }

    public void setIdWorkShift(int idWorkShift) {
        this.idWorkShift = idWorkShift;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }
}
