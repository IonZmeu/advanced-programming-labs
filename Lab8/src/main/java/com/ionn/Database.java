package com.ionn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;
    String sql;
    private Database() throws SQLException {
        createConnection();
        Statement stmt = connection.createStatement();

        sql = "CREATE DATABASE ALBUMS";
        stmt.executeUpdate(sql);
        System.out.println("Database created successfully...");

        sql = "CREATE DATABASE ALBUMS";
        stmt.executeUpdate(sql);
        System.out.println("Database created successfully...");

        stmt.close();
        
    }
    public static Connection getConnection() {
        if(connection == null){
            createConnection();
        }
        return connection;
    }
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() throws SQLException { connection.close() ;}

    public static void rollback() {
    }
}

