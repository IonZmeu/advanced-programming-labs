package com.ionn;

import com.ionn.dao.*;
import com.ionn.database.Database;
import com.ionn.dto.ArtistDTO;
import com.ionn.dto.GenreDTO;

import java.io.IOException;
import java.sql.SQLException;
public class Main {
    public static void main(String args[]) {
        try {

            var artist = new Artist();
            ArtistDTO artistDTO = new ArtistDTO();
            artistDTO.setName("Pink Floyd");
            artist.insert(artistDTO);
            artistDTO.setName("Michael Jackson");
            artist.insert(artistDTO);
            Database.getConnection().commit();

            var genres = new Genre();
            GenreDTO genreDTO = new GenreDTO();
            genreDTO.setGenre("Rock");
            genres.insert(genreDTO);
            genreDTO.setGenre("Funk");
            genres.insert(genreDTO);
            genreDTO.setGenre("Soul");
            genres.insert(genreDTO);
            genreDTO.setGenre("Pop");
            genres.insert(genreDTO);
            Database.getConnection().commit();

            Import imp = new Import();
            imp.importFromDataSet("C:\\Users\\Ion\\Desktop\\HLAB9\\javaDataSet\\albumlist.csv");
            Database.getConnection().commit();

            Album albums = new Album();
            albums.printAll();
            System.out.println("final");
            Database.getConnection().close();

        } catch (SQLException | IOException e) {
            System.err.println(e);
        }
    }
}
