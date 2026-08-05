package com.mbc.mtps.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.mtps.dto.SpaceDto;
import com.mbc.mtps.service.ParkingService;

@RestController
public class ParkingController {
	
	final ParkingService service;

	public ParkingController(ParkingService service) {
		this.service = service;
	}
	
//=============================== 관리자 페이지 =================================

	// 일반차량이 전기차 주차공간에 주차 했을 때 알람
		@GetMapping("checkcartype")
		public boolean checkCarType(String id) {
			System.out.println("ParkingController checkCarType " + new Date());
			return service.checkCarType(id);
		}
	
//=============================== 주차 안내 페이지 =================================	
	
	// 주차 가능 대수
	@GetMapping("gettotalparkingcount")
	public Map<String, Object> getTotalParkingCount(){
		System.out.println("ParkingController getTotalParkingCount " + new Date());
		return service.getTotalParkingCount();
			
			/*
			 	<예시>
			 	
			 	total_spc		총 주차 가능 대수 (90대)
			 	parking_car		주차장 안 차량 대수
			 	available_spc	주차 가능한 차량 대수
			 */
			
		}
		
	// 층별 유형별 주차 가능 대수
	@GetMapping("getfloorcount")
	public List<Map<String, Object>> getFloorCount(){
		System.out.println("ParkingController getFloorCount " + new Date());
		return service.getFloorCount();
			
		    /*
	        <반환 예시>

	        [
	            {
	                "floor": 1,
	                "normal_spc": 12,
	                "elec_spc": 3,
	                "dis_spc": 1
	            },
	            {
	                "floor": 2,
	                "normal_spc": 8,
	                "elec_spc": 2,
	                "dis_spc": 0
	            }
	        ]

	        floor       주차장 층수
	        normal_spc  해당 층의 일반 주차 가능 공간 수
	        elec_spc    해당 층의 전기차 주차 가능 공간 수
	        dis_spc     해당 층의 장애인 주차 가능 공간 수

	        spc_stat = 0인 빈자리만 집계한 결과
		    */
		}	
		
	// 주차현황 지도
	@GetMapping("parkingmap")
	public List<SpaceDto> parkingMap(){
		System.out.println("ParkingController parkingMap " + new Date());
		return service.parkingMap();
	}
	
	
}
