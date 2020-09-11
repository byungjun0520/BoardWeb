<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="com.global.biz.board.impl.BoardDAO" %>
<%@ page import="com.global.biz.board.BoardVO" %>

<%

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
response.sendRedirect("getBoardList.jsp");







%>








<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>