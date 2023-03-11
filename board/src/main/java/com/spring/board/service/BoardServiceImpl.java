package com.spring.board.service;

import com.spring.board.dto.BoardDTO;
import com.spring.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;


    @Override
    public ArrayList<BoardDTO> listAll() {
        return boardMapper.listAll();
    }

    @Override
    public void insertItem(BoardDTO board) {
        boardMapper.insertItem(board);
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
    public BoardDTO detailViewItem(int itemNo) {
        return boardMapper.detailViewItem(itemNo);
    }

    @Override
    public int ItemNoCheck(int itemNo) {
        return boardMapper.ItemNoCheck(itemNo);
    }

    @Override
    public ArrayList<BoardDTO> itemSearch(HashMap<String, Object> map) {
        return boardMapper.itemSearch(map);
    }
}
