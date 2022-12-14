package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    @Query("select c from Category c")
    public List<Category> findCategory(Pageable p);
}
