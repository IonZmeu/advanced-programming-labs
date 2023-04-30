package com.ionn.database;

import java.sql.*;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;


    public static void createTables() throws SQLException {
        connection = Database.getConnection();
        try(Statement stmt = connection.createStatement()) {

            String sql;
            sql = "DROP TABLE IF EXISTS public.album_genres ";
            stmt.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS public.albums ";
            stmt.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS public.artists ";
            stmt.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS public.genres ";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE public.artists (" +
                    "id SERIAL PRIMARY KEY," +
                    "name character varying(100)" +
                    ")";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE public.genres (" +
                    "id SERIAL PRIMARY KEY," +
                    "genre character varying(100)" +
                    ")";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE public.albums (" +
                    "id INTEGER PRIMARY KEY," +
                    "title varchar(100)," +
                    "artist_id INTEGER," +
                    "release_year INTEGER," +
                    "FOREIGN KEY(artist_id) REFERENCES public.artists(id)" +
                    ")";
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE public.album_genres (" +
                    "album_id INTEGER," +
                    "genre_id INTEGER," +
                    "PRIMARY KEY(album_id,genre_id)," +
                    "FOREIGN KEY(album_id) REFERENCES public.albums(id)," +
                    "FOREIGN KEY(genre_id) REFERENCES public.genres(id)" +
                    ")";
            stmt.executeUpdate(sql);

            stmt.close();
        }
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
            createTables();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

