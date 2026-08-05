package com.mbc.mtps.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mbc.mtps.dto.CarStatusDto;
import com.mbc.mtps.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {

//================================== 로그인/회원가입 페이지 ======================================
    
    // 아이디 중복체크
    boolean idCheck(String id);
    
    // 회원가입
    int addMember(MemberDto dto);

    // 로그인
    MemberDto login(String id);
    
//================================== 마이 페이지 ======================================

	// 마이페이지 회원정보
    MemberDto getMember(String id);

    // 현재 차량 상태와 주차 위치 조회
    CarStatusDto getCarStatus(String id);

    // 내 차량 이용내역
    List<CarStatusDto> getParkingHistory(String id);

    // 비밀번호 변경
    int updatePw(MemberDto dto);

    // 전화번호 변경
    int updatePhone(MemberDto dto);

    // 이메일 변경
    int updateEmail(MemberDto dto);

    // 차량번호와 전기차 여부 변경
    int updateCar(MemberDto dto);
    
//================================== 관리자 페이지 ======================================    
    
    // 점주 목록 조회			@param : member.xml 에서 parameterType 안붙혀도 MyBatis가 XML에서 자동 인식
    List<MemberDto> selectOwnerList(@Param("category") String category,
                                     @Param("keyword") String keyword,
                                     @Param("pageNum") int pageNum);

    // 일반 회원 목록 조회
    List<MemberDto> selectMemberList(@Param("category") String category,
                                      @Param("keyword") String keyword,
                                      @Param("pageNum") int pageNum);
    // 일반 회원 목록 조회
    int selectListCount(@Param("category") String category,
                                      @Param("keyword") String keyword);
    
    // 회원 정보 수정
    int updateMemberByAdmin(MemberDto dto);
    
    // 회원 정보 삭제
    int deleteMember(Map<String, String> params);
}