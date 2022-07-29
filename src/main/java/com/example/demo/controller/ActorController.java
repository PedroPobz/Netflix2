package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/findAll")
    public ResponseEntity<List<Actor>> findActor(@RequestParam() int top){
        Pageable limit = PageRequest.of(0, top);
        List<Actor> list = actorRepository.findActor(limit);
        return list.size() == 0
        ? ResponseEntity.noContent().build()
        : ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findActorById(@PathVariable int id){
        
        Actor actor = actorRepository.findById(id).get();
        return actor == null
            ? ResponseEntity.noContent().build()
            : ResponseEntity.ok().body(actor);
    }

    @PostMapping
    public ResponseEntity<Actor> saveActor(@RequestBody Actor a){
        return ResponseEntity.status(HttpStatus.CREATED).body(actorRepository.save(a));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actor> deleteActor(@PathVariable int id){
        actorRepository.deleteById(id);
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.isPresent()
                ? ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(actor.get())
                : ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable int id, @RequestBody Actor newActor){
        Actor oldActor = actorRepository.findById(id).get();
        if(newActor.getName() == null || newActor.getName().isBlank()){
            newActor.setName(oldActor.getName());
        }

        newActor.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(actorRepository.save(newActor)) ;
    }




    
}
