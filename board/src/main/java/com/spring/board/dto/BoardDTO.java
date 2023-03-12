package com.spring.board.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class BoardDTO {

    private int item_No;
    private String item_Name;
    private String item_Detail;
    private int item_Quantity;
    private int item_Price;
    private String item_Image;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reg_DateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate mod_DateTime;
}
