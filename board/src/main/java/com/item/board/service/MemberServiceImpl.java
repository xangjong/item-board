package com.item.board.service;

import com.item.board.mapper.MemberMapper;
import com.item.board.dto.Member;
import com.item.board.state.ROLE;
import com.item.board.state.UserState;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public void createUser(Member member) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setMemberPw(passwordEncoder.encode(member.getMemberPw()));
//        member.setUSER(ROLE.USER);
//        member.setOFFICE(UserState.OFFICE);
        memberMapper.createUser(member);
    }

    @Override
    public void login(Member member) {
        memberMapper.login(member);
    }
}
