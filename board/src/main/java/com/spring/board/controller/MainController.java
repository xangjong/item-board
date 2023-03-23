package com.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    // 메인 화면
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
