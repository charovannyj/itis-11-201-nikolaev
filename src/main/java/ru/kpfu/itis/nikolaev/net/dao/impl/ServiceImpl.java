package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;

import ru.kpfu.itis.nikolaev.net.model.Record;
import ru.kpfu.itis.nikolaev.net.model.Service;
import ru.kpfu.itis.nikolaev.net.server.StartServlet;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;
import ru.kpfu.itis.nikolaev.net.server.StartServlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Dao<Service> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Service get(int id) {
        try (Statement statement = DatabaseConnectionUtil.getConnection().createStatement()) {
            String query = String.format("SELECT * FROM services WHERE services.id = '%d'", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new Service(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getString(3)
                );
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return null;
    }

    @Override
    public List<Service> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM services";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Service> services = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    services.add(
                        new Service(
                            resultSet.getInt("id"),
                            resultSet.getInt("price"),
                            resultSet.getString("name")
                        )
                    );
                }
            }
            return services;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Service service) {
    }
}
