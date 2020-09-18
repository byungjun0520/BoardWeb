package com.global.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.global.biz.board.BoardListVO;
import com.global.biz.board.BoardService;
import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
		
	}
	
	
	/* Json
	public List<BoardVO> dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
		
		
	}*/
	
	
	
	
	
	// 글 등록
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException{
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
		String filename = uploadFile.getOriginalFilename();
		uploadFile.transferTo(new File("C:/upload/"+filename));			
		}
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