package com.spring.board.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Data
@Alias("board")
public class Board {
    private int bno;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yy.MM.dd")
    private Date reg_date;
    private int readCnt;
}
