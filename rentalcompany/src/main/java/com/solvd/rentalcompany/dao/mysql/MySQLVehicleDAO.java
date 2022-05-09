package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.Vehicles;
import com.solvd.rentalcompany.dao.DAO;

import java.util.List;
import java.util.Optional;

public class MySQLVehicleDAO implements DAO<Vehicles> {
    @Override
    public Optional<Vehicles> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Vehicles> getAll() {
        return null;
    }

    @Override
    public void save(Vehicles vehicles) {

    }

    @Override
    public void update(Vehicles vehicles, String[] params) {

    }

    @Override
    public void delete(Vehicles vehicles) {

    }
}
