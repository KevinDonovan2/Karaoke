package com.karaoke.controller;

import com.karaoke.model.Artist;
import com.karaoke.service.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }
    @GetMapping("/artist")
    public List<Artist> getAllArtist(){
        return artistService.findAllArtist();
    }
    @GetMapping("/artist/{id}")
    public Artist getById(@PathVariable int id){
        return artistService.findByIdArtist(id);
    }
    @PostMapping("/artist")
    public Artist insertSong(@RequestBody Artist toInsert){
        return artistService.insertArtist(toInsert);
    }
    @PutMapping("/artist")
    public Artist updateSong(@RequestBody Artist toUpdate){
        return artistService.updateArtist(toUpdate);
    }
    @DeleteMapping("/artist/{id}")
    public Artist deleteArtist(@PathVariable int id){
        return artistService.deleteArtist(id);
    }
}
