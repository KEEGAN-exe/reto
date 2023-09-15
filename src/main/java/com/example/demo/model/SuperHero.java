package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "supers")
public class SuperHero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSuper;
	private String name;
	private String lastname;
	private String supername;
	private String origin;
	private Integer age;
	private String powerLevel;
	private Boolean state;
	@ManyToMany
	@JoinTable(name = "abilities_hero", joinColumns = @JoinColumn(name = "id_abilitie"),inverseJoinColumns = @JoinColumn(name = "id_super"))
	private Collection<Abilitie> abilities = new ArrayList<>();
	
	public SuperHero() {
		// TODO Auto-generated constructor stub
	}

	
	
	public SuperHero(Integer idSuper, String name, String lastname, String supername, String origin, Integer age,
			String powerLevel, Boolean state, Collection<Abilitie> abilities) {
		super();
		this.idSuper = idSuper;
		this.name = name;
		this.lastname = lastname;
		this.supername = supername;
		this.origin = origin;
		this.age = age;
		this.powerLevel = powerLevel;
		this.state = state;
		this.abilities = abilities;
	}



	public String getSupername() {
		return supername;
	}



	public void setSupername(String supername) {
		this.supername = supername;
	}



	public void addAbilitie(Abilitie abilitie) {
		abilities.add(abilitie);
	}
	
	public boolean removeAbilite(Abilitie abilitie) {
		return abilities.remove(abilitie);
	}

	public String getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(String powerLevel) {
		this.powerLevel = powerLevel;
	}

	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getOrigin() {
		return origin;
	}



	public void setOrigin(String origin) {
		this.origin = origin;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Boolean getState() {
		return state;
	}



	public void setState(Boolean state) {
		this.state = state;
	}



	public Integer getIdSuper() {
		return idSuper;
	}

	public void setIdSuper(Integer idSuper) {
		this.idSuper = idSuper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Collection<Abilitie> getAbilities() {
		return abilities;
	}



	public void setAbilities(Collection<Abilitie> abilities) {
		this.abilities = abilities;
	}
	
	
	
	
	
	

}
