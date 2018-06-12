<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/loginForm.css" />
<title>로그인 페이지</title>
</head>
<body>
	<jsp:include page="/include/Header.jsp" />
	<div class="form">
		<form action="loginCheck" class="login" method="post">
			<h1>Login</h1>
			<input type="text" name="id" class="login-input" placeholder="ID"
				required> <input type="password" name="pwd"
				class="login-input" placeholder="Password" required> <input
				type="submit" value="Login" class="login-submit">
			<p class="login-help">
				<a href="index.jsp">비밀번호 찾기</a>
			</p>
			<p class="join-help">
				<a href="joinForm.htm">회원가입</a>
			</p>
		</form>
	</div>
	<jsp:include page="/include/Tail.jsp" />
</body>
</html>