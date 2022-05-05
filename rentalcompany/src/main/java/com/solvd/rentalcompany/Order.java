package com.solvd.rentalcompany;

public class Order {
    private int idOrder;
    private int userIdUser;
    private int insuranceIdInsurance;
    private int workerIdWorker;

    public Order(int idOrder, int userIdUser, int insuranceIdInsurance, int workerIdWorker) {
        this.idOrder = idOrder;
        this.userIdUser = userIdUser;
        this.insuranceIdInsurance = insuranceIdInsurance;
        this.workerIdWorker = workerIdWorker;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    public int getInsuranceIdInsurance() {
        return insuranceIdInsurance;
    }

    public void setInsuranceIdInsurance(int insuranceIdInsurance) {
        this.insuranceIdInsurance = insuranceIdInsurance;
    }

    public int getWorkerIdWorker() {
        return workerIdWorker;
    }

    public void setWorkerIdWorker(int workerIdWorker) {
        this.workerIdWorker = workerIdWorker;
    }
}
