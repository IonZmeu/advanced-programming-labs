package com.ionn.dao;

import com.ionn.database.Database;
import com.ionn.dto.ArtistDTO;

import java.sql.*;

public class Artist {
    String sql;

    public int insert(ArtistDTO artist) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?);", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
            con.commit();
            pstmt.getGeneratedKeys();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public ArtistDTO findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("select * from artists where name = ?")){
            pstmt.setString(1, name);
            try(ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    ArtistDTO artistDTO = new ArtistDTO();
                    artistDTO.setId(rs.getInt("id"));
                    artistDTO.setName(rs.getString("name"));
                    return artistDTO;
                } else {
                    return null;
                }
            }
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from artists where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

}

