package com.karaoke.repository;

import com.karaoke.model.Artist;
import com.karaoke.model.Chanson;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ChansonDAO {
    void insert(Chanson e);
    List<Chanson> findAll();
    Chanson findById(int id);
    void update (Chanson e);
    Chanson delete (int id);
}
