package com.mbc.mtps.dto;

import java.io.Serializable;

public class MemberDto implements Serializable {

    private String id;          // 아이디
    private String pw;          // 비밀번호
    private String name;        // 이름
    private int discntTime;     // 점주 할인 가능 시간
    private String phone;       // 전화번호
    private String email;       // 이메일
    private int auth;           // 1: 관리자, 2: 점주, 3: 일반회원
    private String carNum;      // 차량번호
    private int carType;        // 0: 일반차, 1: 전기차

    public MemberDto() {
	
	}

	public MemberDto(String id, String pw, String name, int discntTime, String phone, String email, int auth,
			String carNum, int carType) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.discntTime = discntTime;
		this.phone = phone;
		this.email = email;
		this.auth = auth;
		this.carNum = carNum;
		this.carType = carType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscntTime() {
		return discntTime;
	}

	public void setDiscntTime(int discntTime) {
		this.discntTime = discntTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public int getCarType() {
		return carType;
	}

	public void setCarType(int carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", discntTime=" + discntTime + ", phone="
				+ phone + ", email=" + email + ", auth=" + auth + ", carNum=" + carNum + ", carType=" + carType
				+ "]";
	}
    
    
}