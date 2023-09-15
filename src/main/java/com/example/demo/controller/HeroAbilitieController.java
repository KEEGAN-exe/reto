package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Abilitie;
import com.example.demo.model.SuperHero;
import com.example.demo.model.custom.HeroAbilitie;
import com.example.demo.services.AbilitieService;
import com.example.demo.services.HeroService;

@RestController
@RequestMapping("/hero_abilitie")
public class HeroAbilitieController {
	
	@Autowired
	private HeroService heroService;
	@Autowired
	private AbilitieService abilitieService;
	
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestBody HeroAbilitie heroAbilitie){
		SuperHero hero =  heroService.getById(heroAbilitie.getId_super());
		if(hero != null) {
			
			for (Abilitie abilitie : hero.getAbilities()) {
				if (abilitie.getIdAbilitie() == heroAbilitie.getId_abilitie()) {
					return new ResponseEntity<>("This abilitie exists in this hero" ,HttpStatus.BAD_REQUEST);
				}
			}
			
			Abilitie abilitie =  abilitieService.getById(heroAbilitie.getId_abilitie());
			if(abilitie != null) {
				hero.addAbilitie(abilitie);
				heroService.update(hero.getIdSuper(),hero);
				return new ResponseEntity<>(hero,HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody HeroAbilitie heroAbilitie){
		SuperHero hero =  heroService.getById(heroAbilitie.getId_super());
	    if (hero != null) {
	        Abilitie abilitie = abilitieService.getById(heroAbilitie.getId_abilitie());
	        if (abilitie != null) {
	            boolean removed = hero.removeAbilite(abilitie);
	            if (removed) {
	                heroService.update(hero.getIdSuper(), hero);
	                return new ResponseEntity<>(hero, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>("the ability is not associated with the superhero", HttpStatus.NOT_FOUND);
	            }
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
}
