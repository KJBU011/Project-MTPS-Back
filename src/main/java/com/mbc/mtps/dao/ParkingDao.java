package com.mbc.mtps.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mbc.mtps.dto.CarStatusDto;
import com.mbc.mtps.dto.SpaceDto;

@Mapper
@Repository
public interface ParkingDao {
	
//================================== 관리자 페이지 ======================================
	
	// 일반차량이 전기차 주차공간에 주차 했을 때 알람
		int checkCarType(String id);
		
//================================== 주차 안내 페이지 ======================================
	
	// 주차 가능 대수
	Map<String, Object> getTotalParkingCount();
	
	// 층별 유형별 주차 가능 대수
	List<Map<String,Object>> getFloorCount();
	
	// 주차현황 지도
	List<SpaceDto> parkingMap();
	
	
	
}
