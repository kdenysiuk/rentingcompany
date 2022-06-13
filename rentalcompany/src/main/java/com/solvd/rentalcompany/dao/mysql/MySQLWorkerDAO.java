package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.IWorkerDAO;
import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.Building;
import com.solvd.rentalcompany.entity.JobPosition;
import com.solvd.rentalcompany.entity.WorkShift;
import com.solvd.rentalcompany.entity.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLWorkerDAO implements IWorkerDAO {
    @Override
    public Worker get(long id) {
        String query = "SELECT * FROM worker WHERE id_worker = ?";
        Building building = new Building();
        JobPosition jobPosition = new JobPosition();
        WorkShift workShift = new WorkShift();

        try{
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            //worker data
            long idWorker = resultSet.getLong("id_worker");
            String wName = resultSet.getString("w_name");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");

            //building data
            building.setIdBuilding(resultSet.getLong("building_id_building"));

            //job position data
            jobPosition.setIdPosition(resultSet.getLong("position_idposition"));

            //work shift data
            workShift.setIdWorkShift(resultSet.getLong("work_shift_id_work_shitf"));

            return new Worker(idWorker, wName, telephone, email, building, jobPosition, workShift);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Worker> getAll() {
        String query = "SELECT * FROM worker";
        List<Worker> workers = new ArrayList<>();
        Worker worker;
        Building building = new Building();
        JobPosition jobPosition = new JobPosition();
        WorkShift workShift = new WorkShift();

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //worker data
                long idWorker = resultSet.getLong("id_worker");
                String wName = resultSet.getString("w_name");
                String telephone = resultSet.getString("telephone");
                String email = resultSet.getString("email");

                //building data
                building.setIdBuilding(resultSet.getLong("building_id_building"));

                //job position data
                jobPosition.setIdPosition(resultSet.getLong("position_idposition"));

                //work shift data
                workShift.setIdWorkShift(resultSet.getLong("work_shift_id_work_shitf"));

                worker = new Worker(idWorker, wName, telephone, email, building, jobPosition, workShift);
                workers.add(worker);
            }
            return workers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Worker worker) {
        String query = "INSERT into worker (w_name, telephone, email, building_id_building, position_idposition, work_shift_id_work_shitf) values (?, ?, ?, ?, ?, ?)";
         try {
             Connection connection = Connectionn.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);

             preparedStatement.setString(1, worker.getwName());
             preparedStatement.setString(2, worker.getTelephone());
             preparedStatement.setString(3, worker.getEmail());
             preparedStatement.setLong(4, worker.getBuilding().getIdBuilding());
             preparedStatement.setLong(5, worker.getJobPosition().getIdPosition());
             preparedStatement.setLong(6, worker.getWorkShift().getIdWorkShift());
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    }

    @Override
    public void update(Worker worker, long id) {
        String query = "UPDATE worker SET w_name = ?, telephone = ?, email = ?, building_id_building = ?, position_idposition = ?, work_shift_id_work_shitf = ? WHERE id_worker = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(7, id);

            preparedStatement.setString(1, worker.getwName());
            preparedStatement.setString(2, worker.getTelephone());
            preparedStatement.setString(3, worker.getEmail());
            preparedStatement.setLong(4, worker.getBuilding().getIdBuilding());
            preparedStatement.setLong(5, worker.getJobPosition().getIdPosition());
            preparedStatement.setLong(6, worker.getWorkShift().getIdWorkShift());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Worker worker) {
        String query = "DELETE FROM worker WHERE id_worker = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, worker.getIdWorker());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Worker getFromOrderId(long id) throws SQLException {
        String query = "SELECT * FROM orders JOIN worker on worker.id_worker = orders.worker_id_worker WHERE orders.id_order = ?";
        Connection connection = Connectionn.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        long idWorker = resultSet.getLong("id_worker");
        String wName = resultSet.getString("w_name");
        String telephone = resultSet.getString("telephone");
        String email = resultSet.getString("email");

        return new Worker(idWorker, wName, telephone, email);
    }
}
