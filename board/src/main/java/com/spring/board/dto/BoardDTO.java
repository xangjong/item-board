package com.spring.board.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

@Data
public class BoardDTO{

    @NotBlank(message = "비품 번호는 필수 입력사항 입니다.")
    private int itemNo;
    @NotBlank(message = "비품 코드는 필수 입력사항 입니다.")
    private String itemCode;
    @NotBlank(message = "비품 명은 필수 입력사항 입니다.")
    private String itemName;
    private String itemDetail;
    @NotBlank(message = "수량은 필수 입력사항 입니다.")
    private int itemQuantity;
    @NotBlank(message = "가격은 필수 입력사항 입니다.")
    private int itemPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date regDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modDateTime;

    private String type; // 검색 타입
    private String keyword; // 검색 내용


}
