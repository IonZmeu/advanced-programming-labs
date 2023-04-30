package com.ionn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Genre {
    private int id = 0;
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (id,name) values (?,?) ON CONFLICT (id) DO NOTHING;")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            id++;
        }
    }
}
