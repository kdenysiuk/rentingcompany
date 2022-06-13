package com.solvd.rentalcompany.dao.service;

import com.solvd.rentalcompany.dao.mysql.MySQLUserDAO;
import com.solvd.rentalcompany.dao.mysql.MySQLLicenseDAO;
import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
    private final MySQLLicenseDAO mySQLLicenseDAO = new MySQLLicenseDAO();

    public User getUserById(int id) {
        return this.mySQLUserDAO.get(id);
    }

    public List<User> getAllUser() {
        List<User> users;
        users = mySQLUserDAO.getAll();
        for (User user : users) {
            System.out.println(user.getIdUser() + "/" + users.size());
            populateUser(user);
            }
        return users;
    }

    public void registerUser(User user, License license) {
        this.mySQLLicenseDAO.insert(license);
        this.mySQLUserDAO.insert(user);
    }

    public void updateUserById(User user, License license, int id) {
        this.mySQLUserDAO.update(user, id);
        this.mySQLLicenseDAO.update(license, user.getLicense().getIdLicense());
    }

    public void deleteUser(User user) {
        this.mySQLUserDAO.delete(user);
        this.mySQLLicenseDAO.delete(user.getLicense());
    }

    public void populateUser(User user) {
        try {
            License license = mySQLLicenseDAO.getFromUserId(user.getIdUser());
            user.setLicense(license);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
