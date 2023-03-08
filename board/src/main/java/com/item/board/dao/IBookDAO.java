package com.item.board.dao;

import com.item.board.model.BookVO;

import java.util.ArrayList;
import java.util.HashMap;


public interface IBookDAO {
	public ArrayList<BookVO> listAllBook();
	
	public void insertBook(BookVO bk);
	
	public void updateBook(BookVO bk);
	
	public void deleteBook(String bookNo);
	
	public BookVO detailViewBook(String bookNo);
	
	public String bookNoCheck(String bookNo);
	
	public ArrayList<BookVO> bookSearch(HashMap<String, Object> map);
}
