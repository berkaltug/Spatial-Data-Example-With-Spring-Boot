package com.berkaltug.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berkaltug.demo.Domain.Secmen;

public interface SecmenRepo extends JpaRepository<Secmen,Integer> {

}
