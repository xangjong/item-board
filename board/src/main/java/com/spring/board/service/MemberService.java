package com.spring.board.service;

import com.spring.board.dto.MemberDTO;
import com.spring.board.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public interface MemberService {


    // 로그인
    public MemberDTO getMemberAccount(String memberId);

    // 회원 가입
    public void saveMember(MemberDTO memberDTO);

    // 아이디 중복체크
    public int memberIdCheck(String memberId);

}
