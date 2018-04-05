package com.berkaltug.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkaltug.demo.Domain.School;
import com.berkaltug.demo.repository.SchoolRepo;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolRepo sr;
	
	@Override
	public School getSchoolById(int id) {
		return sr.getOne(id) ;
	}

}
