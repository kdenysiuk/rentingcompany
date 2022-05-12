package com.solvd.rentalcompany.dao.service;

import com.solvd.rentalcompany.entity.Order;
import com.solvd.rentalcompany.dao.mysql.MySQLUserDAO;
import com.solvd.rentalcompany.dao.mysql.MySQLVehicleDAO;

import java.util.LinkedList;

public class OrderService {
    public LinkedList<Order> getAllOrders() {

    }

    public void createOrder(Order order) {
        new MySQLUserDAO().insert(order.getUser());
        order.getVehicles().forEach(x -> new MySQLVehicleDAO().insert(x));
        // new MySQLOrderDAO().save(order);
    }
}

