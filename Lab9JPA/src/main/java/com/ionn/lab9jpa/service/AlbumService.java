package com.ionn.lab9jpa.service;

import com.ionn.lab9jpa.config.DatabaseUtils;
import com.ionn.lab9jpa.entity.Album;
import com.ionn.lab9jpa.entity.Album;
import com.ionn.lab9jpa.repository.AlbumRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AlbumService {
    public void create(Album album){
        EntityManager entityManager = DatabaseUtils.getInstance().getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(album);
        transaction.commit();
    }

    public Album findById(Integer id){
        return DatabaseUtils.getInstance().getEntityManager().find(Album.class,id);
    }

    public List<Album> findByName(String title){
        Query query = DatabaseUtils.getInstance().getEntityManager().createNamedQuery("Album.findByTitle");
        query.setParameter(1,title);
        return query.getResultList();
    }
}
