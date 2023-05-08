package com.ionn.lab9jpa;

import com.github.javafaker.Faker;
import com.ionn.lab9jpa.entity.Album;
import com.ionn.lab9jpa.entity.Artist;
import com.ionn.lab9jpa.entity.Genre;
import com.ionn.lab9jpa.repository.AlbumRepository;
import com.ionn.lab9jpa.repository.ArtistRepository;
import com.ionn.lab9jpa.repository.GenreRepository;
import com.ionn.lab9jpa.service.AlbumService;
import com.ionn.lab9jpa.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Lab9JpaApplication implements CommandLineRunner {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;
    public static void main(String[] args) {
        SpringApplication.run(Lab9JpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Genre genreTest = new Genre();
//        genreTest.setGenre("testGenre");
//        genreRepository.save(genreTest);
//
//        Artist artistTest = new Artist();
//        artistTest.setName("TestArtist");
//        artistRepository.save(artistTest);
//
//        Album album = new Album();
//        album.setTitle("Test");
//        album.setReleaseYear(2002);
//        album.setArtist(artistTest);
//
//        album.setGenreList(List.of(genreTest));
//        albumRepository.save(album);
//
//        List<Artist> artistList = artistRepository.findByName("re");
//        Optional<Artist> artistById = artistRepository.findById(1);
//
//        List<Album> albumList = albumRepository.findByTitle("re");
//        Optional<Album> albumById = albumRepository.findById(1);
//
//        List<Genre> genreList = genreRepository.findByGenre("ro");
//        Optional<Genre> genreById = genreRepository.findById(1);

        Faker faker = new Faker();
        for (int i=0;i<5;i++){
            Genre genreTest = new Genre();
            genreTest.setGenre(faker.music().genre());
            genreRepository.save(genreTest);

            List<Genre> genreList = new ArrayList<>();
            genreList.add(genreTest);

            Artist artistTest = new Artist();
            artistTest.setName(faker.artist().name());
            artistRepository.save(artistTest);



            Album album = new Album();
            album.setTitle(faker.name().title());
            album.setReleaseYear(faker.number().numberBetween(1900,2010));
            album.setArtist(artistTest);
            album.setGenreList(genreList);

            album.setGenreList(List.of(genreTest));
            albumRepository.save(album);
        }

    }
}
