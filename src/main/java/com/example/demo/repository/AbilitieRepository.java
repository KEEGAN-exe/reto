package com.example.demo.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Abilitie;

public interface AbilitieRepository extends JpaRepository<Abilitie, Integer>{
	Collection<Abilitie> findByStateTrue();
	
	 @Query(value = "SELECT * FROM abilities WHERE id_abilitie = :id AND state = true", nativeQuery = true)
	 Optional<Abilitie> findByIdState(@Param(value = "id") Integer id);
}
