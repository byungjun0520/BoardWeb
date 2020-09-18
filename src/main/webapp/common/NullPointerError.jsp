<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러화면</title>
</head>
<body bgcolor="#ffffff" text="#000000">
<!-- 타이틀 시작 -->
<table width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr>
       <td align="center" bgcolor="orange"><b>기본 에러 입니다.</b></td>
    </tr>
</table>
<br>
<!-- 에러 메시지   -->
<table  align="center" width="100%" border="1" cellpadding="0" cellspacing="0">
    <tr>
       
       <td align="center"><br>
       <br><br><br><br>
       Message : ${exception.message }
       <br><br><br><br>
       <br>
       </td>
    </tr>
</table>

</body>
</html>