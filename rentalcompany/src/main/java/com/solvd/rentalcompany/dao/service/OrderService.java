package com.solvd.rentalcompany.dao.service;

import com.solvd.rentalcompany.dao.mysql.MySQLOrderDAO;
import com.solvd.rentalcompany.entity.Order;

import java.util.List;

public class OrderService {
    private final MySQLOrderDAO mySQLOrderDAO = new MySQLOrderDAO();

    public Order getOrderById(int id) {
        return this.mySQLOrderDAO.get(id);
    }

    public List<Order> getAllOrder() {
        return this.mySQLOrderDAO.getAll();
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
}

