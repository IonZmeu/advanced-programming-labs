package com.ionn.lab9jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Artist.findByName", query = "FROM artists WHERE name LIKE CONCAT ('%',?1,'%')")
@Entity(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "artists_id_seq")
    @SequenceGenerator(name = "artists_id_seq", sequenceName = "artists_id_seq", allocationSize = 1)
    private Integer id;

    private String name;


}
