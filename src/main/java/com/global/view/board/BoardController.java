package com.global.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {	
		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	
	/*
	 * public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav)
	 * { mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보 저장
	 * mav.setViewName("getBoard.jsp");
	 * 
	 * 
	 * return mav; // View 이름 리턴 }
	 */
	@RequestMapping("/getBoard.do")
	public  String getBoard(BoardVO vo, Model model) {
		//mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보 저장
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장
		//mav.setViewName("getBoard.jsp");
    	//	return mav; // View 이름 리턴
		return "getBoard.jsp";
	}
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		// Null Check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보저장 
	//	mav.setViewName("getBoardList.jsp"); // View 정보저장
		return "getBoardList.jsp";
	}
}