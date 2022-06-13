package com.solvd.rentalcompany.dao;

import com.solvd.rentalcompany.entity.Building;

import java.sql.SQLException;

public interface IBuildingDAO extends IDAO<Building> {

    public Building getFromOrderId(long id) throws SQLException;
}
