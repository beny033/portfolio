<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/projectWriteForm.css"/>
<link rel="script" type="text/javascript" href="js/jsFunction.js"/>
<script src="js/jsFunction.js" type="text/javascript"></script>
<script>menuColor('project');</script>
<title>프로젝트 게시판</title>
</head>
<body>
  <jsp:include page="/include/Header.jsp"/>
	<div class="side">
	  <div class="hentry">
	    <div class="text">
	      <h2 id = "board_title">프로젝트 게시판</h2>
		<div id = "write_title"> <h3>글수정</h3></div>
	  	  <form action="projectModify.htm" method="post" name="modifyForm">
	  	    <table>
			  <tr id = "writer">
			    <td class = "col1">작성자</td>
			    <td class = "col2"><input type = "text" name = "writer" value=" ${name }" readonly></td>
			  </tr>
			  
			  <tr id = "subject">
			    <td class = "col1">제목</td>
			    <td class = "col2"><input type = "text" name = "subject" value="${SUBJECT}" maxlength="20" required></td>
			  </tr>
			  
			  <tr id = "members">
			    <td class = "col1">참여멤버</td>
			    <td class = "col2"><input type = "text" name = "members" maxlength="36" value="${MEMBERS}" ></td>
			  </tr>
			  
			  <tr id = "content"> 
			    <td class = "col1">내용</td>
			    <td class = "col2"><textarea name = "content" maxlength="50" required>${CONTENT}</textarea></td>
			  </tr> 
			  
			  <tr id = "status">
			    <td class = "col1">상태</td>
			    <td class = "col2">
			      <select id ="selectStatus" name="status">
			  	  <option value="wait">대기</option>
			  	  <option value="ing">진행중</option>
				    <option value="end">완료</option>		
			      </select>
			    </td>
			  </tr>
			  
			  <tr id = "date">
			    <td class = "col1">수정일</td>
			    <td class = "col2"><input type = "date" name = "date" required></td>
			  </tr>
		    </table>
		  <div id = "buttons">
			<input type="submit" value="완료" id="submit"/>
			<button id="listbtn" onclick="location.href='projectList.htm'">목록</button>
		  </div>
	     </form>
	    </div>
	  </div>
	</div>
  <jsp:include page="/include/Tail.jsp"/>
</body>
</html>