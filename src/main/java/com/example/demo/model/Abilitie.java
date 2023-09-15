package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "abilities")
public class Abilitie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAbilitie;
	
	private String name;
	
	private String description;
	
	//private String powerLevel;
	
	private Boolean state;
	
	@ManyToMany(mappedBy = "abilities")
	@JsonIgnore
	private Collection<SuperHero> hero = new ArrayList<>();
	
	public Abilitie() {
		// TODO Auto-generated constructor stub
	}

	public Abilitie(Integer idAbilitie, String name, String description, Boolean state) {
		super();
		this.idAbilitie = idAbilitie;
		this.name = name;
		this.description = description;
		this.state = state;
	}

	public Integer getIdAbilitie() {
		return idAbilitie;
	}

	public void setIdAbilitie(Integer idAbilitie) {
		this.idAbilitie = idAbilitie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Collection<SuperHero> getHero() {
		return hero;
	}

	public void setHero(Collection<SuperHero> hero) {
		this.hero = hero;
	}
	
	

}
