package com.spring.board.service;

import com.spring.board.dto.BoardDTO;
import com.spring.board.dto.PageVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public interface BoardService {

    // 리스트 조회
    public ArrayList<BoardDTO> getBoardList(HashMap<String, Object> map);

    // 비품 등록
    public void insertItem(BoardDTO board);

    // 비품 상세정보 조회
    public BoardDTO detailItem(int itemNo);

    // 비품 정보 수정
     public void updateItem(BoardDTO board);

    // 비품 정보 삭제
    public void deleteItem(int itemNo);

    // 비품 검색
    public List<BoardDTO> itemSearch(HashMap<String, Object> map);

    // 페이징을 위한 전체 데이터 개수 파악
    public int getCount();

    // 페이징을 위한 getListPage 메소드 추가
    public List<BoardDTO> getListPage(PageVo pageVo);


}
