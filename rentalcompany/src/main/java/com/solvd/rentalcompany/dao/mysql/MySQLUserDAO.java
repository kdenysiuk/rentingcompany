package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.License;
import com.solvd.rentalcompany.entity.User;
import com.solvd.rentalcompany.dao.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO implements DAO<User> {

    @Override
    public User get(long id) {
        String query = "SELECT * FROM user WHERE id_user = ?";
        License license = new License();

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //user data
            int idUser = resultSet.getInt("id_user");
            String uName = resultSet.getString("u_name");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");

            //license data
            license.setIdLicense(resultSet.getInt("licence_id_licence"));

            return new User(idUser, uName , telephone , email , license);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        String query = "SELECT * FROM user";
        List<User> users = new ArrayList<>();
        User user;
        License license = new License();

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //user data
                int idUser = resultSet.getInt("id_user");
                String uName = resultSet.getString("u_name");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");

                //license data
                license.setIdLicense(resultSet.getInt("licence_id_licence"));

                user = new User(idUser, uName, telephone, email, license);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(User user) {
        String query = "INSERT into users (u_name, telephone, email, licence_id_licence) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getuName());
            preparedStatement.setString(2, user.getTelephone());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getLicense().getIdLicense());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user, int id) {
        String query = "UPDATE user SET u_name = ?, telephone = ?, email = ?, licence_id_licence = ? WHERE id_user = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(5, id);

            preparedStatement.setString(1, user.getuName());
            preparedStatement.setString(2, user.getTelephone());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getLicense().getIdLicense());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User user) {
        String query = "DELETE From user WHERE id = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getIdUser());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
