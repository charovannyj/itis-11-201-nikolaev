package ru.kpfu.itis.nikolaev.net.util;

import java.sql.Connection;

public class DatabaseConnectionUtil {
    private static Connection connection;
    public static final String USER = "postgres";
    public static final String PASSWORD = "1234";
    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jbdc:postgresql://localhost:5432/postgres";

}
