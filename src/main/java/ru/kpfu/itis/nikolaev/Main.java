package ru.kpfu.itis.nikolaev;

import ru.kpfu.itis.nikolaev.net.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jbdc:postgresql://localhost:5432/postgres",
                "postgres",
                "1234"
        );
        Statement statement = connection.createStatement();
        String sql = "SELECT * from users";
        ResultSet resultSet = statement.executeQuery(sql);
        List<User> users = new ArrayList<>();
        /*if (resultSet != null){
            while (resultSet.next()){
                users.add();
            }
        }*/
    }
}