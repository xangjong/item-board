package com.spring.board.mapper;

import com.spring.board.dto.BoardDTO;
import com.spring.board.dto.PageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
    public ArrayList<BoardDTO> getBoardList(HashMap<String, Object> map);

    public void insertItem(BoardDTO board);

    public BoardDTO detailItem(int itemNo);

    public void updateItem(BoardDTO board);

    public void deleteItem(int itemNo);

    public int ItemNoCheck(int itemNo);

    public ArrayList<BoardDTO> itemSearch(HashMap<String, Object> map);

    // 페이징을 위한 전체 데이터 개수 파악
    public int getCount();

    // 페이징을 위한 getListPage 메소드 추가
    public List<BoardDTO> getListPage(PageVo pageVo);

}
