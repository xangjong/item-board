package com.item.board.service;

import com.item.board.dto.Item;
import com.item.board.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

	private final ItemMapper itemMapper;


	@Override
	public ArrayList<Item> listAllItem() {
		return itemMapper.listAllItem();
	}

	@Override
	public void insertItem(Item item) {
		itemMapper.insertItem(item);
	}

	@Override
	public void updateItem(Item item) {
		itemMapper.updateItem(item);
	}

	@Override
	public Item deleteItem(int itemNo) {
		return itemMapper.deleteItem(itemNo);
	}

	@Override
	public int detailViewItem(int itemNo) {
		return itemMapper.detailViewItem(itemNo);
	}

	@Override
	public int itemNoCheck(int itemNo) {
		return itemMapper.itemNoCheck(itemNo);
	}

	@Override
	public ArrayList<Item> itemSearch(HashMap<String, Object> map) {
		return itemMapper.itemSearch(map);
	}
}
