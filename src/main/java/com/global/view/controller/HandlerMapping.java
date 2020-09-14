package com.global.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.global.view.board.GetBoardListController;
import com.global.view.user.LoginController;

/*
 * HandlerMapping 
 *   - 모든 Controller 객체들을 저장하고 있다가 사용자의 요청이 들어오면 요청을 처리할 
 *      특정 Controller를 검색하는 기능을 제공함
 * 
 */


public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
	
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
		
}
