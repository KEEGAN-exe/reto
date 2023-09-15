package com.example.demo.interfaces;

import java.util.Collection;

import com.example.demo.model.Abilitie;

public interface AbilitieInterface {
	Collection<Abilitie> getAll();
	Abilitie getById(Integer id);
	Abilitie create(Abilitie abilitie);
	Abilitie update(Integer id, Abilitie abilitie);
	Abilitie delete(Integer id);
}
