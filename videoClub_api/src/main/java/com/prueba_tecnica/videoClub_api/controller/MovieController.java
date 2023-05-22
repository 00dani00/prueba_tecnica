package com.prueba_tecnica.videoClub_api.controller;

import com.prueba_tecnica.videoClub_api.modelo.Actor;
import com.prueba_tecnica.videoClub_api.modelo.Movie;
import com.prueba_tecnica.videoClub_api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MovieController {
    @Autowired
    private MovieService service;

    @GetMapping("/movie")
    public List<Movie> listMovies(){
        return service.listMovies();
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> movie(@PathVariable Long id){
        try {
            Movie movie = service.getMovieById(id);
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        try {
            service.saveMovie(movie);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/movie/{id}")
    public ResponseEntity<?> AddActorToMovie(@RequestBody List<Actor> actors, @PathVariable Long id) {
        try {
            System.out.print(actors.get(1).getName());
            service.addActors(actors, id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id){
        try {
            service.updateMovie(movie, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable Long id){
        try {
            Movie movie = service.getMovieById(id);
            service.deleteMovie(id);
            return new ResponseEntity<Movie>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
    }
}
