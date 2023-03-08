package com.item.board.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
public class BookVO {
	private String bookNo;
	private String bookName;
	private int bookPrice;
	private String bookPub;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookDate;
	

	
}
