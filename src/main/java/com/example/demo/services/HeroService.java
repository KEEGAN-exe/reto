package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.HeroInterface;
import com.example.demo.model.SuperHero;
import com.example.demo.repository.HeroRepository;

@Service
public class HeroService implements HeroInterface{

    @Autowired
    public HeroRepository repository;
	
	@Override
	public Collection<SuperHero> getAll() {
		// TODO Auto-generated method stub
		return repository.findByStateTrue();
	}

	@Override
	public SuperHero getById(Integer id) {
		// TODO Auto-generated method stub
		try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
	}

	@Override
	public SuperHero create(SuperHero superHero) {
		// TODO Auto-generated method stub
		return repository.save(superHero);
	}

	@Override
	public SuperHero update(Integer id, SuperHero superHero) {
		// TODO Auto-generated method stub
		superHero.setIdSuper(id);
		return repository.save(superHero);
	}

	@Override
	public SuperHero delete(Integer id) {
		// TODO Auto-generated method stub
		SuperHero superhero = repository.findByIdState(id).get();
		superhero.setState(false);
		return repository.save(superhero);
	}

	@Override
	public Collection<SuperHero> getByPowerLevel(String powerLevel) {
		// TODO Auto-generated method stub
		return repository.findByPowerLevel(powerLevel);
	}

	@Override
	public SuperHero getBySupername(String supername) {
		// TODO Auto-generated method stub
		return repository.findBySupername(supername).orElseGet(null);
	}

	
	
}
