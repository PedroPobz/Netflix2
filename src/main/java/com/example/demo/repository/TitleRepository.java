package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, Integer>{
    @Query("select w from Title w")
    public List<Title> findTitle(Pageable p);
    @Query("select w from Title w order by user_rating desc")
	public List<Title> getBest(Pageable limit);
    @Query("select t from Title t join t.category c where c.id = ?1 order by t.user_rating desc")
    public List<Title> getBestByCategory( Integer category_id, Pageable limit);
    
    
    
}