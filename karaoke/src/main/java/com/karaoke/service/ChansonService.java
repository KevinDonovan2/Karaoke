package com.karaoke.service;

import com.karaoke.repository.ChansonDAO;
import com.karaoke.model.Chanson;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChansonService {
    private final ChansonDAO chansonDAO;

    public ChansonService(ChansonDAO chansonDAO) { this.chansonDAO = chansonDAO;}

    public List<Chanson> findAllSong(){
        try {
            return chansonDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Chanson findByIdSong(int id){
        try{
            return chansonDAO.findById(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Chanson insertSong(Chanson toInsert){
        try {
            this.chansonDAO.insert(toInsert);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toInsert;
    }

    public Chanson updateSong(Chanson toUpdate){
        try {
            this.chansonDAO.update(toUpdate);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return toUpdate;
    }
    public Chanson deleteChanson(int id){
        try{
            return chansonDAO.delete(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
