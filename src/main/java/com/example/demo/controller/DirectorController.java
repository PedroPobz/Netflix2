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

import com.example.demo.model.Director;
import com.example.demo.repository.DirectorRepository;

@RestController
@RequestMapping("/api/director")
public class DirectorController {

	   @Autowired
	    DirectorRepository directorRepository;

	  

	    @GetMapping()
	    public ResponseEntity<List<Director>> showAll(@RequestParam int top) {

			Pageable limit = PageRequest.of(0, top);

			List<Director> list = directorRepository.findDirector(limit);

			return list.size() == 0 
					? ResponseEntity.noContent().build() 
					: ResponseEntity.ok().body(list);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Director> showOne(@PathVariable int id) {

			Director item = directorRepository.getById(id);

			return item == null 
					? ResponseEntity.notFound().build() 
					: ResponseEntity.ok().body(item);
		}

		@PostMapping
		public ResponseEntity<Director> save(@RequestBody Director item) {
			return ResponseEntity.ok().body(directorRepository.save(item));
		}

		@PutMapping
		public ResponseEntity<Director> edit(@RequestBody Director item) {
			return ResponseEntity.ok().body(directorRepository.save(item));
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Director> deleteById(@PathVariable int id) {
			directorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
	   
	   
	    
}
