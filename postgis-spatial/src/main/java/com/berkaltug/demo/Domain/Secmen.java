package com.berkaltug.demo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Secmen {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String surname;
	
	@ManyToOne
	@JoinColumn(name="fk_ilce")
	private Ilce ilce_id;
	
	public Secmen() {
	}

	public Secmen(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Ilce getIlce_id() {
		return ilce_id;
	}

	public void setIlce_id(Ilce ilce_id) {
		this.ilce_id = ilce_id;
	}

	@Override
	public String toString() {
		return "Secmen [id=" + id + ", name=" + name + ", surname=" + surname + ", ilce_id=" + ilce_id + "]";
	}
	

	
}
	

