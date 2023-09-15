package com.example.demo.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.SuperHero;

public interface HeroRepository extends JpaRepository<SuperHero, Integer>{
	Collection<SuperHero> findByStateTrue();
	
	Collection<SuperHero> findByPowerLevel(String powerLevel);

	Optional<SuperHero> findBySupername(String supername);
	
	
	 @Query(value = "SELECT * FROM supers WHERE id_super = :id AND state = true", nativeQuery = true)
	 Optional<SuperHero> findByIdState(@Param(value = "id") Integer id);
}
