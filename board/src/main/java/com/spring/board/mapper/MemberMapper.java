package com.spring.board.mapper;

import com.spring.board.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    // 로그인
    public MemberDTO getMemberAccount(String memberId);

    // 회원 가입
    public void saveMember(MemberDTO memberDTO);

    // 아이디 중복체크
    public int memberIdCheck(String memberId);

}
