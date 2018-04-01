package com.berkaltug.demo.Service;

import java.util.List;

import com.berkaltug.demo.Domain.Ilce;

public interface IlceService {
	Ilce getIlceById( int id);
	
	List<Ilce> getIlceler();
	
}
