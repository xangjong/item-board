package com.spring.board.dto;

import lombok.Data;

@Data
public class PageVo {
    /*
     * 주석에 사용된 단어 정의
     * 페이지: 화면 아래에 위치하는 특정 페이지를 지칭하는 숫자
     * 인덱스: 특정 페이지에서 특정 게시물을 지시하는 숫자
     */

    int rowCount = 10;     // 한 페이지 당 보여줄 게시물 개수
    int pageCount = 3;     // 한 블럭에 몇 개의 페이지 개수
    int totalCount;        // 총 게시물 개수
    int page;              // 현재 페이지

    int startPage = 1;     // 한 블럭의 시작 페이지: 기본 값 1 // ex) 1 2 3 4 5 일 때 1을 의미.
    int endPage;           // 한 블럭의 끝 페이지

    int totalPageCount;    // 총 페이지 개수

    boolean isPrev = false; // 다음 페이지로 이동하는 버튼 유무
    boolean isNext = false; // 이전 페이지로 이동하는 버튼 유무

    int offset;            // 얼만큼 끊어서 가져올 것인가.

    public PageVo(int totalCount, int page) {

        // 총 페이지 개수 구하기
        setTotalPageCount(totalCount, rowCount);

        // 한 블럭의 첫 페이지 구하기
        setStartPage(startPage, page, pageCount);

        // 한 블럭의 끝 페이지 구하기
        setEndPage(startPage, pageCount, totalPageCount);

        // 이전 블록 버튼 유무 판별하기
        isPrev(page, pageCount);

        // 다음 블록 버튼 유무 판별하기
        isNext(endPage, totalPageCount);

        // offset 구하기
        setOffset(page, rowCount);
    }


    // 총 페이지 개수 구하기
    private void setTotalPageCount(int totalCount, int rowCount) {
        this.totalPageCount = (int) Math.ceil(totalCount * 1.0 / rowCount);
    }


    // 한 블럭의 첫 페이지 구하기
    private void setStartPage(int startPage, int page, int pageCount) {
        this.startPage = startPage + (((page - startPage) / pageCount) * pageCount);
    }


    // 한 블럭의 끝 페이지 구하기
    private void setEndPage(int startPage, int pageCount, int totalPageCount) {
        this.endPage = ((startPage - 1) + pageCount) < totalPageCount ? (startPage - 1) + pageCount : totalPageCount;
    }


    // 이전 블럭으로 이동할 버튼 생성 유무
    private void isPrev(int page, int pageCount) {
        this.isPrev = 1 < ((page * 1.0) / pageCount);
    }


    // 다음 블럭으로 이동할 버튼 생성 유무
    private void isNext(int endPage, int totalPageCount) {
        this.isNext = endPage < totalPageCount;
    }


    // offset 구하기 // 쿼리 select 시 끊어서 가져오기
    private void setOffset(int page, int rowCount) {
        this.offset = (page - 1) * rowCount;
    }
}