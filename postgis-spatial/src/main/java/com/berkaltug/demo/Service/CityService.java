package com.berkaltug.demo.Service;

import java.util.List;

import com.berkaltug.demo.Domain.City;

public interface CityService {
	City getCityById(int id);
	List<City> getCities();
}
