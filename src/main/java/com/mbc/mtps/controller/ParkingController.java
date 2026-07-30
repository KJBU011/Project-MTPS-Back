package com.mbc.mtps.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mbc.mtps.service.ParkingService;

@RestController
public class ParkingController {
	
	final ParkingService service;

	public ParkingController(ParkingService service) {
		this.service = service;
	}
	
	
}
