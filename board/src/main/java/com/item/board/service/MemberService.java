package com.item.board.service;

import com.item.board.dto.Member;

public interface MemberService {

    //회원가입
    void createUser(Member member);

    //로그인
    void login(Member member);
}
