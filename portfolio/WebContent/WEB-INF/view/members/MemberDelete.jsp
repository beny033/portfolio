<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var answer = confirm('삭제하시겠습니까?');

	if(answer) {
		location.href='memberDelete.htm?seq=${seq}';
	} else {
		location.href='memberList.htm';
	}
</script>
