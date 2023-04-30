package com.ionn.dao;

import com.ionn.database.Database;
import com.ionn.dto.GenreDTO;

import java.sql.*;

public class Genre {
    public int insert(GenreDTO genreDTO) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (genre) values (?);", Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, genreDTO.getGenre());
            pstmt.executeUpdate();
            pstmt.getGeneratedKeys();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public GenreDTO findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from genres where genre ='" + name + "'")) {
            if (rs.next()) {
                GenreDTO genreDto = new GenreDTO();
                genreDto.setId(rs.getInt("id"));
                genreDto.setGenre(rs.getString("genre"));
                return genreDto;
            }else {
                return null;
            }
        }
    }
}
