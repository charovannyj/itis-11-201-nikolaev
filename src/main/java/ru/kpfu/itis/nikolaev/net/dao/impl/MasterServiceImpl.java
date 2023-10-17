package ru.kpfu.itis.nikolaev.net.dao.impl;

import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.MasterService;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MasterServiceImpl implements Dao<MasterService> {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public MasterService get(int id) {
        try (Statement statement = DatabaseConnectionUtil.getConnection().createStatement()) {
            String query = String.format("SELECT * FROM masterservices WHERE masterservices.id = '%d'", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new MasterService(
                        resultSet.getInt(1),
                        resultSet.getInt(2)
                );
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return null;
    }

    @Override
    public List<MasterService> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from masterservices";
            ResultSet resultSet = statement.executeQuery(sql);
            List<MasterService> masterServices = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    masterServices.add(
                        new MasterService(
                            resultSet.getInt("idMaster"),
                            resultSet.getInt("idService")
                        )
                    );
                }
            }
            return masterServices;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(MasterService masterService) {

    }

}
