package com.ionn;

import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;
import java.sql.SQLException;
public class Main {
    public static void main(String args[]) {
        try {

            var artist = new Artist();
            artist.create("Pink Floyd");
            artist.create("Michael Jackson");
            Database.getConnection().commit();

            var genres = new Genre();
            genres.create("Rock"); //TODO: Funk, Soul, Pop
            Database.getConnection().commit();

            var albums = new Album();
            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop");
            Database.getConnection().commit();

            Import imp = new Import();
            imp.importFromDataSet("C:\\Users\\Ion\\Desktop\\HLAB9\\javaDataSet\\albumlist.csv");

            albums.print_all();
            Database.getConnection().close();

        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
