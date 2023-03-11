package com.spring.board.service;

import com.spring.board.dto.BoardDTO;

import java.util.ArrayList;
import java.util.HashMap;


public interface BoardService {
//    int insert(Board board);
//
//    List<Board> list();
//
//    void readCnt(int bno);
//
//    Board select(int bno);
//
//    int update(Board board);
//
//    int delete(int bno);

    public ArrayList<BoardDTO> listAll();

    public void insertItem(BoardDTO board);

    public void updateItem(BoardDTO board);

    public void deleteItem(int itemNo);

    public BoardDTO detailViewItem(int itemNo);

    public int ItemNoCheck(int itemNo);

    public ArrayList<BoardDTO> itemSearch(HashMap<String, Object> map);
}
