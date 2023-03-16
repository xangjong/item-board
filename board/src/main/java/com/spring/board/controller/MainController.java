package com.spring.board.controller;

import com.spring.board.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MainController {


    // 메인 화면
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
