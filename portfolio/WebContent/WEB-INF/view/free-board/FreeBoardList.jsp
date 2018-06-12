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
	<div id="project"> 
      <div class="board_title"><h2>자유 게시판</h2></div>
	  <form action="searchResult.htm" method="post">
	    <table id="project">
	      <tr id="serch">
	        <th>
	          <select id="select" name="searchType">
	            <option value="writer">작성자</option>
	            <option value="subject">제목</option>
	            <option value="content">내용</option>
	          </select>
	        </th>
	        <td><input type="text" name="searchText" id="searchText" required></td>
	        <td><input type="submit" value="검색" id="submit"></td>
	      </tr>
	      <tr id="line">
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일</th>
	        <th>조회수</th>
	      </tr>
	    <c:forEach var="list" items="${list}">
	      <tr>
	        <td>${list.SEQ }</td>
	        <td>
	        <a href="free_countPlus.htm?seq=${list.SEQ}&count=${list.COUNT}&subject=${list.SUBJECT}&writer=${list.WRITER}&content=${list.CONTENT}&mod=${list.MOD_DATE}" onclick='countPlus();'>${list.SUBJECT}</a></td>
	        <td>${list.WRITER }</td>
	       <td>${list.CRE_DATE }</td>
	        <td id="count">${list.COUNT }</td>
	      </tr>
	    </c:forEach>
	      <tr>
	        <td id="text"><a href="freeBoardWriteForm.htm" class="write"><input type="button" id="writebtn" value="글쓰기"></a></td>
	      </tr>
	    </table>
	  </form>
    </div>
  <jsp:include page="/include/Tail.jsp"/>
</body>
</html>