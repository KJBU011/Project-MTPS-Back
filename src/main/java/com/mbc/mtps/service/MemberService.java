package com.mbc.mtps.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.mtps.dao.MemberDao;
import com.mbc.mtps.dto.MemberDto;

@Service
@Transactional
public class MemberService {

    final MemberDao dao;

    MemberService(MemberDao dao) {
        this.dao = dao;
    }

    public MemberDto getMember(String id) {
        return dao.getMember(id);
    }

    public int updatePw(MemberDto dto) {
        return dao.updatePw(dto);
    }

    public int updatePhone(MemberDto dto) {
        return dao.updatePhone(dto);
    }

    public int updateEmail(MemberDto dto) {
        return dao.updateEmail(dto);
    }

    public int updateCar(MemberDto dto) {
        return dao.updateCar(dto);
    }
}