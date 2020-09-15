package com.global.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.global.view.board.DeleteBoardController;
import com.global.view.board.GetBoardController;
import com.global.view.board.GetBoardListController;
import com.global.view.board.InsertBoardController;
import com.global.view.board.UpdateBoardController;
import com.global.view.user.LoginController;
import com.global.view.user.LogoutController;

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
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
		
}
