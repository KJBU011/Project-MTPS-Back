package com.mbc.mtps.dto;

import java.io.Serializable;

public class SpaceDto implements Serializable{
	
	private String spcNo;   // 주차 자리 번호 (PK)
    private int floor;      // 층수
    private int spcType;    // 자리 타입 (0=일반, 1=전기차, 2=장애인)
    private int spcStat;    // 사용 상태 (0=빈자리, 1=사용중)
    
    public SpaceDto() {
	
	}

	public SpaceDto(String spcNo, int floor, int spcType, int spcStat) {
		super();
		this.spcNo = spcNo;
		this.floor = floor;
		this.spcType = spcType;
		this.spcStat = spcStat;
	}

	public String getSpcNo() {
		return spcNo;
	}

	public void setSpcNo(String spcNo) {
		this.spcNo = spcNo;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getSpcType() {
		return spcType;
	}

	public void setSpcType(int spcType) {
		this.spcType = spcType;
	}

	public int getSpcStat() {
		return spcStat;
	}

	public void setSpcStat(int spcStat) {
		this.spcStat = spcStat;
	}

	@Override
	public String toString() {
		return "SpaceDto [spcNo=" + spcNo + ", floor=" + floor + ", spcType=" + spcType + ", spcStat=" + spcStat
				+ "]";
	}
    
    

}