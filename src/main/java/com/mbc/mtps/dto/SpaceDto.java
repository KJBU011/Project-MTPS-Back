package com.mbc.mtps.dto;

import java.io.Serializable;

public class SpaceDto implements Serializable{
	
	private String spc_no;   // 주차 자리 번호 (PK)
    private int floor;      // 층수
    private int spc_type;    // 자리 타입 (0=일반, 1=전기차, 2=장애인)
    private int spc_stat;    // 사용 상태 (0=빈자리, 1=사용중)
    
    public SpaceDto() {
	
	}

	public SpaceDto(String spc_no, int floor, int spc_type, int spc_stat) {
		super();
		this.spc_no = spc_no;
		this.floor = floor;
		this.spc_type = spc_type;
		this.spc_stat = spc_stat;
	}

	public String getSpc_no() {
		return spc_no;
	}

	public void setSpc_no(String spc_no) {
		this.spc_no = spc_no;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getSpc_type() {
		return spc_type;
	}

	public void setSpc_type(int spc_type) {
		this.spc_type = spc_type;
	}

	public int getSpc_stat() {
		return spc_stat;
	}

	public void setSpc_stat(int spc_stat) {
		this.spc_stat = spc_stat;
	}

	@Override
	public String toString() {
		return "SpaceDto [spc_no=" + spc_no + ", floor=" + floor + ", spc_type=" + spc_type + ", spc_stat=" + spc_stat
				+ "]";
	}
    
    

}
