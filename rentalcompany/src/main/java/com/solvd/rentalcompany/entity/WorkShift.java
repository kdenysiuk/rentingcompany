package com.solvd.rentalcompany.entity;

public class WorkShift {
    private long idWorkShift;
    private String timeRange;

    public WorkShift(long idWorkShift, String timeRange) {
        this.idWorkShift = idWorkShift;
        this.timeRange = timeRange;
    }

    public WorkShift(String timeRange) {
        this.timeRange = timeRange;
    }

    public WorkShift() {
    }

    public long getIdWorkShift() {
        return idWorkShift;
    }

    public void setIdWorkShift(long idWorkShift) {
        this.idWorkShift = idWorkShift;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }

    @Override
    public String toString() {
        return "WorkShift{" +
                "idWorkShift=" + idWorkShift +
                ", timeRange='" + timeRange + '\'' +
                '}';
    }
}
