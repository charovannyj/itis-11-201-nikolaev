package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Master;
import ru.kpfu.itis.nikolaev.net.model.Service;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasterImpl implements Dao<Master> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Master get(int id) {
        try (Statement statement = DatabaseConnectionUtil.getConnection().createStatement()) {
            String query = String.format("SELECT * FROM masters WHERE masters.id = '%d'", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new Master(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return null;
    }

    @Override
    public List<Master> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from masters";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Master> masters = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    masters.add(
                        new Master(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                        )
                    );
                }
            }
            return masters;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Master master) {

    }
}