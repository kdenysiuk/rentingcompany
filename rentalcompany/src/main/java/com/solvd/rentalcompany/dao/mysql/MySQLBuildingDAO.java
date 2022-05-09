package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.Building;
import com.solvd.rentalcompany.dao.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MySQLBuildingDAO implements DAO<Building>{
    private List<Building> buildings = new ArrayList<>();

    public MySQLBuildingDAO() {
        //insert buildings
    }

    @Override
    public Optional<Building> get(long id) {
        return Optional.ofNullable(buildings.get((int) id));
    }

    @Override
    public List<Building> getAll() {
        return buildings;
    }

    @Override
    public void save(Building building) {
        buildings.add(building);
    }

    @Override
    public void update(Building building, String[] params) {
        // ?????????
    }

    @Override
    public void delete(Building building) {
        buildings.remove(building);
    }
}
