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
import java.util.Date;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements UserDetailsService, MemberService {

    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);
    private final MemberMapper memberMapper;

    @Transactional
    public void joinUser(MemberDTO memberDTO){

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDTO.setMemberPw(passwordEncoder.encode(memberDTO.getPassword()));

        // 권한 설정
        memberDTO.setMemberRole("USER");


        memberMapper.saveMember(memberDTO);
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        MemberDTO memberDTO = memberMapper.getMemberAccount(memberId);
        if (memberDTO == null){
            throw new UsernameNotFoundException("계정 정보가 존재하지 않습니다.");
        }
        return memberDTO;
    }


    @Override
    public MemberDTO getMemberAccount(String memberId) {
        return memberMapper.getMemberAccount(memberId);
    }

    @Override
    public void saveMember(MemberDTO memberDTO) {
        memberMapper.saveMember(memberDTO);
    }

    @Override
    public int memberIdCheck(String memberId){
        int result = memberMapper.memberIdCheck(memberId);
        return result;
    }

}
