package com.item.board.service;

import com.item.board.model.MemberVO;

public interface MemberService {

    //회원가입
    void createUser(MemberVO memberVO);

    //로그인
    void login(MemberVO memberVO);
}
