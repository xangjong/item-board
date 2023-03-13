package com.spring.board.service;

import com.spring.board.controller.BoardController;
import com.spring.board.dto.BoardDTO;
import com.spring.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Override
    public ArrayList<BoardDTO> getBoardList(HashMap<String, Object> map) {
        return boardMapper.getBoardList(map);
    }

    @Override
    public int getBoardCount() {
        return boardMapper.getBoardCount();
    }


    @Override
    public void insertItem(BoardDTO board) {
        boardMapper.insertItem(board);
    }

    @Override
    public BoardDTO detailItem(int item_No) {
        return boardMapper.detailItem(item_No);
    }

    @Override
    public void updateItem(BoardDTO board) {
        boardMapper.updateItem(board);
    }

    @Override
    public void deleteItem(int item_No) {
        boardMapper.deleteItem(item_No);
    }

    @Override
    public int ItemNoCheck(int item_No) {
        return boardMapper.ItemNoCheck(item_No);
    }

    @Override
    public ArrayList<BoardDTO> itemSearch(HashMap<String, Object> map) {
        return boardMapper.itemSearch(map);
    }
}
