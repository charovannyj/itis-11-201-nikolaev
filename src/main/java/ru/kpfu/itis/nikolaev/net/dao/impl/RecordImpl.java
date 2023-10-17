package ru.kpfu.itis.nikolaev.net.dao.impl;


import ru.kpfu.itis.nikolaev.net.dao.Dao;
import ru.kpfu.itis.nikolaev.net.model.Record;
import ru.kpfu.itis.nikolaev.net.util.DatabaseConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecordImpl implements Dao<Record> {
    @Override
    public Record get(int id) {
        try (Statement statement = DatabaseConnectionUtil.getConnection().createStatement()) {
            String query = String.format("SELECT * FROM records WHERE records.id = '%d'", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return new Record(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getTimestamp(4),
                        resultSet.getString(5)
                );
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return null;
    }

    @Override
    public List<Record> getAll() {
        List<Record> records = new ArrayList<>();
        try (Statement statement = DatabaseConnectionUtil.getConnection().createStatement()) {
            String query = "SELECT * FROM records";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                records.add(new Record(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getTimestamp(4),
                        resultSet.getString(5)
                ));
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return records;
    }

    @Override
    public void save(Record record) {
        String query = "INSERT INTO records (master_id, service_id, time, phone) VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = DatabaseConnectionUtil.getConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, record.getIdMaster());
            preparedStatement.setInt(2, record.getIdService());
            preparedStatement.setTimestamp(3, record.getTime());
            preparedStatement.setString(4, record.getPhone());
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
