package com.solvd.rentalcompany.dao;

import com.solvd.rentalcompany.entity.License;

import java.sql.SQLException;

public interface ILicenseDAO extends IDAO<License> {

    public License getFromUserId(long id) throws SQLException;

    public License getFromOrderId (long id) throws SQLException;
}
