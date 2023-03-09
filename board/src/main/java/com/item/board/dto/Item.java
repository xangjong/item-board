package com.item.board.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
public class Item {

	private int itemNo;
	private String itemName;
	private String itemDetail;
	private int itemQuantity;
	private int itemPrice;
	private String itemImage;

}
