package com.spring.board.controller;

import com.spring.board.dto.MemberDTO;
import com.spring.board.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberService;


    /**
     * localhost:8080 시 login 으로 redirect
     * @return
     */


    // 로그인 페이지
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "login";
    }

    //   회원가입 폼
    @GetMapping("/signUp")
    public String signUpForm() {
        return "signUp";
    }

    //   회원가입 진행
    @PostMapping("/signUp")
    @ResponseBody
    public String signUp(@RequestParam HashMap<String, Object> map, Model model) {

        MemberDTO memberDTO = new MemberDTO();

        map.put("memberId", memberDTO.getMemberId());
        map.put("memberName", memberDTO.getMemberName());
        map.put("memberPw", memberDTO.getMemberPw());

        memberService.joinUser(memberDTO);

        model.addAttribute(map);

        return "redirect:/";
    }

    // 아이디 중복 검사
    @PostMapping("/memberIdCheck")
    @ResponseBody
    public int memberIdCheck(@RequestParam("memberId") String memberId) {
        int result = memberService.memberIdCheck(memberId);
        return result;
    }


}
