<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/myInfo.css"/>
<title>개인정보 수정</title>
</head>
<body>
  <jsp:include page="/include/Header.jsp"/>
  <div id = "info">
	<h2>${name}님의 개인 정보</h2> <p>
    <form action="myInfoUpdate.htm?seq=${seq}" method="post">
		<table>
		  <tr>
		    <th>아이디(*) </th>
		    <td><input type="text" name="id" value="${id}" required autofocus></td>
		  </tr>  
		  
		  <tr>
		    <th>이름(*) </th>
		    <td><input type="text" name="name" value="${name}" required></td>
		  </tr>
		  
		  <tr>  
		    <th>비밀번호 </th>
		    <td><input type="password" name="password"></td>
		  </tr>  
		  
		  <tr>  
		    <th>비밀번호 확인 </th>
		    <td><input type="password" name="passwordCheck"></td>
		  </tr>  

		  <tr>  
		    <th>주소(*) </th>
		    <td><input type="text" name="address" value="${address}" required></td>
		  </tr> 
		  
		  <tr>  
		    <th>이메일 </th>
		    <td><input type="text" name="email" value="${email}"></td>
		  </tr>  
		  
		  <tr>  
		    <th>가입일 </th>
		    <td><input type="text" name="email" value="${cre_date}" readonly></td>
		  </tr>	
		  
		  <tr>	
		    <th>수정일 </th>
		    <td><input type="text" name="email" value="${mod_date}" readonly></td>
		  </tr>
		</table>
	 	<div id="buttons">
	 	  <input type="submit" value="수정" id="submit">
	 	  <a href="#"onclick="history.back();"><input type="button" value="뒤로가기" id="backbtn"></a>
	 	</div>
    </form>
  </div>
  <jsp:include page="/include/Tail.jsp" />
	
</body>
</html>