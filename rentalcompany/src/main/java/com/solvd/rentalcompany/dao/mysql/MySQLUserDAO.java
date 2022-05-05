package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.User;
import com.solvd.rentalcompany.dao.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MySQLUserDAO implements DAO<User> {
    private List<User> users = new ArrayList<>();

    public MySQLUserDAO() {
        //insert users
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user, String[] params) {
        user.setuName(Objects.requireNonNull(params[0], "Name cannot be null"));
        user.setTelephone(Objects.requireNonNull(params[1], "Telephone cannot be null"));
        user.setEmail(Objects.requireNonNull(params[2], "Email cannot be null"));
        users.add(user);
    }

    public void update(User user, int[] params) {
        user.setLicenseIdlicense(params[0]);
        users.add(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}
