package com.item.board.dao;

import com.item.board.model.MemberVO;
import org.springframework.stereotype.Component;

public interface IMemberDAO {

    //회원가입
    void createUser(MemberVO memberVO);

    //로그인
    void login(MemberVO memberVO);
}
