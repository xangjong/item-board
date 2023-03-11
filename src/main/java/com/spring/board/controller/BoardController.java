package com.spring.board.controller;

import com.spring.board.dto.BoardDTO;
import com.spring.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public ModelAndView viewIndex() throws Exception{

        ModelAndView mv = new ModelAndView();

        mv.setViewName("/index");

        return mv;
    }

    @GetMapping ("board")
    public ModelAndView listAll() {

        ModelAndView mv = new ModelAndView("board");

        ArrayList<BoardDTO> boardList = boardService.listAll();

        mv.addObject("boardList", boardList);

        return mv;
    }


//    @GetMapping("/boardWrite")
//    public String boardWrite() {
//        return "boardWrite";
//    }
//
//    @PostMapping("/boardWrite")
//    public String boardWriteForm(Board board, Model model) {
//        boardService.insert(board);
//        return "redirect:/boardList";
//    }
//
//    @GetMapping("boardList")
//    public String boardList(Model model) {
//        List<Board> list = boardService.list();
//        model.addAttribute("list", list);
//        return "boardList";
//    }
//
//    @GetMapping("boardDetail")
//    public String boardDetail(int bno, Model model) {
//        boardService.readCnt(bno);
//        Board board = boardService.select(bno);
//        model.addAttribute("board", board);
//        return "boardDetail";
//    }
//
//    @GetMapping("boardUpdate")
//    public String boardUpdate(int bno, Model model) {
//        Board board = boardService.select(bno);
//        model.addAttribute("board", board);
//        return "boardUpdate";
//    }
//
//    @PostMapping("boardUpdate")
//    public String boardUpdateForm(Board board, Model model) {
//        boardService.update(board);
//        model.addAttribute("board", board);
//        model.addAttribute("bno", board.getBno());
//        return "boardDetail";
//    }
//
//    @GetMapping("boardDelete")
//    public String boardDelete(int bno) {
//        boardService.delete(bno);
//        return "redirect:/boardList";
//    }
}
