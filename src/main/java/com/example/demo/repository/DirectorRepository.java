package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Director;
@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    @Query("select d from Director d")
    public List<Director> findDirector(Pageable p);
}
