<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/projectView.css" />
<link rel="script" type="text/javascript" href="js/jsFunction.js"/>
<script src="js/jsFunction.js" type="text/javascript"></script>
<script>menuColor('free');</script>
<title>자유 게시판</title>
</head>
<body>
	<jsp:include page="/include/Header.jsp" />
	<div class="side">
		<div class="hentry">
			<div class="text">
				<h2 id="board_title">자유 게시판</h2>
				<div id="write_title">
					<h3>${WRITER }님의게시글</h3>
				</div>
				<table>
					<tr id="writer">
						<td class="col1">작성자</td>
						<td class="col2">${WRITER }</td>
					</tr>

					<tr id="subject">
						<td class="col1">제목</td>
						<td class="col2">${SUBJECT }</td>
					</tr>

					<tr id="content">
						<td class="col1">내용</td>
						<td class="col2">${CONTENT }</td>
					</tr>

					<tr id="date">
						<td class="col1">최종 수정일</td>
						<td class="col2">${MOD_DATE}</td>
					</tr>
				</table>
				<div id="buttons">
						<a href="boardPasswordCheck.htm?seq=${SEQ}&writer=${WRITER}&subject=${SUBJECT}&count=${COUNT}&content=${CONTENT}"><button
								id="modifybtn">수정</button></a>
						<a href="boardDeletePasswordCheck.htm?seq=${SEQ}"><button
								id="deletebtn">삭제</button></a>
					<button id="listbtn" onclick="location.href='freeBoardList.htm'">목록</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/include/Tail.jsp" />
</body>
</html>