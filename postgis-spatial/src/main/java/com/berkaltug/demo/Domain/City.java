package com.berkaltug.demo.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

@Entity
@Table(name="sehir")
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; 
	
	private String name;
	
	@OneToMany(mappedBy="il_id")
	private List<Ilce> ilceler=new ArrayList<>();
	
//	@Type(type="org.hibernate.spatial.GeometryType") hibernate'in yeni sürümünde deprecate olmuş
	private MultiPolygon konum;
	
	
	
	public City() {
	}
	public City(String name) {
		this.name = name;
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
	
	public List<Ilce> getIlceler() {
		return ilceler;
	}
	
	public void setIlceler(List<Ilce> ilceler) {
		this.ilceler = ilceler;
	}



	public Coordinate[] getKonum() {
		return konum.getCoordinates();
	}

	public void setKonum(MultiPolygon konum) {
		this.konum = konum;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", ilceler=" + ilceler + ", konum=" + konum.toString() + "]";
	}
	
	public String parseCoordinate(Coordinate[] koord) {
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<koord.length;i++) {
			sb.append("["+koord[i].y+","+koord[i].x+"],");	// Openstreetmap'te korrdinatların x ve yleri ters girilmiş 
		}													// o yüzden x ve y nin yerini değiştirince doğru şehirleri gösterdi
		sb.insert(0, "[");
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		
		return sb.toString();
		
		}
	

	public String parseIlce(List<Ilce> ilceler) {
		
		StringBuffer sb=new StringBuffer();
		sb.append("[");
		ilceler.forEach(ilce->sb.append("`"+ilce.getName()+"`,"));
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
		
	}
	
}
