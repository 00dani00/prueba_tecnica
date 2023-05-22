package com.prueba_tecnica.videoClub_api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ActorDTO {
    private String name;
    private String nationality;
    private List<MovieDTO> movies;
}
