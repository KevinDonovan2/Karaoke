package com.karaoke.controller;

import com.karaoke.model.Artist;
import com.karaoke.model.Chanson;
import com.karaoke.service.ChansonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChansonController {
    private final ChansonService chansonService;

    public ChansonController(ChansonService chansonService) { this.chansonService = chansonService;}
    @GetMapping("/chanson")
    public List<Chanson> getAllSong(){
        return chansonService.findAllSong();
    }
    @GetMapping("/chanson/{id}")
    public Chanson getById(@PathVariable int id){
        return chansonService.findByIdSong(id);
    }
    @PostMapping("/chanson")
    public Chanson insertSong(@RequestBody Chanson toInsert){
        return chansonService.insertSong(toInsert);
    }
    @PutMapping("/chanson")
    public Chanson updateSong( @RequestBody Chanson toUpdate) {
        return chansonService.updateSong(toUpdate);
    }
    @DeleteMapping("/chanson/{id}")
    public Chanson deleteArtist(@PathVariable int id){
        return chansonService.deleteChanson(id);
    }
}
