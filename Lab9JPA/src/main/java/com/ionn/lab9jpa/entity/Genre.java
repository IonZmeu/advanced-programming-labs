package com.ionn.lab9jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Genre.findByGenre", query = "FROM genres WHERE genre LIKE CONCAT ('%',?1,'%')")
@Entity(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "genres_id_seq")
    @SequenceGenerator(name = "genres_id_seq", sequenceName = "genres_id_seq", allocationSize = 1)
    private Integer id;

    private String genre;

}
