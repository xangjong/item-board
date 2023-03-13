package com.spring.board.service;

import com.spring.board.dto.BoardDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;


public interface BoardService {

    public ArrayList<BoardDTO> getBoardList(HashMap<String, Object> map);

    public int getBoardCount();

    public void insertItem(BoardDTO board);

    public BoardDTO detailItem(int item_No);

    public void updateItem(BoardDTO board);

    public void deleteItem(int item_No);

    public int ItemNoCheck(int item_No);

    public ArrayList<BoardDTO> itemSearch(HashMap<String, Object> map);
}
