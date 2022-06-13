package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.IBuildingDAO;
import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.Building;
import com.solvd.rentalcompany.entity.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLBuildingDAO implements IBuildingDAO {

    @Override
    public Building get(long id) {
        String query = "SELECT * FROM building WHERE id_building = ?";
        Location location = new Location();

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //building data
            long idBuilding = resultSet.getLong("id_building");
            String bName = resultSet.getString("b_name");
            String address = resultSet.getString("address");

            //location data
            location.setIdLocation(resultSet.getInt("location_id_location"));

            return new Building(idBuilding, bName, address, location);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Building> getAll() {
        String query = "SELECT * FROM building";
        Location location = new Location();
        List<Building> buildings = new ArrayList<>();
        Building building;

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //building data
                long idBuilding = resultSet.getLong("id_building");
                String bName = resultSet.getString("b_name");
                String address = resultSet.getString("address");

                //location data
                location.setIdLocation(resultSet.getLong("location_id_location"));

                building = new Building(idBuilding, bName, address, location);
                buildings.add(building);
            }
            return buildings;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert(Building building) {
        String query = "INSERT into building (b_name, address, location_id_location) VALUES (?, ?, ?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, building.getbName());
            preparedStatement.setString(2, building.getAddress());
            preparedStatement.setLong(3, building.getLocation().getIdLocation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Building building, long id) {
        String query = "UPDATE building SET b_name = ?, address = ?, location_id_location = ? WHERE id_user = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(4, id);

            preparedStatement.setString(1, building.getbName());
            preparedStatement.setString(2, building.getAddress());
            preparedStatement.setLong(3, building.getLocation().getIdLocation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void delete(Building building) {
        String query = "DELETE From building WHERE id = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, building.getIdBuilding());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Building getFromOrderId(long id) throws SQLException {
        String query = "SELECT * FROM orders JOIN worker on worker.id_worker = orders.worker_id_worker JOIN building ON building.id_building = worker.building_id_building WHERE orders.id_order = ?";
        Connection connection = Connectionn.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        long idBuilding = resultSet.getLong("id_building");
        String bName = resultSet.getString("b_name");
        String address = resultSet.getString("address");

        return new Building(idBuilding, bName, address);
    }
}
