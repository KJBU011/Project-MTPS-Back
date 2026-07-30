package com.mbc.mtps.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.mtps.dto.MemberDto;
import com.mbc.mtps.service.MemberService;

@RestController
public class MemberController {

    final MemberService service;

    MemberController(MemberService service) {
        this.service = service;
    }

    // 마이페이지 회원정보
    @GetMapping("getMember")
    public MemberDto getMember(String id) {
        System.out.println("MemberController getMember " + new Date());

        return service.getMember(id);
    }

    // 비밀번호 변경
    @PostMapping("updatePw")
    public boolean updatePw(MemberDto dto) {
        System.out.println("MemberController updatePw " + new Date());

        int count = service.updatePw(dto);

        return count>0?true:false;
    }

    // 전화번호 변경
    @PostMapping("updatePhone")
    public boolean updatePhone(MemberDto dto) {
        System.out.println("MemberController updatePhone " + new Date());

        int count = service.updatePhone(dto);

        return count>0?true:false;
    }

    // 이메일 변경
    @PostMapping("updateEmail")
    public boolean updateEmail(MemberDto dto) {
        System.out.println("MemberController updateEmail " + new Date());

        int count = service.updateEmail(dto);

        return count>0?true:false;
    }

    // 차량정보 변경
    @PostMapping("updateCar")
    public boolean updateCar(MemberDto dto) {
        System.out.println(
                "MemberController updateCar " + new Date());

        int count = service.updateCar(dto);

        return count>0?true:false;
    }
}