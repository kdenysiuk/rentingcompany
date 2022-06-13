package com.solvd.rentalcompany.dao;

import com.solvd.rentalcompany.entity.Worker;

import java.sql.SQLException;

public interface IWorkerDAO extends IDAO<Worker> {
    public Worker getFromOrderId(long id) throws SQLException;
}
