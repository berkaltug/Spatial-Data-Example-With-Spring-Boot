package com.berkaltug.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.berkaltug.demo.Domain.Ilce;
import com.berkaltug.demo.repository.IlceRepo;

@Service
public class İlceServiceImpl implements IlceService {

	private IlceRepo ir;
	@Autowired
	public void setIlceRepo(IlceRepo ir) {
		this.ir=ir;
	}
	@Override
	public Ilce getIlceById(int id) {
		return this.ir.getOne(id);
	}
	@Override
	public List<Ilce> getIlceler() {
		 return this.ir.findAll();
	}
	
	
}
