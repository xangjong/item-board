package com.spring.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class BoardDTO {

    @NotBlank(message = "비품 번호는 필수 입력사항 입니다.")
    private int item_No;
    @NotBlank(message = "비품 코드는 필수 입력사항 입니다.")
    private String item_Code;
    @NotBlank(message = "비품 명은 필수 입력사항 입니다.")
    private String item_Name;
    private String item_Detail;
    @NotBlank(message = "수량은 필수 입력사항 입니다.")
    private int item_Quantity;
    @NotBlank(message = "가격은 필수 입력사항 입니다.")
    private int item_Price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reg_DateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate mod_DateTime;
}
