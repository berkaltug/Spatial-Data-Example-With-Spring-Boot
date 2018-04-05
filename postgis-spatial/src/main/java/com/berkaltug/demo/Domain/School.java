package com.berkaltug.demo.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.vividsolutions.jts.geom.Point;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="fk_ilce")
	private Ilce ilce_id;
	
	@OneToMany(mappedBy="school_id")
	private List<Secmen> secmenler;
	
	private Point konum;
	
	public School(String name, Ilce ilce_id, List<Secmen> secmenler, Point konum) {
		this.name = name;
		this.ilce_id = ilce_id;
		this.secmenler = secmenler;
		this.konum = konum;
	}

	public School(String name, Ilce ilce_id, Point konum) {
		this.name = name;
		this.ilce_id = ilce_id;
		this.konum = konum;
	}

	public School() {
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

	public Ilce getIlce_id() {
		return ilce_id;
	}

	public void setIlce_id(Ilce ilce_id) {
		this.ilce_id = ilce_id;
	}

	public Point getKonum() {
		return konum;
	}

	public void setKonum(Point konum) {
		this.konum = konum;
	}

	public List<Secmen> getSecmenler() {
		return secmenler;
	}

	public void setSecmenler(List<Secmen> secmenler) {
		this.secmenler = secmenler;
	}
	
	public String parseCoordinate(Point p) {
		StringBuffer sb=new StringBuffer();
		
		sb.append("["+p.getX()+","+p.getY()+"]");
		
		return sb.toString();
	}
	
	
	
	
}
