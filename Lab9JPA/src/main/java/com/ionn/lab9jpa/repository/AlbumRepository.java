package com.ionn.lab9jpa.repository;

import com.ionn.lab9jpa.entity.Album;
import com.ionn.lab9jpa.entity.Artist;
import com.ionn.lab9jpa.entity.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album,Integer> {
    List<Album> findByTitle(String title);
}
