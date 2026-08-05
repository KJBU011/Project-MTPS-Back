package com.mbc.mtps.dto;

import java.sql.Timestamp;
// 마이페이지 파트
public class CarStatusDto {

    private int carStat;              // 0=입차, 1=주차, 2=출차, 3=정산
    private String carStatus;         // 프론트에 전달할 상태 문자열

    private int auth;                  // 1=관리자, 2=점주, 3=일반회원

    private Integer floor;             // 주차 층
    private String spcNo;              // 주차 자리번호

    private Timestamp entTime;         // 입차시간
    private Timestamp discntAt;        // 할인 적용시간, null이면 미적용

    private int parkingMinutes;        // 현재까지 주차한 시간(분)
    private int currentCost;           // 현재 예상 주차요금

    private Timestamp exTime;          // 출차시간
    private Integer cost;              // 확정 주차비

    private String carNum;             // 차량번호


    public CarStatusDto() {
    }


    public int getCarStat() {
        return carStat;
    }

    public void setCarStat(int carStat) {
        this.carStat = carStat;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public int getAuth() {
        return auth;
    }

    public void setAuth(int auth) {
        this.auth = auth;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getSpcNo() {
        return spcNo;
    }

    public void setSpcNo(String spcNo) {
        this.spcNo = spcNo;
    }

    public Timestamp getEntTime() {
        return entTime;
    }

    public void setEntTime(Timestamp entTime) {
        this.entTime = entTime;
    }

    public Timestamp getDiscntAt() {
        return discntAt;
    }

    public void setDiscntAt(Timestamp discntAt) {
        this.discntAt = discntAt;
    }

    public int getParkingMinutes() {
        return parkingMinutes;
    }

    public void setParkingMinutes(int parkingMinutes) {
        this.parkingMinutes = parkingMinutes;
    }

    public int getCurrentCost() {
        return currentCost;
    }

    public void setCurrentCost(int currentCost) {
        this.currentCost = currentCost;
    }

    public Timestamp getExTime() {
        return exTime;
    }

    public void setExTime(Timestamp exTime) {
        this.exTime = exTime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }


    @Override
    public String toString() {
        return "CarStatusDto [carStat=" + carStat
                + ", carStatus=" + carStatus
                + ", auth=" + auth
                + ", floor=" + floor
                + ", spcNo=" + spcNo
                + ", entTime=" + entTime
                + ", discntAt=" + discntAt
                + ", parkingMinutes=" + parkingMinutes
                + ", currentCost=" + currentCost
                + ", exTime=" + exTime
                + ", cost=" + cost
                + ", carNum=" + carNum + "]";
    }
}