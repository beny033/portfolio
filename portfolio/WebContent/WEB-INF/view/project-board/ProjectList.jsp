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
<script>menuColor('project');</script>
<title>프로젝트 게시판</title>
</head>
<body>
  <jsp:include page="/include/Header.jsp"/>
	<div id="project">
      <div class="board_title"><h2>프로젝트</h2></div>
	<table id="project">	
	 <tr id="line">
	  <th>번호</th>
	  <th>제목</th>
	  <th>작성자</th>
	  <th>상태</th>
	  <th>작성일</th>
	  <th>조회수</th>
	 </tr>
	  <c:forEach var="list" items="${list}">
	   <tr>
	     <td>${list.SEQ }</td>
	     <td>
	     <a href="countPlus.htm?seq=${list.SEQ}&count=${list.COUNT}&subject=${list.SUBJECT}&writer=${list.WRITER}&content=${list.CONTENT}&status=${list.Status}&members=${list.MEMBERS}&mod=${list.MOD_DATE}" onclick='countPlus();'>${list.SUBJECT}</a></td>
	     <td>${list.WRITER }</td>
	     <td>${list.Status }</td>
	     <td>${list.CRE_DATE }</td>
	     <td id="count">${list.COUNT }</td>
	   </tr>
	  </c:forEach>
	 <tr>
	   <td id="text"><a href="projectWriteForm.htm" class="write"><button id="writebtn">글쓰기</button></a></td>
	 </tr>
	</table>
	</div>
  <jsp:include page="/include/Tail.jsp"/>
</body>
</html>