package com.ionn.lab9jpa.service;

import com.ionn.lab9jpa.config.DatabaseUtils;
import com.ionn.lab9jpa.entity.Artist;
import com.ionn.lab9jpa.entity.Genre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    public void create(Genre genre){
        EntityManager entityManager = DatabaseUtils.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(genre);
        transaction.commit();
    }

    public Genre findById(Integer id){
        return DatabaseUtils.getInstance().getEntityManager().find(Genre.class,id);
    }

    public List<Genre> findByName(String genre){
        Query query = DatabaseUtils.getInstance().getEntityManager().createNamedQuery("Genre.findByGenre");
        query.setParameter(1,genre);
        return query.getResultList();
    }

}
