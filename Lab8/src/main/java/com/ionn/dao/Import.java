package com.ionn.dao;

import com.ionn.dto.AlbumDTO;
import com.ionn.dto.AlbumGenresDTO;
import com.ionn.dto.ArtistDTO;
import com.ionn.dto.GenreDTO;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;

public class Import {
    Artist artistDAO = new Artist();
    Genre genreDAO = new Genre();
    Album albumDAO = new Album();
    AlbumGenres albumGenresDAO = new AlbumGenres();

    public void importFromDataSet(final String path) throws IOException, SQLException {

        try (
                Reader reader = Files.newBufferedReader(Paths.get(path));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                int artistId = insertArtistIfNotExists(nextRecord[3]);

                int albumId = Integer.parseInt(nextRecord[0]);
                int albumYear = Integer.parseInt(nextRecord[1]);
                String albumName = nextRecord[2];

                AlbumDTO albumDTO = new AlbumDTO();
                albumDTO.setId(albumId);
                albumDTO.setTitle(albumName);
                albumDTO.setArtistId(artistId);
                albumDTO.setReleaseYear(albumYear);
                albumDAO.insert(albumDTO);

                String genres = nextRecord[4];
                for (String genre : Arrays.asList(genres.split(", "))) {
                    int genreId = insertGenreIfNotExists(genre);
                    AlbumGenresDTO albumGenresDTO = new AlbumGenresDTO();
                    albumGenresDTO.setGenreId(genreId);
                    albumGenresDTO.setAlbumId(albumId);
                    albumGenresDAO.insert(albumGenresDTO);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private int insertArtistIfNotExists(String artistName) throws SQLException {
        ArtistDTO artistDTO = artistDAO.findByName(artistName);
        if (artistDTO == null) {
            ArtistDTO artistDTO1 = new ArtistDTO();
            artistDTO1.setName(artistName);
            return artistDAO.insert(artistDTO1);
        } else {
            return artistDTO.getId();
        }
    }

    private int insertGenreIfNotExists(String genre) throws SQLException {
        GenreDTO genreDTO = genreDAO.findByName(genre);
        if (genreDTO == null) {
            GenreDTO genreDTO1 = new GenreDTO();
            genreDTO1.setGenre(genre);
            return genreDAO.insert(genreDTO1);
        } else {
            return genreDTO.getId();
        }
    }
}
