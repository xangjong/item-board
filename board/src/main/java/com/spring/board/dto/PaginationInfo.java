package cenno.bo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class PaginationInfo {

    private int currentPageNo = 1;          //-- 현재 페이지 번호
    private int recordsPerPage = 20;         //-- 페이지당 출력할 게시물 수
    private int pageSize = 10;               //-- 하단에 출력할 페이지 리스트 크기 (1~10, 1~15, 등)
    private String[] unitList;          //-- 페이지당 출력할 게시물 수 리스트 (10, 50, 100)

    private int totalRecordCount;       //-- 총 게시물 수
    private int totalPageCount = 1;         //-- 총 페이지 수
    private int firstPageNoOnPageList = 1;  //-- 페이지 리스트 중 첫 페이지 번호
    private int lastPageNoOnPageList = 1;   //-- 페이지 리스트 중 마지막 페이지 번호
    private int firstRecordIndex;       //-- SQL 조건절에서 첫 ROWNUM
    private int lastRecordIndex;        //-- SQL 조건절에서 마지막 ROWNUM
    private boolean hasPreviousPage;    //-- 이전 페이지 존재 여부
    private boolean hasNextPage;        //-- 다음 페이지 존재 여부

    public PaginationInfo(@Value("${paging.unit}") String globalPageNo, @Value("${paging.size}") String globalPageSize) {
        this.currentPageNo = Integer.parseInt(globalPageNo);
        this.recordsPerPage = Integer.parseInt(globalPageSize);
        //this.unitList = globalUnitList.split("\\|");
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;

        pagingProcess();
    }

    private void pagingProcess() {
        //if (totalRecordCount > 0) {
        totalPageCount = ((totalRecordCount - 1) / recordsPerPage) + 1;

        firstPageNoOnPageList = ((currentPageNo - 1) / pageSize) * pageSize + 1;
        lastPageNoOnPageList = firstPageNoOnPageList + pageSize - 1;
        if (lastPageNoOnPageList > totalPageCount) lastPageNoOnPageList = totalPageCount;

        firstRecordIndex = (currentPageNo - 1) * recordsPerPage;
        lastRecordIndex = currentPageNo * recordsPerPage;

        hasPreviousPage =  currentPageNo > 1;
        hasNextPage = currentPageNo < totalPageCount;
        //}
    }
}
