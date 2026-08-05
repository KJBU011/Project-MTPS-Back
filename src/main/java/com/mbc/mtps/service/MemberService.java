package com.mbc.mtps.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mbc.mtps.dao.MemberDao;
import com.mbc.mtps.dto.CarStatusDto;
import com.mbc.mtps.dto.MemberDto;

@Service
@Transactional
public class MemberService {

    final MemberDao dao;
    final PasswordEncoder passwordEncoder; 

    MemberService(MemberDao dao, PasswordEncoder passwordEncoder) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
    }

//=============================== 로그인/회원가입 페이지 =================================
    
    // 아이디 중복체크
    public boolean idCheck(String id) {
        return dao.getMember(id) != null ? true : false; 
    }
    
    // 회원가입
    public boolean addMember(MemberDto dto) {
    	
        dto.setPw(passwordEncoder.encode(dto.getPw()));
    	int count = dao.addMember(dto);
        return count>0;
    }
    
    // 로그인
    public MemberDto login(MemberDto dto) {
    	
    	MemberDto member = dao.login(dto.getId());   // ← service.login()에 dto 전체가 아니라 id만 전달

        if (member == null) {
            return null;   // 아이디 없음
        }
        if (!passwordEncoder.matches(dto.getPw(), member.getPw())) {   // ← 입력한 비밀번호와 암호화된 값 비교
            return null;   // 비밀번호 틀림
        }

        member.setPw(null);   // ← 응답에 암호화된 비밀번호가 노출되지 않도록 제거
    	
        return member;
    }

    
