package com.karaoke.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Chanson {
    private int id_chanson;
    private String title;
    private LocalDate DateCreationSong;
    private String gender ;
    private String lyrics;
}
