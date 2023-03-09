package com.item.board.mapper;

import com.item.board.dto.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;


@Mapper
public interface ItemMapper {
	public ArrayList<Item> listAllItem();

	public void insertItem(Item item);

	public void updateItem(Item item);

	public Item deleteItem(int itemNo);

	public int detailViewItem(int itemNo);

	public int itemNoCheck(int itemNo);

	public ArrayList<Item> itemSearch(HashMap<String, Object> map);
}
