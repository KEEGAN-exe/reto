package com.example.demo.interfaces;

import java.util.Collection;

import com.example.demo.model.SuperHero;

public interface HeroInterface {

	Collection<SuperHero> getAll();
	
	Collection<SuperHero> getByPowerLevel(String powerLevel);
	SuperHero getBySupername(String supername);
	SuperHero getById(Integer id);
	SuperHero create(SuperHero superHero);
	SuperHero update(Integer id, SuperHero superHero);
	SuperHero delete(Integer id);
}
