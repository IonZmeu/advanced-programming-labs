package com.ionn;

import java.sql.*;

public class Album {
    private int id = 0;
    public void create(int release_year, String title, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id,release_year,title,artist,genre) values (?,?,?,?,?) ON CONFLICT (id) DO NOTHING;")) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, release_year);
            pstmt.setString(3, title);
            pstmt.setString(4, artist);
            pstmt.setString(5, genre);
            pstmt.executeUpdate();
            id++;
        }
    }
    public void print_all() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from albums ")) {
            int row = 1;
            String returnString = new String();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                int release_year = rs.getInt("release_year");
                System.out.println("id: " + id + " title: " + title + " genre: " + genre + " release year: " + release_year);
            }
        }
    }

}
