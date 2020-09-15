package com.global.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.global.biz.user.UserVO;
import com.global.biz.user.impl.UserDAO;


public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("로그인 처리.....");
		
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
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			mav.setViewName("getBoardList.do");
		}else {
			mav.setViewName("login.jsp");
		}
	
		return mav;
	}

}
