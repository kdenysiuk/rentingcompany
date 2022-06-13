package com.solvd.rentalcompany.dao;

import com.solvd.rentalcompany.entity.JobPosition;

import java.sql.SQLException;

public interface IJobPositionDAO extends IDAO<JobPosition> {

    public JobPosition getFromOrderId(long id) throws SQLException;
}
