package com.solvd.rentalcompany;

public class Worker {
    private int idWorker;
    private String wName;
    private String telephone;
    private String email;
    private int buildingIdBuilding;
    private int positionIdPosition;
    private int workShiftIdWorkShift;

    public Worker(int idWorker, String wName, String telephone, String email, int buildingIdBuilding, int positionIdPosition, int workShiftIdWorkShift) {
        this.idWorker = idWorker;
        this.wName = wName;
        this.telephone = telephone;
        this.email = email;
        this.buildingIdBuilding = buildingIdBuilding;
        this.positionIdPosition = positionIdPosition;
        this.workShiftIdWorkShift = workShiftIdWorkShift;
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

    public int getBuildingIdBuilding() {
        return buildingIdBuilding;
    }

    public void setBuildingIdBuilding(int buildingIdBuilding) {
        this.buildingIdBuilding = buildingIdBuilding;
    }

    public int getPositionIdPosition() {
        return positionIdPosition;
    }

    public void setPositionIdPosition(int positionIdPosition) {
        this.positionIdPosition = positionIdPosition;
    }

    public int getWorkShiftIdWorkShift() {
        return workShiftIdWorkShift;
    }

    public void setWorkShiftIdWorkShift(int workShiftIdWorkShift) {
        this.workShiftIdWorkShift = workShiftIdWorkShift;
    }
}
