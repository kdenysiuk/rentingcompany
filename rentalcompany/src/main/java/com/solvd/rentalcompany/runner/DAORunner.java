package com.solvd.rentalcompany.runner;

import com.solvd.rentalcompany.dao.service.OrderService;
import com.solvd.rentalcompany.dao.service.UserService;
import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DAORunner {
    private static final Logger LOGGER = LogManager.getLogger(DAORunner.class);

    public static void main (String[] args) {

        UserService userService = new UserService();
        LOGGER.info(userService.getAllUser());
        LOGGER.info(userService.getUserById(1));

        OrderService orderService = new OrderService();
        LOGGER.info(orderService.getAllOrder());
        LOGGER.info(orderService.getOrderById(1));

//        License sergeyLicense = new License("34766454", 2025);
//        User sergey = new User("Sergey", "3456425678", "sergey@gmail.com", sergeyLicense);
//        userService.registerUser(sergey, sergeyLicense);
//        LOGGER.info(userService.getUserById(3));

    }
}
