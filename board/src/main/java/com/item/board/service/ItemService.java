package com.item.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.item.board.dto.Item;

public interface ItemService {

	public ArrayList<Item> listAllItem();

	public void insertItem(Item item);

	public void updateItem(Item item);

	public int deleteItem(int itemNo);

	public int detailViewItem(int itemNo);

	public int itemNoCheck(int itemNo);

	public ArrayList<Item> itemSearch(HashMap<String, Object> map);
}
