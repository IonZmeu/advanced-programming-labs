package com.ionn.dao;

import com.ionn.database.Database;
import com.ionn.dto.AlbumGenresDTO;

import java.sql.*;

public class AlbumGenres {
    String sql;
    public void insert(AlbumGenresDTO albumGenresDTO) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into album_genres (album_id,genre_id) values (?,?);")) {
            pstmt.setInt(1, albumGenresDTO.getAlbumId());
            pstmt.setInt(2, albumGenresDTO.getGenreId());
            pstmt.executeUpdate();
        }
    }

}

