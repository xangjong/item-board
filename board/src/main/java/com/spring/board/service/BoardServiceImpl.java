package com.spring.board.service;

import com.spring.board.controller.BoardController;
import com.spring.board.dto.BoardDTO;
import com.spring.board.mapper.BoardMapper;
import com.spring.board.dto.PageVo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public ArrayList<BoardDTO> getBoardList(HashMap<String, Object> map) {
        return boardMapper.getBoardList(map);
    }

    @Override
    public void insertItem(BoardDTO board) {
        boardMapper.insertItem(board);
    }

    @Override
    public BoardDTO detailItem(int itemNo) {
        return boardMapper.detailItem(itemNo);
    }

    @Override
    public void updateItem(BoardDTO board) {
        boardMapper.updateItem(board);
    }

    @Override
    public void deleteItem(int itemNo) {
        boardMapper.deleteItem(itemNo);
    }

    @Override
    public List<BoardDTO> itemSearch(HashMap<String, Object> map) {
        return boardMapper.itemSearch(map);
    }

    @Override
    public int getCount() {
        return boardMapper.getCount();
    }

    @Override
    public List<BoardDTO> getListPage(PageVo pageVo) {
        return boardMapper.getListPage(pageVo);
    }

}