//=============================== 마이 페이지 =================================
    
 // 마이페이지 회원정보
    public MemberDto getMember(String id) {

        return dao.getMember(id);
    }


    // 현재 차량 상태와 주차 위치 조회
    public CarStatusDto getCarStatus(String id) {

        CarStatusDto dto = dao.getCarStatus(id);

        // 입출차 기록이 한 번도 없으면 기본 상태를 출차로 설정
        if (dto == null) {
            dto = new CarStatusDto();
            dto.setCarStat(2);
            dto.setCarStatus("출차");
            dto.setFloor(null);
            dto.setSpcNo(null);
            dto.setEntTime(null);
            dto.setDiscntAt(null);
            dto.setParkingMinutes(0);
            dto.setCurrentCost(0);
            return dto;
        }

        // 차량 상태 문자열 설정
        if (dto.getCarStat() == 0) {
            dto.setCarStatus("입차");
        } else if (dto.getCarStat() == 1) {
            dto.setCarStatus("주차");
        } else if (dto.getCarStat() == 2) {
            dto.setCarStatus("출차");
            dto.setFloor(null);
            dto.setSpcNo(null);
            dto.setParkingMinutes(0);
            dto.setCurrentCost(0);
            return dto;
        } else if (dto.getCarStat() == 3) {
            dto.setCarStatus("정산");
        } else {
            dto.setCarStatus("상태 확인 불가");
            dto.setFloor(null);
            dto.setSpcNo(null);
            dto.setParkingMinutes(0);
            dto.setCurrentCost(0);
            return dto;
        }

        // 점주 차량은 정기차량이므로 예상 주차요금 0원
        if (dto.getAuth() == 2) {
            dto.setCurrentCost(0);

            if (dto.getEntTime() != null) {
                LocalDateTime entranceTime = dto.getEntTime().toLocalDateTime();
                LocalDateTime currentTime = LocalDateTime.now();
                long totalMinutes = Duration.between(entranceTime, currentTime).toMinutes();

                if (totalMinutes < 0) {
                    totalMinutes = 0;
                }

                dto.setParkingMinutes((int) totalMinutes);
            }

            return dto;
        }

        Timestamp entTime = dto.getEntTime();

        // 입차시간이 없으면 주차시간과 요금 0
        if (entTime == null) {
            dto.setParkingMinutes(0);
            dto.setCurrentCost(0);
            return dto;
        }

        // 현재까지 총 주차시간 계산
        LocalDateTime entranceTime = entTime.toLocalDateTime();
        LocalDateTime currentTime = LocalDateTime.now();
        long totalMinutes = Duration.between(entranceTime, currentTime).toMinutes();

        if (totalMinutes < 0) {
            totalMinutes = 0;
        }

        dto.setParkingMinutes((int) totalMinutes);

        // 입차 후 15분 이내면 회차 차량
        if (totalMinutes <= 15) {
            dto.setCurrentCost(0);
            return dto;
        }

        long chargeMinutes = totalMinutes;

        // 할인 적용 시 2시간 차감
        if (dto.getDiscntAt() != null) {
            chargeMinutes = chargeMinutes - 120;
        }

        // 할인 후 유료시간이 없으면 0원
        if (chargeMinutes <= 0) {
            dto.setCurrentCost(0);
            return dto;
        }

        // 남은 시간을 1시간 단위로 올림
        int chargeHours = (int) Math.ceil(chargeMinutes / 60.0);

        // 시간당 2,000원
        int currentCost = chargeHours * 2000;

        dto.setCurrentCost(currentCost);

        return dto;
    }


    // 내 차량 이용내역
    public List<CarStatusDto> getParkingHistory(String id) {

        return dao.getParkingHistory(id);
    }


    // 비밀번호 변경
    public boolean updatePw(String id, String currentPw, String newPw) {
    	// 1. 현재 회원 정보(암호화된 pw 포함) 조회
        MemberDto member = dao.login(id);   // login에서 만든 id-only 조회 메소드 재사용 가능

        if (member == null) {
            return false;   // 회원 없음
        }

        // 2. 입력한 현재 비밀번호가 맞는지 확인
        if (!passwordEncoder.matches(currentPw, member.getPw())) {
            return false;   // 현재 비밀번호 불일치 → 변경 거부
        }

        // 3. 검증 통과하면 새 비밀번호 암호화해서 업데이트
        MemberDto dto = new MemberDto();
        dto.setId(id);
        dto.setPw(passwordEncoder.encode(newPw));

        int count = dao.updatePw(dto);

        return count > 0;
    }

    // 전화번호 변경
    public boolean updatePhone(MemberDto dto) {

        int count = dao.updatePhone(dto);
        
        return count > 0 ? true:false;
    }


    // 이메일 변경
    public boolean updateEmail(MemberDto dto) {
    	
    	 int count = dao.updateEmail(dto);
    	
    	 return count > 0 ? true:false;
    }


    // 차량정보 변경
    public boolean updateCar(MemberDto dto) {
    	
    	int count = dao.updateCar(dto);
    	
    	return count > 0 ? true:false;
    }
    
//================================== 점주 페이지 ===================================
    
//================================== 관리자 페이지 ===================================  
    
    // 점주 목록 조회
    public List<MemberDto> selectOwnerList(String category, String keyword, int pageNum) {
        return dao.selectOwnerList(category, keyword, pageNum);
    }
    
    // 일반 회원 목록 조회
    public List<MemberDto> selectMemberList(String category, String keyword, int pageNum) {
        return dao.selectMemberList(category, keyword, pageNum);
    }
    
    // 일반 회원 인원 수
    public int selectListCount(String category, String keyword) {
        return dao.selectListCount(category, keyword);
    }
    
    // 회원정보 수정
    public boolean updateMemberByAdmin(MemberDto dto) {

        int count = dao.updateMemberByAdmin(dto);
        
        return count > 0 ? true : false;
    }
    
    // 회원 삭제 (일반회원/점주 공용) : 소프트 삭제
    // id, pw를 각각 무작위 문자열(UUID)로 교체(탈퇴한 아이디 재사용 허용, 로그인 불가 처리) + auth=0
    public boolean deleteMember(String id) {

        String del = UUID.randomUUID().toString();

        Map<String, String> params = new HashMap<>();
        params.put("old", id);
        params.put("new", del);

        int count = dao.deleteMember(params);
        return count > 0 ? true : false;
    }
    
    
}