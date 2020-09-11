<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.global.biz.user.impl.UserDAO" %>    
<%@ page import="com.global.biz.user.UserVO" %>    
    
<%

//1. 사용자 입력 정보를 추출함
/*   String id = request.getParameter("id");
 String password = request.getParameter("password");
 */
// 2. DB 연동 처리
/* UserVO vo = new UserVO();
vo.setId(id);
vo.setPassword(password);

UserDAO userDAO = new UserDAO();
UserVO user = userDAO.getUser(vo);
 */
// 3. 화면 내비케이션
/* if(user != null) {
	response.sendRedirect("getBoardList.jsp");
}else {
	response.sendRedirect("login.jsp");
}
 */
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>