package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, Integer>{
    @Query("select t from Title t")
    public List<Title> findTitle(Pageable p);
}
