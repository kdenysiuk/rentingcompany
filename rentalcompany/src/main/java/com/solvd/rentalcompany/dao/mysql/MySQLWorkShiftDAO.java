package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.DAO;
import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.WorkShift;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLWorkShiftDAO implements DAO<WorkShift> {

    @Override
    public WorkShift get(long id) {
        String query = "SELECT * FROM work_shift WHERE id_work_shitf = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            long idWorkShift = resultSet.getLong("id_work_shitf");
            String timeRange = resultSet.getString("time_range");

            return new WorkShift(idWorkShift, timeRange);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<WorkShift> getAll() {
        String query = "SELECT * FROM work_shift";
        List<WorkShift> workShifts = new ArrayList<>();
        WorkShift workShift;

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                long idWorkShift = resultSet.getLong("id_work_shitf");
                String timeRange = resultSet.getString("time_range");

                workShift = new WorkShift(idWorkShift, timeRange);
                workShifts.add(workShift);
            }
            return workShifts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(WorkShift workShift) {
        String query = "INSERT into work_shift (time_range) VALUES (?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, workShift.getTimeRange());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(WorkShift workShift, long id) {
        String query = "UPDATE work_shift SET time_range = ? WHERE id_work_shitf = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(2, id);

            preparedStatement.setString(1, workShift.getTimeRange());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(WorkShift workShift) {
        String query = "DELETE FROM work_shift WHERE id_work_shitf = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, workShift.getIdWorkShift());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public WorkShift getFromOrderId(long id) throws SQLException {
        String query = "SELECT * FROM orders JOIN worker on worker.id_worker = orders.worker_id_worker JOIN work_shift on work_shift.id_work_shitf = worker.work_shift_id_work_shitf WHERE orders.id_order = ?";
        Connection connection = Connectionn.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        long idWorkShift = resultSet.getLong("id_work_shitf");
        String timeRange = resultSet.getString("time_range");

        return new WorkShift(idWorkShift, timeRange);
    }
}
