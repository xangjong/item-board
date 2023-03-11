package com.spring.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Getter
@ToString
public class BoardDTO {

    private int item_No;
    private String item_Name;
    private String item_Detail;
    private int item_Quantity;
    private int item_Price;
    private String item_Image;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date reg_DateTime;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date mod_DateTime;
}
