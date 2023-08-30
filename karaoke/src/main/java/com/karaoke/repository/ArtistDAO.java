package com.karaoke.repository;

import com.karaoke.model.Artist;

import java.util.List;

public interface ArtistDAO {
    void insert(Artist e);
    List<Artist> findAll();
    Artist findById(int id);
    void update (Artist e);
    Artist delete (int id);
}
