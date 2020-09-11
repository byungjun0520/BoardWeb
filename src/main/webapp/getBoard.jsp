<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.global.biz.board.BoardVO" %>   

<%
// 1. 검색할 게시글을 번호 추출
//String seq = request.getParameter("seq");

// 2. db연동
//BoardVO vo = new BoardVO();
//vo.setSeq(Integer.parseInt(seq));
//BoardDAO boardDAO = new BoardDAO();
//BoardVO board = boardDAO.getBoard(vo);

// 3. 응답화면
BoardVO board = (BoardVO)session.getAttribute("board");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글 상세 </title>
</head>
<body>
<div align="center">
<h1>글 상세</h1>
 <a href="logout_proc.jsp">Log-out</a>
<hr>
  <form action="updateBoard.do" method="post">
     <input name="seq" type="hidden" value="<%=board.getSeq()%>">
       <table border="1" cellpadding="0" cellspacing="0">
       
           <tr>
           <td bgcolor="orange" width="70">제목</td>
           <td align="left">
               <input type="text" name="title" value="<%=board.getTitle()%>">
           </td>
           </tr>
           
           <tr>
           <td bgcolor="orange">작성자</td>
           <td align="left"><%=board.getWriter() %></td>
           </tr>
           
           <tr>
           <td bgcolor="orange">내용</td>
           <td align="left">
           <textarea rows="10" cols="40" name="content">
           <%=board.getContent() %> </textarea></td>
           </tr>
           
           <tr>
           <td bgcolor="orange">등록일</td>
           <td align="left"><%=board.getRegDate() %></td>
           </tr>
       
           <tr>
           <td bgcolor="orange">조회수</td>
           <td align="left"><%=board.getCnt() %></td>
           </tr>
           
           <tr>
            <td colspan="2" align="center">
              <input type="submit" value="글수정">
            </td>
          </tr>
       
       </table>
    </form>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;    
<a href="getBoardList.do">글목록</a>    
</div>

</body>
</html>