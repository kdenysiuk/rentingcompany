package com.solvd.rentalcompany.dao.service;

import com.solvd.rentalcompany.dao.mysql.MySQLUserDAO;
import com.solvd.rentalcompany.dao.mysql.MySQLicenseDAO;
import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;

import java.util.List;

public class UserService {
    private final MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();
    private final MySQLicenseDAO mySQLicenseDAO = new MySQLicenseDAO();

    public User getUserById(int id) {
        return this.mySQLUserDAO.get(id);
    }

    public List<User> getAllUser() {
        return this.mySQLUserDAO.getAll();
    }

    public void registerUser(User user, License license) {
        this.mySQLicenseDAO.insert(license);
        this.mySQLUserDAO.insert(user);
    }

    public void updateUserById(User user, License license, int id) {
        this.mySQLUserDAO.update(user, id);
        this.mySQLicenseDAO.update(license, user.getLicense().getIdLicense());
    }

    public void deleteUser(User user) {
        this.mySQLUserDAO.delete(user);
        this.mySQLicenseDAO.delete(user.getLicense());
    }
}
