package com.berkaltug.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkaltug.demo.Domain.Secmen;
import com.berkaltug.demo.repository.SecmenRepo;
@Service
public class SecmenServiceImpl implements SecmenService {
	
	@Autowired
	private SecmenRepo sr;
	
	
	@Override
	public Secmen getSecmenById(int id) {
		return this.sr.getOne(id);
	}

}
