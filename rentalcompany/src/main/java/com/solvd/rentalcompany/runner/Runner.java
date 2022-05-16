package com.solvd.rentalcompany.runner;

import com.solvd.rentalcompany.dao.service.UserService;
import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main (String[] args) {

        UserService userService = new UserService();
        System.out.println(userService.getAllUser());
        License sergeyLicense = new License("34766454", 2025);
        User sergey = new User("Sergey", "3456425678", "sergey@gmail.com", sergeyLicense);
        userService.registerUser(sergey, sergeyLicense);
        System.out.println(userService.getUserById(3));

    }
}
