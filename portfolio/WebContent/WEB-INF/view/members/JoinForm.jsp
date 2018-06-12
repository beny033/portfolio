<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/joinForm.css"/>
<title>회원가입 페이지</title>
</head>
<body>
	<jsp:include page="/include/Header.jsp"/>
		<div id="form">
			<div id="message">이메일을 제외한 모든 입력사항은 필수입력 사항 입니다.</div>
			<form action="../../subproject/checkid" method="post" class="login">
				<h1>Welcome Join</h1>
				아이디<br> 
				<input type="text" name="id" class="login-input" autofocus required maxlength="12">
				이름<br>
				<input type="text" name="name" class="login-input" required maxlength="12">
			 	비밀번호<br> 
			 	<input type="password" name="pwd" class="login-input" required maxlength="16">
				비밀번호 확인<br>
				<input type="password" name="cpwd" class="login-input" required maxlength="16">
				성별 &nbsp;&nbsp;
				<input type="radio" name="gender"  value="Male" required> 남
				<input type="radio" name="gender"  value="Female" required> 여 <br><br>
				주소(구 까지만 입력)<br>
				<input type="text" name="address" class="login-input" required maxlength="20">
				이메일<br> 
				 <input type="email" name="email" class="login-input" maxlength="30">
				 <input type="submit" value="회원가입" class="login-submit">
				
				<p class="login-help">
					<a href="">비밀번호 찾기</a>
				</p>
				<p class="join-help">
					<a href="loginForm.htm">로그인</a>
				</p>
			</form>
		</div>
	<jsp:include page="/include/Tail.jsp"/>
</body>
</html>