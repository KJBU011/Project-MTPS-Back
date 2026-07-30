package com.mbc.mtps.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mbc.mtps.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {

    // 마이페이지 회원정보
    MemberDto getMember(String id);

    // 비밀번호 변경
    int updatePw(MemberDto dto);

    // 전화번호 변경
    int updatePhone(MemberDto dto);

    // 이메일 변경
    int updateEmail(MemberDto dto);

    // 차량번호와 전기차 여부 변경
    int updateCar(MemberDto dto);
}