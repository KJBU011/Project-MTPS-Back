package com.mbc.mtps.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mbc.mtps.service.SpaceService;

@RestController
public class SpaceController {
	
	final SpaceService service;

	public SpaceController(SpaceService service) {
		this.service = service;
	}
	
	

}
