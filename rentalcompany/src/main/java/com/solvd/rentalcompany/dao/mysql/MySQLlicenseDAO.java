package com.solvd.rentalcompany.dao.mysql;

import com.solvd.rentalcompany.License;
import com.solvd.rentalcompany.dao.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MySQLlicenseDAO implements DAO<License> {
    private List<License> licenses = new ArrayList<>();

    public MySQLlicenseDAO() {
        //insert licenses
    }

    @Override
    public Optional<License> get(long id) {
        return Optional.ofNullable(licenses.get((int) id));
    }

    @Override
    public List<License> getAll() {
        return licenses;
    }

    @Override
    public void save(License license) {
        licenses.add(license);
    }

    @Override
    public void update(License license, String[] params) {
        license.setNum(Objects.requireNonNull(params[0], "License Number cannot be null"));
        licenses.add(license);
    }

    public void update(License license, int[] params) {
        license.setExpirationDate(params[0]);
        licenses.add(license);
    }

    @Override
    public void delete(License license) {
        licenses.remove(license);
    }
}
