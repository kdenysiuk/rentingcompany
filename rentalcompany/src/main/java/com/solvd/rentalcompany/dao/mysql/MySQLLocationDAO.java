package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.DAO;
import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.Location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLLocationDAO implements DAO<Location> {

    @Override
    public Location get(long id) {
        String query = "SELECT * FROM location WHERE id_location = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            long idLocation = resultSet.getLong("id_location");
            String city = resultSet.getString("city");

            return new Location(idLocation, city);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Location> getAll() {
        String query = "SELECT * FROM location";
        List<Location> locations = new ArrayList<>();
        Location location;

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                long idLocation = resultSet.getLong("id_location");
                String city = resultSet.getString("city");

                location = new Location(idLocation, city);
                locations.add(location);
            }
            return locations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Location location) {
        String query = "INSERT into location (city) VALUES (?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, location.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Location location, long id) {
        String query = "UPDATE location SET city = ? WHERE id_location = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(2, id);

            preparedStatement.setString(1, location.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Location location) {
        String query = "DELETE FROM location WHERE id_location = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, location.getIdLocation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Location getFromOrderId(long id) throws SQLException {
        String query = "SELECT * FROM orders JOIN worker on worker.id_worker = orders.worker_id_worker JOIN building ON building.id_building = worker.building_id_building JOIN location ON location.id_location = building.location_id_location WHERE orders.id_order = ?";
        Connection connection = Connectionn.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        long idLocation = resultSet.getLong("id_location");
        String city = resultSet.getString("city");

        return new Location(idLocation, city);
    }
}
