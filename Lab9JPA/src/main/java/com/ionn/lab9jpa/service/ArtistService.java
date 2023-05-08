package com.ionn.lab9jpa.service;

import com.ionn.lab9jpa.config.DatabaseUtils;
import com.ionn.lab9jpa.entity.Album;
import com.ionn.lab9jpa.entity.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArtistService {
    public void create(Artist artist){
        EntityManager entityManager = DatabaseUtils.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(artist);
        transaction.commit();
    }

    public Artist findById(Integer id){
        return DatabaseUtils.getInstance().getEntityManager().find(Artist.class,id);
    }

    public List<Artist> findByName(String name){
        Query query = DatabaseUtils.getInstance().getEntityManager().createNamedQuery("Artist.findByName");
        query.setParameter(1,name);
        return query.getResultList();
    }
}
