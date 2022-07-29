package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Title;
import com.example.demo.repository.TitleRepository;

@RestController
@RequestMapping("/api/title")
public class TitleController {

	   @Autowired
	    TitleRepository titleRepository;

	  

	    @GetMapping()
	    public ResponseEntity<List<Title>> showAll(@RequestParam int top) {

			Pageable limit = PageRequest.of(0, top);

			List<Title> list = titleRepository.findTitle(limit);

			return list.size() == 0 
					? ResponseEntity.noContent().build() 
					: ResponseEntity.ok().body(list);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Title> showOne(@PathVariable int id) {

			Title item = titleRepository.getById(id);

			return item == null 
					? ResponseEntity.notFound().build() 
					: ResponseEntity.ok().body(item);
		}

		@PostMapping
		public ResponseEntity<Title> save(@RequestBody Title item) {
			return ResponseEntity.ok().body(titleRepository.save(item));
		}

		@PutMapping
		public ResponseEntity<Title> edit(@RequestBody Title item) {
			return ResponseEntity.ok().body(titleRepository.save(item));
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Title> deleteById(@PathVariable int id) {
			titleRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
	   
	   
	    
}
