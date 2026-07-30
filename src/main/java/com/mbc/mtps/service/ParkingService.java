package com.mbc.mtps.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.mtps.dao.ParkingDao;

@Service
@Transactional
public class ParkingService {
	
	final ParkingDao dao;

	public ParkingService(ParkingDao dao) {
		this.dao = dao;
	}
	
	

}
