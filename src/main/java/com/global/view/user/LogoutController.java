package com.global.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.global.view.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("로그 아웃 처리 ............");
		
		// 브라우저와 연결된 세션 객체를 강제 종료
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 화면 네비게이션
		return "login";
	}

}
