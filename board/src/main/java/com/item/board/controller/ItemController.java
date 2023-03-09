package com.item.board.controller;

import com.item.board.dto.Item;
import com.item.board.service.ItemServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
public class ItemController {

	private final ItemServiceImpl itemServiceImpl;

	public ItemController(ItemServiceImpl itemServiceImpl) {
		this.itemServiceImpl = itemServiceImpl;
	}

// 	전체 도서 조회 요청 처리
	@RequestMapping("/item/bookAllList")
	public String viewBookAllList(Model model) {
		// 서비스 클래스의 메소드 호출해서 결과 받아옴
		ArrayList<Item> itemList = itemServiceImpl.listAllItem();
		// 모델 설정
		model.addAttribute("itemList", itemList);
		return "item/bookAllListView";
	}
	
	// 도서 등록 폼 열기 요청 처리
	@RequestMapping("/item/itemNewForm")
	public String viewItemNewForm() {
		return "item/itemNewForm";
	}
	
	// 도서 등록 : 도서 정보 DB 저장
	@RequestMapping("/item/insertItem")
	public String insertProduct(Item item) {
		itemServiceImpl.insertItem(item);
		
		// DB에 데이터 저장한 후 전체 상품 조회 화면으로 포워딩
		return "redirect:./itemAllList";
	}
	
	// 도서 상세 정보 조회 : 1개 상품 조회
	@RequestMapping("/item/itemDetailView/{itemNo}")
	public String detailViewProduct(@PathVariable int itemNo, Model model) {
		int item = itemServiceImpl.detailViewItem(itemNo);
		model.addAttribute("item", item);
		return "item/itemDetailView";
	}
	
	// 상품 정보 수정 폼 열기 요청 처리
	@RequestMapping("/item/itemUpdateForm/{itemNo}")
	public String updateBookForm(@PathVariable int itemNo, Model model) {
		// 수정할 상품번호 받아서, detailViewProduct()메소드 호출하면서 전달하고
		// 해당 상품 정보 (1개) 받아서 모델 설정
		int item = itemServiceImpl.detailViewItem((itemNo));
		model.addAttribute("item", item);
		return "item/itemUpdateForm";
	}
	
	// 수정 내용 DB 저장
	@RequestMapping("/item/updateBook")
	public String updateProduct(Item item) {
		itemServiceImpl.updateItem(item);
		// DB에 수정된 데이터 저장한 후 전체 상품 조회 화면으로 포워딩
		return "redirect:./itemAllList";
	}
	
	// 도서 정보 삭제
	@RequestMapping("/item/deleteItem/{itemNo}")
	public String deleteProduct(@PathVariable int itemNo) {
		itemServiceImpl.deleteItem(itemNo);
		// 삭제한 후 전체 도서 조회 화면으로 포워딩
		return "redirect:/item/itemAllList";
	}
	
	
	// 도서 중복 확인
	@ResponseBody
	@RequestMapping("/item/itemNoCheck")
	public String itemNoCheck(@RequestParam("itemNo") int itemNo) {
		
		String itemNoNo_result = String.valueOf(itemServiceImpl.itemNoCheck(itemNo));
		
		String result ="use";
		if(itemNoNo_result !=null)
			result ="no_use";
		
		return result;
	}
	
	// 도서 검색 폼 열기 요청 처리
		@RequestMapping("/item/itemSearchForm")
		public String viewItemSearchForm() {
		return "item/itemSearchForm";
	}
	
	// 도서 검색 : 방법2
	@RequestMapping("/item/itemSearch")
	public String bookSearch(@RequestParam HashMap<String, Object> param, Model model){
		ArrayList<Item> itemList = itemServiceImpl.itemSearch(param);
		
		model.addAttribute("itemList", itemList);
		
		return "item/itemSearchResultView"; // 뷰 페이지 반납
	}	
	
	
}
