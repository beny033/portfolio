<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./view-css/header.css"/>
<link rel="script" type="text/javascript" href="js/jsFunction.js"/>
<script src="js/jsFunction.js" type="text/javascript" ></script>
</head>
	<body>
		<div id="header">
		  <span class="top"><a href="./index.jsp">포트폴리오</a></span>
			<div id="menu">
			  <c:choose>
				<c:when test="${id eq null}">
				  <a href="loginForm.htm">로그인</a>
				  <a href="joinForm.htm">회원가입</a>
				</c:when>
			    <c:when test="${id eq 'admin'}">
			      <span style=color:white;>관리자 모드 /</span>
				  <a href="memberList.htm">회원목록</a>
				  <a href="logOut.htm">[로그아웃]</a>
				</c:when>
				<c:otherwise>
				  <a href="myInfo.htm">${name}님의정보</a>
				  <a href="logOut.htm">[로그아웃]</a>
				</c:otherwise>
			  </c:choose>
			</div>
			<div id="board">
			  <c:choose>
			    <c:when test="${id eq null}">
			      <a href="#" onclick="notMember();">프로젝트</a>
			      <a href="#" id="suggest" onclick="notMember();">건의사항</a>
			    </c:when>
			    <c:otherwise>
			      <a href="projectList.htm" id="project">프로젝트</a>
			      <a href="suggestList.htm" id="suggest">건의사항</a>
			    </c:otherwise>
			  </c:choose>
			  <a href="freeBoardList.htm" id="free">자유 게시판</a>
			</div>
		</div>
	</body>
</html>