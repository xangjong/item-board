package com.spring.board.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.board.dto.BoardDTO;
import com.spring.board.dto.PageVo;
import com.spring.board.service.BoardService;
import com.spring.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;
    // logger
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);


    // 비품 리스트 뷰
    @RequestMapping("/boardList")
    public String getBoardList(
                               @RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "type", defaultValue = "itemCode") String type,
                               @RequestParam(value = "keyword", required = false) String keyword,
                               Model model) throws Exception {

        PageVo pageVo = new PageVo(boardService.getCount(), page); // 모든 게시글 개수 구하기.
        List<BoardDTO> list = boardService.getListPage(pageVo);

        model.addAttribute("list", list);
        model.addAttribute("page", page);
        model.addAttribute("pageVo", pageVo);
        model.addAttribute("keyword", keyword);
        model.addAttribute("type", type);

        return "boardList";
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
        return "redirect:./boardList";
    }

    // 비품 상세 정보 조회
    @GetMapping("detailItem/{itemNo}")
    public String detailItem(@PathVariable("itemNo") int itemNo, Model model) {
        BoardDTO board = boardService.detailItem(itemNo);
        model.addAttribute("board", board);
        return "detailItem";
    }

    // 비품 수정 폼
    @GetMapping("updateItem")
    public String updateItemForm(int itemNo, Model model) {
        BoardDTO board = boardService.detailItem(itemNo);
        model.addAttribute("board", board);
        return "updateItem";
    }

    // 비품 수정 후 저장
    @PostMapping("updateItem")
    public String updateItem(BoardDTO board) {
        boardService.updateItem(board);
        return "redirect:./boardList";
    }

    // 비품 삭제
    @GetMapping("deleteItem/{itemNo}")
    public String deleteItem(@PathVariable("itemNo") int itemNo) {
        boardService.deleteItem(itemNo);
        return "redirect:/boardList";
    }


    // 비품 상세 조회
    @RequestMapping("/itemSearch")
    public String itemSearch(@RequestParam HashMap<String, Object>
                                         map, Model model) {

        List<BoardDTO> list = boardService.itemSearch(map);
        model.addAttribute("list", list);
        return "boardList";
    }
}
