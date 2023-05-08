package com.ionn.lab9jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Album.findByTitle", query = "FROM albums WHERE title LIKE CONCAT ('%',?1,'%')")
@Entity(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "albums_id_seq")
    @SequenceGenerator(name = "albums_id_seq", sequenceName = "albums_id_seq", allocationSize = 1)
    private Integer id;

    private String title;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "album_genres", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    List<Genre> genreList;


}
