package com.global.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.view.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("글 목록 검색 처리.................");
		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		return "getBoardList";
	}

}
