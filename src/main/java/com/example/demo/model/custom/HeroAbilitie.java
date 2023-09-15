package com.example.demo.model.custom;

public class HeroAbilitie {
	
	private Integer id_abilitie;
	
	private Integer id_super;

	public Integer getId_abilitie() {
		return id_abilitie;
	}

	public void setId_abilitie(Integer id_abilitie) {
		this.id_abilitie = id_abilitie;
	}

	public Integer getId_super() {
		return id_super;
	}

	public void setId_super(Integer id_super) {
		this.id_super = id_super;
	}

	public HeroAbilitie(Integer id_abilitie, Integer id_super) {
		super();
		this.id_abilitie = id_abilitie;
		this.id_super = id_super;
	}

	public HeroAbilitie() {
		super();
	}
	

}
