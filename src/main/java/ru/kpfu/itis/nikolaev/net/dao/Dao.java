package ru.kpfu.itis.nikolaev.net.dao;

import java.util.List;

public interface Dao<T> {

    T get(int id);

    List<T> getAll();

    void save (T t);
}
