package com.mbc.mtps.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.mtps.dao.SpaceDao;

@Service
@Transactional
public class SpaceService {
	
	final SpaceDao dao;

	public SpaceService(SpaceDao dao) {
		this.dao = dao;
	}
	
	

}
