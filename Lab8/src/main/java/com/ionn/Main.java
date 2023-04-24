package com.ionn;

import lombok.NoArgsConstructor;

import java.sql.SQLException;
public class Main {
    public static void main(String args[]) {
        try {
            var artists = new Artist();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            var genres = new Genre();
            genres.create("Rock"); //TODO: Funk, Soul, Pop
            Database.getConnection().commit();
            var albums = new Album();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            //findByName
            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
                    Database.getConnection().commit();
            //TODO: print all the albums in the database
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
