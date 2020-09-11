<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    // 1. 브라우저와 연결된 세션 객체를 강제 종료
    session.invalidate();
    
    // 2. 세션 종료 후, 메인 페이지로 이동함(login.jsp)
    response.sendRedirect("login.jsp");
    
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