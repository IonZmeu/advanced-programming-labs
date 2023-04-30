package com.ionn;

import java.sql.*;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;
    String sql;
    private Database() throws SQLException {
        System.out.println("ceva");
        connection = Database.getConnection();
        Statement stmt = connection.createStatement();
        System.out.println("ceva1");
        sql = "CREATE TABLE IF NOT EXISTS public.artists" +
                "(name character varying(30)," +
                "id bigint," +
                "PRIMARY KEY (id))";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS public.genres" +
                "(name character varying(30)," +
                "id bigint," +
                "PRIMARY KEY (id))";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS public.albums" +
                "(title varchar(30)," +
                "artist varchar(30)," +
                "genre varchar(30)," +
                "release_year bigint," +
                "id bigint," +
                "PRIMARY KEY (id))";
        stmt.executeUpdate(sql);

        System.out.println("Table created successfully...");

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
            Database database = new Database();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() throws SQLException { connection.close() ;}

    public static void rollback() {
    }
}

