package com.example.demo.repository;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>{
    @Query("select a from Actor a")
    public List<Actor> findActor(Pageable p);
}
