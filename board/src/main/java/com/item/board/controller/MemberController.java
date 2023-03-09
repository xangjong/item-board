package com.item.board.controller;

import com.item.board.dto.Member;
import com.item.board.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    MemberServiceImpl memberServiceImpl;

    @RequestMapping("/")
    public String viewIndex() {
        return "index";
    }

    @GetMapping("/join")
    public String sigunUpForm() {
        return "join";
    }

    @PostMapping("/signUp")
    public String singUp(Member member) {
        memberServiceImpl.createUser(member);
        return "redirect:/login";
    }

}
