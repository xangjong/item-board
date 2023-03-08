package com.item.board.service;

import com.item.board.dao.IMemberDAO;
import com.item.board.model.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final IMemberDAO iMemberDAO;


    @Override
    public MemberVO createUser(MemberVO memberVO) {
        iMemberDAO.createUser(memberVO);
        return memberVO;
    }

    @Override
    public void login(MemberVO memberVO) {
        iMemberDAO.login(memberVO);
    }
}
