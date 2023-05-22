package com.prueba_tecnica.videoClub_api.service;

import com.prueba_tecnica.videoClub_api.modelo.Actor;
import com.prueba_tecnica.videoClub_api.modelo.Movie;
import com.prueba_tecnica.videoClub_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public List<Movie> listMovies(){
        return repository.findAll();
    }
    public void saveMovie(Movie movie){
        repository.save(movie);
    }
    public void addActors(List<Actor> actors, Long id){
        Movie existMovie = repository.findById(id).get();
        System.out.println(existMovie.getName());
        existMovie.addActor(actors);
        System.out.println(existMovie.getActors().get(0).getName());
        repository.save(existMovie);
    }
    public void updateMovie(Movie movie, Long id){
        Movie existMovie = repository.findById(id).get();
        existMovie.setName(movie.getName());
        existMovie.setKind_movie(movie.getKind_movie());
        repository.save(existMovie);
    }
    public Movie getMovieById(Long id){
        return repository.findById(id).get();
    }
    public void deleteMovie(Long id){
        repository.deleteById(id);
    }
}
