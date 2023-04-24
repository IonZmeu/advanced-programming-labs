package com.ionn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Genre {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }
}
