<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/projectList.css"/>
<link rel="script" type="text/javascript" href="js/jsFunction.js"/>
<script src="js/jsFunction.js" type="text/javascript"></script>
<script>menuColor('free');</script>
<title>자유 게시판</title>
</head>
<body>	
	<jsp:include page="/include/Header.jsp"/>
	<table id="project" style= margin-top:50px;>
	  <caption>검색 결과입니다.</caption>
	<tr id="line">
	  <th>번호</th>
	  <th>제목</th>
	  <th>작성자</th>
	  <th>작성일</th>
	  <th>조회수</th>
	</tr>
	<c:forEach var="list" items="${list}">
	  <tr>
	    <td>${list.SEQ}</td>
	    <td><a href="free_countPlus.htm?seq=${list.SEQ}&count=${list.COUNT}&subject=${list.SUBJECT}&writer=${list.WRITER}&content=${list.CONTENT}&mod=${list.MOD_DATE}" onclick='countPlus();'>${list.SUBJECT}</a></td>
	    <td>${list.WRITER}</td>
	    <td>${list.CRE_DATE}</td>
	    <td>${list.COUNT}</td>
	  </tr>
	</c:forEach>
	  <tr>
	    <td id="text"><a href="freeBoardWriteForm.htm" class="write"><input type="button" id="writebtn" value="글쓰기"></a></td>
	  </tr>
	</table>
<jsp:include page="/include/Tail.jsp"/>
</body>
</html>
	        
