package com.mbc.mtps.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class CarDto implements Serializable{

    private Timestamp ent_time;   // 입차 시간 (PK)
    private String id;           // 차주 (member.id 참조)
    private int car_stat;         // 상태 (0=입차, 1=주차, 2=출차, 3=정산)
    private Timestamp ex_time;    // 출차 시간
    private int cost;        // 요금
    private String spc_no;        // 주차된 자리
	
    public CarDto() {
		
	}
    
    public CarDto(Timestamp ent_time, String id, int car_stat, Timestamp ex_time, int cost, String spc_no) {
		super();
		this.ent_time = ent_time;
		this.id = id;
		this.car_stat = car_stat;
		this.ex_time = ex_time;
		this.cost = cost;
		this.spc_no = spc_no;
	}

	public Timestamp getEnt_time() {
		return ent_time;
	}

	public void setEnt_time(Timestamp ent_time) {
		this.ent_time = ent_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCar_stat() {
		return car_stat;
	}

	public void setCar_stat(int car_stat) {
		this.car_stat = car_stat;
	}

	public Timestamp getEx_time() {
		return ex_time;
	}

	public void setEx_time(Timestamp ex_time) {
		this.ex_time = ex_time;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getSpc_no() {
		return spc_no;
	}

	public void setSpc_no(String spc_no) {
		this.spc_no = spc_no;
	}

	@Override
	public String toString() {
		return "CarDto [ent_time=" + ent_time + ", id=" + id + ", car_stat=" + car_stat + ", ex_time=" + ex_time
				+ ", cost=" + cost + ", spc_no=" + spc_no + "]";
	}
    
}