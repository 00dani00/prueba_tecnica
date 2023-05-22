package com.prueba_tecnica.videoClub_api.service;


import com.prueba_tecnica.videoClub_api.modelo.Actor;
import com.prueba_tecnica.videoClub_api.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    @Autowired
    private ActorRepository repository;

    public List<Actor> listActors(){
        return repository.findAll();
    }
    public void saveActor(Actor actor){
        repository.save(actor);
    }
    public void updateActor(Actor actor, Long id){
        Actor existActor = repository.findById(id).get();
        existActor.setName(actor.getName());
        existActor.setNationality(actor.getNationality());
        repository.save(existActor);
    }
    public Actor getActorById(Long id){
        return repository.findById(id).get();
    }
    public void deleteActor(Long id){
        repository.deleteById(id);
    }

}
