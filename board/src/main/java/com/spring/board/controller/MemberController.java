package com.spring.board.controller;

import com.spring.board.dto.MemberDTO;
import com.spring.board.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberServiceImpl memberService;
    PasswordEncoder encoder;

    /**
     * localhost:8080 시 login 으로 redirect
     * @return
     */


    // 로그인 페이지
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception,
                        Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "login";
    }


    @PostMapping( "/login")
    public String loginPOST(MemberDTO memberDTO, HttpServletRequest request, RedirectAttributes rttr){
        log.info("Controller loginPOST");

        HttpSession session = request.getSession();

        MemberDTO login = memberService.getMemberAccount(memberDTO.getMemberId());

        String failMessage = "아이디 혹은 비밀번호가 잘못 되었습니다.";

        if (login == null) {
            rttr.addFlashAttribute("loginFail", failMessage);
            return "redirect:/login";
        }

        session.setAttribute("loginUser", login);
        return "redirect:/";
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    //   회원가입 폼
    @GetMapping("/signUp")
    public String signUpForm() {
        return "signUp";
    }

    //   회원가입 진행
    @PostMapping("/signUp")
    public String signUp(MemberDTO memberDTO) {
        memberService.joinUser(memberDTO);
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
