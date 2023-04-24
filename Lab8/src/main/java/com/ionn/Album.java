package com.ionn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Album {
    public void create(int year, String albumName, String artist, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (year,name,author,song) values (?,?,?,?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, albumName);
            pstmt.setString(3, artist);
            pstmt.setString(4, genre);
            pstmt.executeUpdate();
        }
    }
}
