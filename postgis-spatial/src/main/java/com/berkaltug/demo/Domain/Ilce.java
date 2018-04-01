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
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

@Entity
@Table(name="ilce")
public class Ilce {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="fk_il")
	private City il_id;
	
	@OneToMany(mappedBy="ilce_id")
	private List<Secmen> secmenler=new ArrayList<>();
	
//	@Type(type="org.hibernate.spatial.GeometryType")  hibernate'in yeni sürümünde deprecate olmuş
	private MultiPolygon konum;
	
	public Ilce() {
	}

	public Ilce(String name, MultiPolygon konum) {
		this.name = name;
		this.konum = konum;
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

	public City getIl_id() {
		return il_id;
	}

	public void setIl_id(City il_id) {
		this.il_id = il_id;
	}

	public List<Secmen> getSecmenler() {
		return secmenler;
	}

	public void setSecmenler(List<Secmen> secmenler) {
		this.secmenler = secmenler;
	}

	public Coordinate[] getKonum() {
		
		return konum.getCoordinates();
	}

	public void setKonum(MultiPolygon konum) {
		this.konum = konum;
	}

	@Override
	public String toString() {
		return "Ilce [id=" + id + ", name=" + name + ", il_id=" + il_id + ", secmenler=" + secmenler + ", konum="
				+ konum.toString() + "]";
	}
	
	public String parseCoordinate(Coordinate[] koord) {
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<koord.length;i++) {
			sb.append("["+koord[i].y+","+koord[i].x+"],");	// Openstreetmap'te korrdinatların x ve yleri ters girilmiş 
		}													// o yüzden x ve y nin yerini değiştirince polygonları doğru yerde gösterdi
		sb.insert(0, "[");
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		
		return sb.toString();
		
		}

	
	
}
