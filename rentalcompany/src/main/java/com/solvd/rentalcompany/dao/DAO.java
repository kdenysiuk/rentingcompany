package com.solvd.rentalcompany.dao;

import java.util.List;

public interface DAO<T> {

    T get(long id);

    List<T> getAll();

    void insert(T t);

    void update(T t, int id);

    void delete(T t);
}
