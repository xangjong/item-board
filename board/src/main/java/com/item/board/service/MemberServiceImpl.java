package com.item.board.service;

import com.item.board.model.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;


    @Override
    public void createUser(MemberVO memberVO) {
        memberService.createUser(memberVO);
    }

    @Override
    public void login(MemberVO memberVO) {
        memberService.login(memberVO);
    }
}
