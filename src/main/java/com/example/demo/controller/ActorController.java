package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;

@RestController
public class ActorController {
    @Autowired
    ActorRepository actorRepository;

    @GetMapping("actor")
    public List<Actor> findAll(){
        return actorRepository.findAll().subList(0, 10);
    }
    
}
