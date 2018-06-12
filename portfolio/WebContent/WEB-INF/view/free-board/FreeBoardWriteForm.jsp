<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/projectWriteForm.css"/>
<link rel="script" type="text/javascript" href="js/jsFunction.js"/>
<script src="js/jsFunction.js" type="text/javascript"></script>
<script>menuColor('free');</script>
<title>자유 게시판</title>
</head>
<body>
  <jsp:include page="/include/Header.jsp"/>
	<div class="side">
	  <div class="hentry">
		<div class="text">
          <h2 id = "board_title">자유 게시판</h2>
	<div id="write_title"> <h3>글쓰기</h3></div>
  	<form action="freeBoardWrite.htm" method="post" name="writeForm">
  	  <table>
		<tr id="writer">
		  <td class="col1">작성자</td>
		  <td class= "col2"><input type="text" name="writer" maxlength="12" autofocus required></td>
		</tr>
		
		<tr id="password">
		  <td class="col1">비밀번호(4자리)</td>
		  <td class= "col2"><input type="password" name="password" maxlength="4" required></td>
		</tr>

		<tr id="subject">
		  <td class = "col1">제목</td>
		  <td class = "col2"><input type="text" name="subject" maxlength="20" required></td>
		</tr>
		
		<tr id="content"> 
		  <td class = "col1">내용</td>
		  <td class = "col2"><textarea name="content" maxlength="50" required></textarea></td>
		</tr> 
		
		<tr id="date">
		  <td class="col1">작성일</td>
		  <td class="col2"><input type="date" name="date" required></td>
		</tr>
	</table>
	<div id="buttons">
		<input type="submit" value="완료" id="submit">
		<button id="listbtn" onclick="location.href='freeBoardList.htm'">목록</button>
	</div>
   </form>
    </div>
  </div>
</div>
<jsp:include page="/include/Tail.jsp"/>



</body>
</html>