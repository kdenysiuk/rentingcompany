package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.IVehicleDAO;
import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.Model;
import com.solvd.rentalcompany.entity.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLVehicleDAO implements IVehicleDAO {
    @Override
    public Vehicle get(long id) {
       String query = "SELECT * FROM vehicles WHERE vehicles_id = ?";
       Model model = new Model();

       try {
           Connection connection = Connectionn.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setLong(1, id);
           ResultSet resultSet = preparedStatement.executeQuery();

           //vehicle data
           int idVehicle = resultSet.getInt("id_vehicle");
           String licensePlate = resultSet.getString("license_plate");

           //model data
           model.setIdModel(resultSet.getInt("model_id_model"));

           return new Vehicle(idVehicle, licensePlate, model);

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }

    @Override
    public List<Vehicle> getAll() {
        String query = "SELECT * FROM vehicles WHERE vehicles_id = ?";
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle;
        Model model = new Model();

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //vehicle data
                int idVehicle = resultSet.getInt("id_vehicle");
                String licensePlate = resultSet.getString("license_plate");

                //model data
                model.setIdModel(resultSet.getInt("model_id_model"));

                vehicle = new Vehicle(idVehicle, licensePlate, model);
                vehicles.add(vehicle);
            }
            return vehicles;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Vehicle vehicle) {
        String query = "INSERT into orders (license_plate, model_id_model) VALUES (?, ?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, vehicle.getLicensePlate());
            preparedStatement.setInt(2, vehicle.getModel().getIdModel());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Vehicle vehicle, long id) {
        String query = "UPDATE orders SET license_plate = ?, model_id_model = ? WHERE id_vehicle = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(3, id);

            preparedStatement.setString(1, vehicle.getLicensePlate());
            preparedStatement.setInt(2, vehicle.getModel().getIdModel());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        String query = "DELETE From orders WHERE id_vehicle = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, vehicle.getIdVehicle());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
