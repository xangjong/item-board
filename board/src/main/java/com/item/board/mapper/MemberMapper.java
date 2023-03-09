package com.item.board.mapper;

import com.item.board.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    //회원가입
    void createUser(Member member);

    //로그인
    void login(Member member);
}
