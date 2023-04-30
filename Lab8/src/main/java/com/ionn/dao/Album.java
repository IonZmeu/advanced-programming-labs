package com.ionn.dao;

import com.ionn.database.Database;
import com.ionn.dto.AlbumDTO;

import java.sql.*;

public class Album {
    public void insert(AlbumDTO albumDTO) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (id,title,artist_id,release_year) values (?,?,?,?);")) {
            pstmt.setInt(1, albumDTO.getId());
            pstmt.setString(2, albumDTO.getTitle());
            pstmt.setInt(3, albumDTO.getArtistId());
            pstmt.setInt(4, albumDTO.getReleaseYear());
            pstmt.executeUpdate();
        }
    }
    public void printAll() throws SQLException {
        int lastId = -1;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select alb.id,alb.title,alb.release_year,art.name from albums alb JOIN " +
                             "artists art on alb.id = art.id JOIN " +
                             "album_genres alg on alb.id = alg.album_id JOIN " +
                             "genres gen on gen.id = alg.genre_id ")) {
            while (rs.next()){
                int id = rs.getInt("id");
                if(id == lastId){continue;}
                lastId = id;
                String genre = obtainAllGenres(id);
                String artistName = rs.getString("name");
                String title = rs.getString("title");
                int releaseYear = rs.getInt("release_year");


                System.out.println("id: " + id + " title: " + title + " artist name: " + artistName + " genre: " + genre + " release year: " + releaseYear);
            }
        }
    }

    private String obtainAllGenres(int albumId) throws SQLException {
        Connection con = Database.getConnection();
        int genreId = 0;
        String genres = "";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select genre_id from album_genres where album_id='" + albumId + "'")){
            while (rs.next()) {
                genreId = rs.getInt("genre_id");
                genres = genres + obtainOneGenre(genreId) + ", ";
            }
        }

        return genres;
    }

    private String obtainOneGenre(int genreId) throws SQLException {
        Connection con = Database.getConnection();
        String genres = "";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select genre from genres where id='" + genreId + "'")){
            while (rs.next()) {
                genres = rs.getString("genre");
            }
        }
        return genres;
    }
}
