<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 게시판</title>
<link rel="stylesheet" type="text/css" href="./view-css/projectWriteForm.css"/>
<link rel="script" type="text/javascript" href="js/jsFunction.js"/>
<script src="js/jsFunction.js" type="text/javascript"></script>
<script>menuColor('project');</script>
</head>
<body>
  <jsp:include page="/include/Header.jsp"/>
	<div class="side">
	  <div class="hentry">
		<div class="text">
          <h2 id = "board_title">프로젝트 게시판</h2>
	<div id="write_title"> <h3>글쓰기</h3></div>
  	<form action="projectWrite.htm" method="post" name="writeForm">
  	  <table>
		<tr id="writer">
		  <td class="col1">작성자</td>
		  <td class= "col2"><input type="text" id="writer" name="writer" value="${name }" readonly></td>
		</tr>
		
		<tr id="subject">
		  <td class = "col1">제목</td>
		  <td class = "col2"><input type="text" id="subject" name="subject" maxlength="20" autofocus required></td>
		</tr>
		
		<tr id="members">
		  <td class = "col1">참여멤버</td>
		  <td class = "col2"><input type="text" id="members" name="members" maxlength="36"></td>
		</tr>
		
		<tr id="content"> 
		  <td class = "col1">내용</td>
		  <td class = "col2"><textarea id="content" name="content" maxlength="50" required></textarea></td>
		</tr> 
		
		<tr id="status">
		  <td class="col1">상태</td>
		  <td class="col2">
		    <select id="selectStatus" id="status" name="status">
			  <option value="wait">대기</option>
			  <option value="ing">진행중</option>
			  <option value="end">완료</option>		
		    </select>
		  </td>
		</tr>
		
		<tr id="date">
		  <td class="col1">작성일</td>
		  <td class="col2"><input type="date" name="date" required></td>
		</tr>
	</table>
	<div id="buttons">
		<input type="submit" value="완료" id="submit">
		<button id="listbtn" onclick="location.href='projectList.htm'">목록</button>
	</div>
   </form>
    </div>
  </div>
</div>
<jsp:include page="/include/Tail.jsp"/>
</body>
</html>