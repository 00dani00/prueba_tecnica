package com.prueba_tecnica.videoClub_api.modelo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "movie")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Movie {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="kind_movie")
    private String kind_movie;
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "FK_movie", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_actor", nullable = false)
    )
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Actor> actors = new ArrayList<Actor>();

    public void addActor(List<Actor> actors){
        for (Actor actor:actors) {
            this.actors.add(actor);
        }
    }
}
