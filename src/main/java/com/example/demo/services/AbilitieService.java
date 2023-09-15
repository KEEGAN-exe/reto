package com.example.demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.AbilitieInterface;
import com.example.demo.model.Abilitie;
import com.example.demo.repository.AbilitieRepository;

@Service
public class AbilitieService implements AbilitieInterface {

	@Autowired
    public AbilitieRepository repository;
	
	@Override
	public Collection<Abilitie> getAll() {
		// TODO Auto-generated method stub
		return repository.findByStateTrue();
	}

	@Override
	public Abilitie getById(Integer id) {
		// TODO Auto-generated method stub
		try {
            return repository.findByIdState(id).get();
        } catch (Exception e) {
            return null;
        }
	}

	@Override
	public Abilitie create(Abilitie abilitie) {
		// TODO Auto-generated method stub
		return repository.save(abilitie);
	}

	@Override
	public Abilitie update(Integer id, Abilitie abilitie) {
		// TODO Auto-generated method stub
		abilitie.setIdAbilitie(id);
		return repository.save(abilitie);
	}

	@Override
	public Abilitie delete(Integer id) {
		// TODO Auto-generated method stub
		
		Abilitie abilitie = repository.findByIdState(id).orElse(null);
		abilitie.setState(false);
		return repository.save(abilitie);
	}

}
