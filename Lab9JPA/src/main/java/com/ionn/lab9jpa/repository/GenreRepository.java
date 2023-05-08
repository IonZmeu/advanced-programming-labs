package com.ionn.lab9jpa.repository;

import com.ionn.lab9jpa.entity.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre,Integer> {
    List<Genre> findByGenre(String genre);
}
