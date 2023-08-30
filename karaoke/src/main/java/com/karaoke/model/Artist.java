package com.karaoke.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Artist {
    private int id_artist;
    private String name;
    private String lastName;
    private String genderArtist;
    private LocalDate birthday;
    private LocalDate deathDate;
}
