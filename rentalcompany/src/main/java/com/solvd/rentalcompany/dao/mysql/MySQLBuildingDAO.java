package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.entity.Building;
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
    public Building get(long id) {
        return Optional.ofNullable(buildings.get((int) id));
    }

    @Override
    public List<Building> getAll() {
        return buildings;
    }

    @Override
    public void insert(Building building) {
        buildings.add(building);
    }

    @Override
    public void update(Building building, int id) {
        // ?????????
    }

    @Override
    public void delete(Building building) {
        buildings.remove(building);
    }
}
