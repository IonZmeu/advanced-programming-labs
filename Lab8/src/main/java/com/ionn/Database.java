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
        connection = Database.getConnection();
        Statement stmt = connection.createStatement();

        sql = "DROP TABLE IF EXISTS public.artists ";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS public.artists" +
                "(name character varying(100)," +
                "id bigint," +
                "PRIMARY KEY (id))";
        stmt.executeUpdate(sql);

        sql = "DROP TABLE IF EXISTS public.genres ";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS public.genres" +
                "(name character varying(100)," +
                "id bigint," +
                "PRIMARY KEY (id))";
        stmt.executeUpdate(sql);

        sql = "DROP TABLE IF EXISTS public.albums ";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS public.albums" +
                "(title varchar(100)," +
                "artist varchar(100)," +
                "genre varchar(100)," +
                "release_year bigint," +
                "id bigint," +
                "PRIMARY KEY (id))";
        stmt.executeUpdate(sql);

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

