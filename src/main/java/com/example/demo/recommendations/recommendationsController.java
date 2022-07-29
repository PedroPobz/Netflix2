package com.example.demo.recommendations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Title;
import com.example.demo.repository.TitleRepository;


@RestController
@RequestMapping("/api/recommend")
public class recommendationsController {

	
	@Autowired
	TitleRepository titleRepository;
	
	
	@GetMapping("/best")
	public ResponseEntity<List<Title>> getBest(@RequestParam(required = false) Integer top) {

		Pageable limit = top == null 
				? null  
				: PageRequest.of(0, top);
		
		List<Title> list = titleRepository.getBest(limit);

		return list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(list);
	}
	
	
	
	@GetMapping("/category/{id}")
	public ResponseEntity<List<Title>> getBestByCategory(@RequestParam(required = false) Integer top, @PathVariable Integer id) {

		Pageable limit = top == null 
				? null  
				: PageRequest.of(0, top);
		
		List<Title> list = titleRepository.getBestByCategory(id, limit);

		return list.size() == 0 
				? ResponseEntity.noContent().build() 
				: ResponseEntity.ok().body(list);
	}
	
	
	
	
}
