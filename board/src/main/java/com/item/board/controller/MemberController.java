package com.item.board.controller;

import com.item.board.model.MemberVO;
import com.item.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    // 회원가입
    @PostMapping(value = "/join")
    public String join(MemberVO memberVO) throws Exception{

        String rawPw = "";
        String encodePw = "";

        rawPw = memberVO.getMemberPw();
        encodePw = passwordEncoder.encode(rawPw);
        memberVO.setMemberPw(encodePw);

        memberService.insertUser(memberVO);

        return "redirect:/main";
    }

    // 로그인
    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) {

        HttpSession httpSession = request.getSession();
        String rawPw = "";
        String encodePw = "";

        MemberVO vo = memberService.createUser(member);

        if (vo != null) {  // 일치하는 아이디 존재시
            rawPw = member.getMemberPw();   // 사용자가 제출한 비밀번호
            encodePw = vo.getMemberPw();   // 데이터베이스에 저장한 인코딩 비밀번호

            if (true == passwordEncoder.matches(rawPw, encodePw)) {   //비밀번호 일치 여부 판단
                vo.setMemberPw("");    // 인코딩된 비밀번호 정보 지움
                httpSession.setAttribute("member", vo);    // session에 사용자 정보 저장
                return "redirect:/main";
            } else {
                rttr.addFlashAttribute("result", 0);
                return "redirect:/member/login";
            }
        } else {        // 일치하는 아이디가 존재하지 않을 시
            rttr.addFlashAttribute("result", 0);
            return "redirect:/member/login";
        }

    }

}
