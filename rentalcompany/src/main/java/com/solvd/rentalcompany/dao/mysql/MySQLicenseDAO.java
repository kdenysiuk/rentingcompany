package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.dao.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLicenseDAO implements DAO<License> {

    @Override
    public License get(long id) {
        String query = "SELECT * From licence WHERE id_licence = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            int idLicense = resultSet.getInt("id_licence");
            String num = resultSet.getString("num");
            int expirationDate = resultSet.getInt("expiration_date");

            return new License(num, expirationDate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<License> getAll() {
        String query = "SELECT * From licence";
        List<License> licenses = new ArrayList<>();
        License license;

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int idLicense = resultSet.getInt("id_licence");
                String num = resultSet.getString("num");
                int expirationDate = resultSet.getInt("expiration_date");
                license = new License(num, expirationDate);
                licenses.add(license);
            }
            return licenses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(License license) {
        String query = "INSERT into licence (num, expiration_date) VALUES (?, ?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, license.getNum());
            preparedStatement.setInt(2, license.getExpirationDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(License license, long id) {
        String query = "UPDATE licence  SET num = ?, expiration_date = ? WHERE id_licence = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(3, id);

            preparedStatement.setString(1, license.getNum());
            preparedStatement.setInt(2, license.getExpirationDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(License license) {
        String query = "DELETE FROM licence WHERE id_licence = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(3, license.getIdLicense());

            preparedStatement.setString(1, license.getNum());
            preparedStatement.setInt(2, license.getExpirationDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public License getFromUserId(long id) throws SQLException {
        String query = "SELECT * FROM user JOIN licence on licence.id_licence = user.licence_id_licence WHERE user.id_user = ?";
        Connection connection = Connectionn.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        long idLicense = resultSet.getLong("id_licence");
        String num = resultSet.getString("num");
        int expirationDate = resultSet.getInt("expiration_date");

        return new License(idLicense, num, expirationDate);
    }

    public License getFromOrderId (long id) throws SQLException {
        String query = "SELECT * FROM orders JOIN user on user.id_user = orders.user_id_user JOIN licence ON licence.id_licence = user.licence_id_licence WHERE orders.id_order = ?";
        Connection connection = Connectionn.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        int idLicense = resultSet.getInt("id_licence");
        String num = resultSet.getString("num");
        int expirationDate = resultSet.getInt("expiration_date");

        return new License(idLicense, num, expirationDate);
    }
}
