package com.karaoke.service;

import com.karaoke.model.Artist;
import com.karaoke.repository.ArtistDAO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistService {
    private final ArtistDAO artistDAO;

    public ArtistService(ArtistDAO artistDAO) { this.artistDAO = artistDAO;}

    public List<Artist> findAllArtist(){
        try {
            return artistDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Artist findByIdArtist(int id){
        try{
            return artistDAO.findById(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Artist insertArtist(Artist toInsert){
        try {
            this.artistDAO.insert(toInsert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toInsert;
    }

    public Artist updateArtist(Artist toUpdate){
        try {
            this.artistDAO.update(toUpdate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toUpdate;
    }
    public Artist deleteArtist(int id){
        try{
            return artistDAO.delete(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
