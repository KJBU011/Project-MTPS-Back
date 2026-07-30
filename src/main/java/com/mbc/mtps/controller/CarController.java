package com.mbc.mtps.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mbc.mtps.service.CarService;

@RestController
public class CarController {
	
	final CarService service;

	public CarController(CarService service) {
		this.service = service;
	}
	
	
}
