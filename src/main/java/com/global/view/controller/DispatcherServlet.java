package com.global.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.global.biz.board.BoardVO;
import com.global.biz.board.impl.BoardDAO;
import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. 사용자의 요청 경로 정보추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. 사용자의 요청 경로에 따라 적절히 분기 처리해야함
		
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			//1. 사용자 입력 정보를 추출함
			  String id = request.getParameter("id");
			  String password = request.getParameter("password");

			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. 화면 내비케이션
			if(user != null) {
				response.sendRedirect("getBoardList.do");
			}else {
				response.sendRedirect("login.jsp");
			}

		}else if(path.equals("/logout.do")){
			System.out.println("로그아웃 처리");
			  // 1. 브라우저와 연결된 세션 객체를 강제 종료
		    
			HttpSession session = request.getSession();
			
			session.invalidate();
		    
		    // 2. 세션 종료 후, 메인 페이지로 이동함(login.jsp)
		    response.sendRedirect("login.do");
		}else if(path.equals("/insertBoard.do")){
			System.out.println("글 등록 처리");
			// 1.  사용자 입력 정보 추출
//			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");


			// 2. db 연동
			BoardVO vo  = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardDAO boardDAO =new BoardDAO();
			boardDAO.insertBoard(vo);

			//3. 화면 내비케이션
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/updateBoard.do")){
			System.out.println("글 수청 처리");
			// 1. 사용자의 입력정보 추출
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");

			// 2. DB 연동
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);


			// 3. 화면 내비게이션
			response.sendRedirect("getBoardList.do");


		}else if(path.equals("/deleteBoard.do")){
			System.out.println("글 삭제 처리");
			// 1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);

			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
		}else if(path.equals("/getBoard.do")){
			System.out.println("글 상세조회 처리");
			// 1. 검색할 게시글을 번호 추출
			String seq = request.getParameter("seq");

			// 2. db연동
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			
			
			 HttpSession session = request.getSession();
			 session.setAttribute("board", board);
			 response.sendRedirect("getBoard.jsp");
			
		}else if(path.equals("/getBoardList.do")){
			System.out.println("글 목록 검색 처리");
			
			// DB 연동
		    BoardVO vo =new BoardVO();
		    BoardDAO boardDAO = new BoardDAO();
		    List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// 검색 결과를 세션에 저장하고 목록 화면으로 이동
		    HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
	}
}
