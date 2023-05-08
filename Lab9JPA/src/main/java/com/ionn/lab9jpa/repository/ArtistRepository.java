package com.ionn.lab9jpa.repository;

import com.ionn.lab9jpa.entity.Album;
import com.ionn.lab9jpa.entity.Artist;
import com.ionn.lab9jpa.entity.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist,Integer> {
    List<Artist> findByName(String name);
}
