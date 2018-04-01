package com.berkaltug.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.berkaltug.demo.Domain.Ilce;
import com.berkaltug.demo.Service.CityService;
import com.berkaltug.demo.Service.IlceService;
import com.berkaltug.demo.repository.CityRepo;
import com.berkaltug.demo.repository.IlceRepo;
import com.vividsolutions.jts.geom.Coordinate;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class PostgisSpatialApplication implements CommandLineRunner{

	@Autowired
	private CityService cr;
	@Autowired
	private IlceService ir;
	
	public static void main(String[] args) {
		SpringApplication.run(PostgisSpatialApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		System.out.println(ir.getIlceById(2).getName());
//		cr.getCityById(2).getIlceler().forEach(ilce->System.out.println(ilce.getName()));
		
//		Coordinate[] koordinat= cr.getCityById(2).getKonum();
		
//		for(int i=0;i<cr.getOne(2).getKonum().length;i++) {
//			System.out.println(koordinat[i].);
//		}
		
//		System.out.println(cr.getOne(1).parseCoordinate(cr.getOne(1).getKonum()));
		
//		System.out.println(cr.getCityById(1).parseIlce(this.cr.getCityById(1).getIlceler()));
		
//		ir.getIlceById(1).getSecmenler().forEach(secmen->System.out.println(secmen.getName()));
		
	}

	
}
