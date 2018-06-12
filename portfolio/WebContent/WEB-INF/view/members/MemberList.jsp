<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<style>
 table,tr,th,td {text-align:center;}
 a{text-decoration:none;}
</style>
</head>
<body>
	<jsp:include page="/include/Header.jsp"/>
	<h2>회원 리스트</h2>
	<hr> <p>
	
	<table border="1">
	  <tr>
	    <th>
	    <c:forEach var="list" items="${list}" begin="0" end="0" >
	      <c:choose>
	        <c:when test="${list.SEQ eq 1 }">
	    	  <a id="sort" href="descList.htm" style=text-decoration:none;color:black;>내림차순 정렬</a>
	        </c:when>
	        <c:otherwise>
	    	  <a id="sort" href="memberList.htm" style=text-decoration:none;color:black;>오름차순 정렬</a>
	        </c:otherwise>
	      </c:choose>
	    </c:forEach>
	    </th>
	    <th>ID</th>
	    <th>Name</th>
	    <th>Password</th>
	    <th>Gender</th>
	    <th>Address</th>
	    <th>Email</th>
	    <th>Cre_date</th>
	    <th>Mod_date</th>
	    <th>Modify</th>
	    <th>Delete</th>
	  </tr>
	  
	  <c:forEach var="list" items="${list}">
	  <tr>
	    <td>${list.SEQ}</td>
	    <td>${list.ID}</td>
	    <td>${list.NAME}</td>
	    <td>${list.PASSWORD}</td>
	    <td>${list.GENDER}</td>
	    <td>${list.ADDRESS}</td>
	    <td>${list.EMAIL}</td>
	    <td>${list.CRE_DATE}</td>
	    <td><a href="memberModifyForm.htm?seq=${list.SEQ}">[수정]</a></td>
	    <td>${list.MOD_DATE}</td>
	    <td><a href="memberDeleteForm.htm?seq=${list.SEQ}">[삭제]</a></td>
	  </tr>	  
	  </c:forEach>
	</table>
	<jsp:include page="/include/Tail.jsp"/>
</body>
</html>