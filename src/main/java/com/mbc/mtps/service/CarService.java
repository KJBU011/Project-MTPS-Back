package com.mbc.mtps.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.mtps.dao.CarDao;

@Service
@Transactional
public class CarService {
	
	final CarDao dao;

	public CarService(CarDao dao) {
		this.dao = dao;
	}
	
	

}
