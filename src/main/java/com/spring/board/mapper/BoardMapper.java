package com.spring.board.mapper;

import com.spring.board.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface BoardMapper {
    public ArrayList<BoardDTO> listAll();

    public void insertItem(BoardDTO board);

    public void updateItem(BoardDTO board);

    public void deleteItem(int itemNo);

    public BoardDTO detailViewItem(int itemNo);

    public int ItemNoCheck(int itemNo);

    public ArrayList<BoardDTO> itemSearch(HashMap<String, Object> map);

}
