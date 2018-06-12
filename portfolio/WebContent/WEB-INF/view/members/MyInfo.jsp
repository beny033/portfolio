<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 페이지</title>
<link rel="stylesheet" type="text/css" href="./view-css/myInfo.css"/>
</head>
<body>
	<jsp:include page="/include/Header.jsp"/>
	  <div id = "info">
		<h2>${name}님의 개인 정보</h2>
		  <span class="text">정보를 수정하려면 아이디를 클릭하세요.</span>
		<p>
		<table>
		  <tr>
		    <th>아이디: </th>
		    <td><a href="myInfoUpdateForm.htm">${id}</a></td>
		  </tr>  
		  
		  <tr>
		    <th>이름: </th>
		    <td>${name}</td>
		  </tr>
		  
		  <tr>  
		    <th>성별: </th>
		    <td>${gender }</td>
		  </tr>  
		  
		  <tr>  
		    <th>주소: </th>
		    <td>${address }</td>
		  </tr> 
		  
		  <tr>  
		    <th>이메일: </th>
		    <td>${email }</td>
		  </tr>  
		  
		  <tr>  
		    <th>가입일: </th>
		    <td>${cre_date }</td>
		  </tr>	
		  
		  <tr>	
		    <th>수정일: </th>
		    <td>${mod_date }</td>
		  </tr>
		</table>
	  </div>
    <jsp:include page="/include/Tail.jsp" />
</body>
</html>