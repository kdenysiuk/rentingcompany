package com.solvd.rentalcompany.dao;

import com.solvd.rentalcompany.entity.Location;

import java.sql.SQLException;

public interface ILocationDAO extends IDAO<Location> {

    public Location getFromOrderId(long id) throws SQLException;
}
