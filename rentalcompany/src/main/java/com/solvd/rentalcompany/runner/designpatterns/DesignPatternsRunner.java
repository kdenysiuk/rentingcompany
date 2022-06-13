package com.solvd.rentalcompany.runner.designpatterns;

import com.solvd.rentalcompany.designpattern.LicenseBuilder;
import com.solvd.rentalcompany.designpattern.UserBuilder;
import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DesignPatternsRunner {
    private static final Logger LOGGER = LogManager.getLogger(DesignPatternsRunner.class);

    public static void main(String[] args) {
        License license = new LicenseBuilder().setNum("42189423").setExpirationDate(2024).build();
        LOGGER.info(license);
        User user = new UserBuilder().setuName("Keith").setEmail("kmld1999@gmail.com").setTelephone("3735404649").setLicense(license).build();
        LOGGER.info(user);
    }
}
