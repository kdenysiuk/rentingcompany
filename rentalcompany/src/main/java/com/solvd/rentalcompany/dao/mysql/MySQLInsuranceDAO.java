package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.DAO;
import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.Insurance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLInsuranceDAO implements DAO<Insurance> {

    @Override
    public Insurance get(long id) {
        String query = "SELECT * FROM insurance WHERE id_insurance = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            long idInsurance = resultSet.getLong("id_insurance");
            String iName = resultSet.getString("i_name");
            int price = resultSet.getInt("price");
            String insuranceType = resultSet.getString("insurance_type");

            return new Insurance(idInsurance, iName , price , insuranceType);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Insurance> getAll() {
        String query = "SELECT * FROM insurance";
        List<Insurance> insurances = new ArrayList<>();
        Insurance insurance;

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                long idInsurance = resultSet.getLong("id_insurance");
                String iName = resultSet.getString("i_name");
                int price = resultSet.getInt("price");
                String insuranceType = resultSet.getString("insurance_type");

                insurance = new Insurance(idInsurance, iName , price , insuranceType);
                insurances.add(insurance);
            }
            return insurances;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Insurance insurance) {
        String query = "INSERT into insurance (i_name, price, insurance_type) VALUES (?, ?, ?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, insurance.getiName());
            preparedStatement.setInt(2, insurance.getPrice());
            preparedStatement.setString(3, insurance.getInsuranceType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Insurance insurance, long id) {
        String query = "UPDATE insurance SET i_name = ?, price = ?, insurance_type = ? WHERE id_insurance = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(4, id);

            preparedStatement.setString(1, insurance.getiName());
            preparedStatement.setInt(2, insurance.getPrice());
            preparedStatement.setString(3, insurance.getInsuranceType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Insurance insurance) {
        String query = "DELETE FROM insurance WHERE id_insurance = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, insurance.getIdInsurance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Insurance getFromOrderId(long id) throws SQLException {
        String query = "SELECT * FROM orders JOIN insurance on insurance.id_insurance = orders.insurance_id_insurance WHERE orders.id_order = ?";
        Connection connection = Connectionn.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        long idInsurance = resultSet.getLong("id_insurance");
        String iName = resultSet.getString("i_name");
        int price = resultSet.getInt("price");
        String insuranceType = resultSet.getString("insurance_type");

        return new Insurance(idInsurance, iName, price, insuranceType);
    }
}
