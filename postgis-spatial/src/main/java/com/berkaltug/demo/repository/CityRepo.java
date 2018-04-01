package com.berkaltug.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berkaltug.demo.Domain.City;

public interface CityRepo extends JpaRepository<City,Integer> {

}
