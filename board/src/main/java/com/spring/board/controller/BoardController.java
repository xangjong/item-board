package com.spring.board.controller;

import com.spring.board.dto.BoardDTO;
import com.spring.board.page.PagingUtil;
import com.spring.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    // logger
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    // 비품 리스트 뷰
    @RequestMapping("/")
    public ModelAndView listAll(@RequestParam(value="pageNum", defaultValue ="1")
                                    int currentPage) {
        //총 레코드 수
        int count = boardService.getBoardCount();

        logger.debug("pageNum : "+currentPage);
        logger.debug("count : " +count);

        //페이지 처리
        PagingUtil page= new PagingUtil(currentPage, count, 10, 10, "boardList");

        //목록 호출
        ArrayList<BoardDTO> list = null;
        if(count>0) {
            HashMap<String, Object> map = new HashMap<String,Object>();
            map.put("start", page.getStartRow());
            map.put("end", page.getEndRow());

            list = boardService.getBoardList(map);
        }

        // 뷰 이름 지정
        ModelAndView mv = new ModelAndView("boardList");

        //데이터 저장
        mv.addObject("count", count);
        mv.addObject("list",list);
        mv.addObject("page", page.getPage());

        return mv;
    }

    // 비품 등록 폼
    @GetMapping("insertItem")
    public String itemNewForm() {
        return "insertItem";
    }

    // 비품 등록
    @PostMapping("insertItem")
    public String insertItem(BoardDTO board) {
        boardService.insertItem(board);
        return "redirect:./";
    }

    // 비품 상세 정보 조회
    @GetMapping("detailItem/{item_No}")
    public String detailItem(@PathVariable("item_No") int item_No, Model model) {
        BoardDTO board = boardService.detailItem(item_No);
        model.addAttribute("board", board);
        return "detailItem";
    }

    // 비품 수정 폼
    @GetMapping("updateItem")
    public String updateItemForm(int item_No, Model model) {
        BoardDTO board = boardService.detailItem(item_No);
        model.addAttribute("board", board);
        return "updateItem";
    }

    // 비품 수정 후 저장
    @PostMapping("updateItem")
    public String updateItem(BoardDTO board) {
        boardService.updateItem(board);
        return "redirect:./";
    }

    // 비품 삭제
    @GetMapping("deleteItem/{item_No}")
    public String deleteItem(@PathVariable("item_No") int item_No) {
        boardService.deleteItem(item_No);
        return "redirect:/";
    }

}
