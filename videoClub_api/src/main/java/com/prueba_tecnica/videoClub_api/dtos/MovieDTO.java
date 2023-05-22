package com.prueba_tecnica.videoClub_api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class MovieDTO {
    private String name;
    private String kind_movie;
    private List<ActorDTO> actors;
}
