package com.solvd.rentalcompany.dao;

import com.solvd.rentalcompany.entity.Insurance;

import java.sql.SQLException;

public interface IInsuranceDAO extends IDAO<Insurance> {
    public Insurance getFromOrderId(long id) throws SQLException;
}
