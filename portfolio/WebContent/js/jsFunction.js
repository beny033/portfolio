function notMember() {
	alert('회원 전용 게시판 입니다.');
	location.href='loginForm.htm';
}

function countPlus() {
	var count = document.getElementById('count').innerHTML;
	var cnt = Number(count);
		document.getElementById('count').innerHTML=cnt+1;
}

function modifySubmit() {
	document.modifyForm.submit();
}

function writeSubmit() {
		document.writeForm.submit();
}

function menuColor(menu) {
	window.onload = function() {
		var c = document.getElementById(menu);
		c.style.color='#24b9fd';
	}
}