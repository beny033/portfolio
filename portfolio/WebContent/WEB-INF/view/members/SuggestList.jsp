<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	Calendar cal = Calendar.getInstance(); 
	int year = cal.get(cal.YEAR);	int month = cal.get(cal.MONTH) + 1;	int day = cal.get(cal.DATE);
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./view-css/suggestList.css"/>
<link rel="script" type="text/javascript" href="js/jsFunction.js"/>
<script src="js/jsFunction.js" type="text/javascript"></script>
<script>menuColor('suggest');</script>
<title>건의 사항</title>
</head>
<body>
	<jsp:include page="/include/Header.jsp"/>
	<div id="suggest" >
      <div class="board_title"><h2>건의사항</h2></div>
        <div class="date"><%= year + "-" + month + "-" + day %></div>
        <form action="suggestWrite.htm?id=${id}" method="post">
      	  <textarea rows="3" cols="100" name="content" placeholder="1 ~ 50자까지만 입력할 수 있습니다." maxlength="50" required></textarea>
		  <input type="submit" value="작성하기" class="submit">      
        </form>
      <table id="suggestTable">
        <c:forEach var="list" items="${list}">
          <tr>
            <th>${list.ID}</th> 
            <td>${list.CONTENT}</td>
            <td>${list.CRE_TIME}</td>
          </tr>
        </c:forEach>
      </table>
      
    </div>
	<jsp:include page="/include/Tail.jsp"/>
</body>
</html>