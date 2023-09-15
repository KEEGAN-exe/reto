package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SuperHero;
import com.example.demo.services.HeroService;

@RestController
@RequestMapping("/hero")
public class HeroController {

	@Autowired
	private HeroService service;
	
	
	@GetMapping()
	public ResponseEntity<?> getAll() {
		
		Collection<SuperHero> data = service.getAll();
		
		if (data.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		
		SuperHero data = service.getById(id);
		
		if (data == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("powerLevel/{powerLevel}")
	public ResponseEntity<?> getByPowerLevel(@PathVariable String powerLevel) {
		
		try {
			Collection<SuperHero> data = service.getByPowerLevel(powerLevel);
			
			if (data.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("supername/{supername}")
	public ResponseEntity<?> getBySupername(@PathVariable String supername) {
		
		try {
			SuperHero data = service.getBySupername(supername);
			
			if (data == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody SuperHero superHero) {
		
		try {
			SuperHero data = service.create(superHero);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody SuperHero superHero) {
		
		try {
			
			SuperHero data = service.getById(id);
			if (data == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(service.update(id, superHero), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		
		try {
			
			
			SuperHero data = service.getById(id);
			if (data == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}
