<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정(관리자)</title>
</head>
<body>
  <jsp:include page="/include/Header.jsp"/>
	<h2>관리자 페이지 - 회원정보 수정</h2>
	<hr> <p>
	
	<form action="memberModify.htm" method="post">
		<table>
		  <tr>
		    <th>SEQ. </th>
		    <td><input type="text" name="seq" value="${param.seq }" readonly/></td>
		  </tr>
		  
		  <tr>
		    <th>ID </th>
		    <td><input type="text" name="id"></td>
		  </tr>
		  <tr>
		    <th>NAME </th>
		    <td><input type="text" name="name"></td>
		  </tr>
		  
		  <tr>
		    <th>PASSWORD </th>
		    <td><input type="password" name="pwd"></td>
		  </tr>
		  
		  <tr>
		    <th>GENDER </th>
		    <td>
		      <input type="radio" name="gender" value="Male"> 남
		      <input type="radio" name="gender" value="Female"> 여
		    </td>
		  </tr>
		  
		  <tr>
		    <th>ADDRESS </th>
		    <td><input type="text" name="address"></td>
		  </tr>
		  
		  <tr>
		    <th>EMAIL </th>
		    <td><input type="email" name="email"></td>
		  </tr>
		</table>
		  <input type="submit" value="수정하기">
		  <input type="reset" value="다시작성">
	</form>
  <jsp:include page="/include/Tail.jsp"/>
</body>
</html>