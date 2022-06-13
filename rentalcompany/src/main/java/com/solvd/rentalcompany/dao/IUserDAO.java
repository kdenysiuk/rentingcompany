package com.solvd.rentalcompany.dao;

import com.solvd.rentalcompany.entity.User;

import java.sql.SQLException;

public interface IUserDAO extends IDAO<User> {
    public User getFromOrderId (long id) throws SQLException;
}
