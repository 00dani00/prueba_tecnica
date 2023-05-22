package com.prueba_tecnica.videoClub_api.controller;

import com.prueba_tecnica.videoClub_api.dtos.ActorDTO;
import com.prueba_tecnica.videoClub_api.modelo.Actor;
import com.prueba_tecnica.videoClub_api.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ActorController {
    @Autowired
    private ActorService service;

    @GetMapping("/actor")
    public List<Actor> listActors(){
        return service.listActors();
    }

    @GetMapping("/actor/{id}")
    public ResponseEntity<Actor> actor(@PathVariable Long id){
        try {
            Actor actor = service.getActorById(id);
            return new ResponseEntity<Actor>(actor, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Actor>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/actor")
    public ResponseEntity<ActorDTO> saveActor(@RequestBody Actor actor) {
        try {
            service.saveActor(actor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/actor/{id}")
    public ResponseEntity<ActorDTO> updateActor(@RequestBody Actor actor, @PathVariable Long id){
        try {
            service.updateActor(actor, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/actor/{id}")
    public ResponseEntity<Actor> deleteActor(@PathVariable Long id){
        try {
            Actor actor = service.getActorById(id);
            service.deleteActor(id);
            return new ResponseEntity<Actor>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Actor>(HttpStatus.NOT_FOUND);
        }
    }
}
