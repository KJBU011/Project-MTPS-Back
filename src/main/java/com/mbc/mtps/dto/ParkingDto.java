package com.mbc.mtps.dto;

import java.io.Serializable;

public class ParkingDto implements Serializable{
	private int floor;       // 층수 (PK)
    private int totalSpc;    // 총 주차 공간
    private int clientSpc;   // 고객 주차 공간
    private int elecSpc;     // 전기차 주차 공간
    private int disSpc;      // 장애인 차량 공간
    
    public ParkingDto() {
	
	}

	public ParkingDto(int floor, int totalSpc, int clientSpc, int elecSpc, int disSpc) {
		super();
		this.floor = floor;
		this.totalSpc = totalSpc;
		this.clientSpc = clientSpc;
		this.elecSpc = elecSpc;
		this.disSpc = disSpc;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getTotalSpc() {
		return totalSpc;
	}

	public void setTotalSpc(int totalSpc) {
		this.totalSpc = totalSpc;
	}

	public int getClientSpc() {
		return clientSpc;
	}

	public void setClientSpc(int clientSpc) {
		this.clientSpc = clientSpc;
	}

	public int getElecSpc() {
		return elecSpc;
	}

	public void setElecSpc(int elecSpc) {
		this.elecSpc = elecSpc;
	}

	public int getDisSpc() {
		return disSpc;
	}

	public void setDisSpc(int disSpc) {
		this.disSpc = disSpc;
	}

	@Override
	public String toString() {
		return "ParkingDto [floor=" + floor + ", totalSpc=" + totalSpc + ", clientSpc=" + clientSpc + ", elecSpc="
				+ elecSpc + ", disSpc=" + disSpc + "]";
	}
    
}