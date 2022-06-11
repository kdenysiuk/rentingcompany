package com.solvd.rentalcompany.dao.service;

import com.solvd.rentalcompany.dao.mysql.*;
import com.solvd.rentalcompany.entity.*;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private final MySQLOrderDAO mySQLOrderDAO = new MySQLOrderDAO();
    private final MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
    private final MySQLicenseDAO mySQLicenseDAO = new MySQLicenseDAO();
    private final MySQLWorkerDAO mySQLWorkerDAO = new MySQLWorkerDAO();
    private final MySQLInsuranceDAO mySQLInsuranceDAO = new MySQLInsuranceDAO();
    private final MySQLJobPositionDAO mySQLJobPositionDAO = new MySQLJobPositionDAO();
    private final MySQLWorkShiftDAO mySQLWorkShiftDAO = new MySQLWorkShiftDAO();
    private final MySQLBuildingDAO mySQLBuildingDAO = new MySQLBuildingDAO();
    private final MySQLLocationDAO mySQLLocationDAO = new MySQLLocationDAO();

    public Order getOrderById(long id) {
        return this.mySQLOrderDAO.get(id);
    }

    public List<Order> getAllOrder() {
        List<Order> orders;
        orders = mySQLOrderDAO.getAll();
        for (Order order : orders) {
            System.out.println(order.getIdOrder() + "/" + orders.size());
            populateOrder(order);
        }
        return orders;
    }

    public void registerOrder(Order order) {

        this.mySQLOrderDAO.insert(order);
    }

    public void updateGroupById(Order order, int id) {
        this.mySQLOrderDAO.update(order, id);
    }

    public void deleteGroup(Order order) {
        this.mySQLOrderDAO.delete(order);
    }

    public void populateOrder(Order order) {
        try {
            User user = mySQLUserDAO.getFromOrderId(order.getIdOrder());
            License license = mySQLicenseDAO.getFromOrderId(order.getIdOrder());
            Worker worker = mySQLWorkerDAO.getFromOrderId(order.getIdOrder());
            Building building = mySQLBuildingDAO.getFromOrderId(order.getIdOrder());
            Location location = mySQLLocationDAO.getFromOrderId(order.getIdOrder());
            JobPosition jobPosition = mySQLJobPositionDAO.getFromOrderId(order.getIdOrder());
            WorkShift workShift = mySQLWorkShiftDAO.getFromOrderId(order.getIdOrder());
            Insurance insurance = mySQLInsuranceDAO.getFromOrderId(order.getIdOrder());

            user.setLicense(license);
            building.setLocation(location);
            worker.setBuilding(building);
            worker.setJobPosition(jobPosition);
            worker.setWorkShift(workShift);
            order.setUser(user);
            order.setWorker(worker);
            order.setInsurance(insurance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

