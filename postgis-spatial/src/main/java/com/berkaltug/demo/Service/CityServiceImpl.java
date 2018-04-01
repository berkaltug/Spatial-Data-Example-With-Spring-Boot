package com.berkaltug.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkaltug.demo.Domain.City;
import com.berkaltug.demo.repository.CityRepo;
@Service
public class CityServiceImpl implements CityService {
	
	
	private CityRepo cr;
	
	@Autowired
	public void setCityRepo(CityRepo cr) {
		this.cr=cr;
	}
	
	@Override
	public City getCityById(int id) {
		return this.cr.getOne(id);
	}

	@Override
	public List<City> getCities() {
		return this.cr.findAll();
	}

}
