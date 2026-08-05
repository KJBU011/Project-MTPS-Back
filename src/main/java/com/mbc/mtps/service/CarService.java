package com.mbc.mtps.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.mtps.dao.CarDao;
import com.mbc.mtps.dto.CarDto;

@Service
@Transactional
public class CarService {
	
	final CarDao dao;

	public CarService(CarDao dao) {
		this.dao = dao;
	}
	
//================================== 점주 페이지 ======================================
	
	// 차량번호 뒤 4자리 검색
    public List<CarDto> getCarNum(String carNum) {
    	
    	List<CarDto> list = dao.getCarNum(carNum);
    	
    	// 현재 주차 시간(분) 계산해서 각 차량에 세팅
    	for (CarDto dto : list) {
    		if (dto.getEntTime() != null) {
    			LocalDateTime entranceTime = dto.getEntTime().toLocalDateTime();
    			LocalDateTime currentTime = LocalDateTime.now();
    			long totalMinutes = Duration.between(entranceTime, currentTime).toMinutes();
    			
    			if (totalMinutes < 0) {
    				totalMinutes = 0;
    			}
    			
    			dto.setParkingMinutes((int) totalMinutes);
    		}
    	}
    	
    	return list;
    }
	
    // 할인 등록
    public boolean applyDiscount(int carId, String ownerId) {
    	int count = dao.applyDiscount(carId, ownerId);
    	return count > 0;
    }
    
    // 점주의 할인 가능 시간(discnt_time) 2시간 차감
    public boolean decreaseOwnerTime(String ownerId) {
    	int count = dao.decreaseOwnerTime(ownerId);
    	return count > 0;
    }
    
    // 할인 지급 내역 리스트 (discnt_at 있는 차량만)
    public List<CarDto> getDiscountList() {
    	return dao.getDiscountList();
    }
    
    // 금일 가게 방문 차량 수 (해당 점주가 오늘 할인해준 차량 리스트)
    public List<CarDto> getTodayVisitCount(String ownerId) {
    	return dao.getTodayVisitCount(ownerId);
    }

}