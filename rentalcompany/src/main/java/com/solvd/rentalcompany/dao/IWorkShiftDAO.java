package com.solvd.rentalcompany.dao;

import com.solvd.rentalcompany.entity.WorkShift;

import java.sql.SQLException;

public interface IWorkShiftDAO extends IDAO<WorkShift> {
    public WorkShift getFromOrderId(long id) throws SQLException;
}
