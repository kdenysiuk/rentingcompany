package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.DAO;
import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.JobPosition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLJobPositionDAO implements DAO<JobPosition> {

    @Override
    public JobPosition get(long id) {
        String query = "SELECT * FROM job_position WHERE id_position = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            long idPosition = resultSet.getLong("id_position");
            String pName = resultSet.getString("name_of_position");
            int payPerHour = resultSet.getInt("pay_per_hour");

            return new JobPosition(idPosition, pName , payPerHour);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<JobPosition> getAll() {
        String query = "SELECT * FROM job_position";
        List<JobPosition> jobPositions = new ArrayList<>();
        JobPosition jobPosition;

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                long idPosition = resultSet.getLong("id_position");
                String pName = resultSet.getString("name_of_position");
                int payPerHour = resultSet.getInt("pay_per_hour");

                jobPosition = new JobPosition(idPosition, pName , payPerHour);
                jobPositions.add(jobPosition);
            }
            return jobPositions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(JobPosition jobPosition) {
        String query = "INSERT into job_position (name_of_position, pay_per_hour) VALUES (?, ?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, jobPosition.getpName());
            preparedStatement.setInt(2, jobPosition.getPayPerHour());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(JobPosition jobPosition, long id) {
        String query = "UPDATE job_position SET name_of_position = ?, pay_per_hour = ? WHERE id_position = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(3, id);

            preparedStatement.setString(1, jobPosition.getpName());
            preparedStatement.setInt(2, jobPosition.getPayPerHour());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(JobPosition jobPosition) {
        String query = "DELETE FROM job_position WHERE id_position = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, jobPosition.getIdPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public JobPosition getFromOrderId(long id) throws SQLException {
        String query = "SELECT * FROM orders JOIN worker on worker.id_worker = orders.worker_id_worker JOIN job_position on job_position.id_position = worker.position_idposition WHERE orders.id_order = ?";
        Connection connection = Connectionn.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        long idPosition = resultSet.getLong("id_position");
        String pName = resultSet.getString("name_of_position");
        int payPerHour = resultSet.getInt("pay_per_hour");

        return new JobPosition(idPosition, pName, payPerHour);
    }
}
