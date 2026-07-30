package com.mbc.mtps.dto;

import java.io.Serializable;

public class ParkingDto implements Serializable{
	private int floor;       // 층수 (PK)
    private int total_spc;    // 총 주차 공간
    private int client_spc;   // 고객 주차 공간
    private int elec_spc;     // 전기차 주차 공간
    private int dis_spc;      // 장애인 차량 공간
    
    public ParkingDto() {
	
	}

	public ParkingDto(int floor, int total_spc, int client_spc, int elec_spc, int dis_spc) {
		super();
		this.floor = floor;
		this.total_spc = total_spc;
		this.client_spc = client_spc;
		this.elec_spc = elec_spc;
		this.dis_spc = dis_spc;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getTotal_spc() {
		return total_spc;
	}

	public void setTotal_spc(int total_spc) {
		this.total_spc = total_spc;
	}

	public int getClient_spc() {
		return client_spc;
	}

	public void setClient_spc(int client_spc) {
		this.client_spc = client_spc;
	}

	public int getElec_spc() {
		return elec_spc;
	}

	public void setElec_spc(int elec_spc) {
		this.elec_spc = elec_spc;
	}

	public int getDis_spc() {
		return dis_spc;
	}

	public void setDis_spc(int dis_spc) {
		this.dis_spc = dis_spc;
	}

	@Override
	public String toString() {
		return "ParkingDto [floor=" + floor + ", total_spc=" + total_spc + ", client_spc=" + client_spc + ", elec_spc="
				+ elec_spc + ", dis_spc=" + dis_spc + "]";
	}
    
}
