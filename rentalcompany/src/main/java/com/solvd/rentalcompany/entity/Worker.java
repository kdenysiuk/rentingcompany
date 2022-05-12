package com.solvd.rentalcompany.entity;

public class Worker {
    private int idWorker;
    private String wName;
    private String telephone;
    private String email;
    private Building building;
    private JobPosition jobPosition;
    private WorkShift workShift;

    public Worker(int idWorker, String wName, String telephone, String email, Building building, JobPosition jobPosition, WorkShift workShift) {
        this.idWorker = idWorker;
        this.wName = wName;
        this.telephone = telephone;
        this.email = email;
        this.building = building;
        this.jobPosition = jobPosition;
        this.workShift = workShift;
    }

    public Worker() {

    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public WorkShift getWorkShift() {
        return workShift;
    }

    public void setWorkShift(WorkShift workShift) {
        this.workShift = workShift;
    }
}
