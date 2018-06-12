<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/boardPasswordCheck.css"/>
<link rel="script" type="text/javascript" href="js/jsFunction.js"/>
<script src="js/jsFunction.js" type="text/javascript"></script>
<script>menuColor('free');</script>
<title>자유 게시판</title>
</head>
<body>
  <jsp:include page="/include/Header.jsp"/>
	<form action="../../subproject/pwCheck?seq=${SEQ}&writer=${WRITER}&subject=${SUBJECT}&content=${CONTENT}" method = "post">
		비밀번호 : <input type="password" name="password" maxlength="4" required>
		<input type = "submit" value="확인" id="submit">
	</form>
  <jsp:include page="/include/Tail.jsp"/>
</body>
</html>