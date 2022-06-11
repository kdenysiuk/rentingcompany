package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.dao.connectionn.Connectionn;
import com.solvd.rentalcompany.entity.Insurance;
import com.solvd.rentalcompany.entity.Order;
import com.solvd.rentalcompany.dao.DAO;
import com.solvd.rentalcompany.entity.User;
import com.solvd.rentalcompany.entity.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLOrderDAO implements DAO<Order> {

    @Override
    public Order get(long id) {
        String query = "SELECT * FROM orders WHERE id_order = ?";
        User user = new User();
        Insurance insurance = new Insurance();
        Worker worker = new Worker();

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            //order data
            long idOrder = resultSet.getLong("id_order");
            String orderDate = resultSet.getString("order_date");

            //user data
            user.setIdUser(resultSet.getLong("user_id_user"));

            //insurance data
            insurance.setIdInsurance(resultSet.getLong("insurance_id_insurance"));

            //worker data
            worker.setIdWorker(resultSet.getLong("worker_id_worker"));

            return new Order(idOrder, orderDate, user, insurance, worker);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getAll() {
        String query = "SELECT * FROM orders";
        List<Order> orders = new ArrayList<>();
        Order order;
        User user = new User();
        Insurance insurance = new Insurance();
        Worker worker = new Worker();

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //order data
                long idOrder = resultSet.getLong("id_order");
                String orderDate = resultSet.getString("order_date");

                //user data
                user.setIdUser(resultSet.getInt("user_id_user"));

                //insurance data
                insurance.setIdInsurance(resultSet.getInt("insurance_id_insurance"));

                //worker data
                worker.setIdWorker(resultSet.getInt("worker_id_worker"));

                order = new Order(idOrder, orderDate, user, insurance, worker);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Order order) {
        String query = "INSERT into orders (order_date, user_id_user, insurance_id_insurance, worker_id_worker) VALUES ( ?, ?, ?, ?)";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, order.getOrderDate());
            preparedStatement.setLong(2, order.getUser().getIdUser());
            preparedStatement.setLong(3, order.getInsurance().getIdInsurance());
            preparedStatement.setLong(4, order.getWorker().getIdWorker());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Order order, long id) {
        String query = "UPDATE orders SET order_date = ?, user_id_user = ?, insurance_id_insurance = ?, worker_id_worker = ? WHERE id_order = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(5, id);

            preparedStatement.setString(1, order.getOrderDate());
            preparedStatement.setLong(2, order.getUser().getIdUser());
            preparedStatement.setLong(3, order.getInsurance().getIdInsurance());
            preparedStatement.setLong(4, order.getWorker().getIdWorker());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Order order) {
        String query = "DELETE From orders WHERE id_order = ?";

        try {
            Connection connection = Connectionn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, order.getIdOrder());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
