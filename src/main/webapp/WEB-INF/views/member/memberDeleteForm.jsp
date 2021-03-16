<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>회원 탈퇴</h2>
	<form action="memberDelete.do" id="loginFrm" method="POST">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId" id="userId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPw" id="userPw"></td>
			</tr>
		</table>
		<input type="button" id="log_btn" value="확인">
	</form>
<script>
$(document).ready(function(e){
	$('#log_btn').click(function(){
		if($.trim($('#userId').val()) == ''){
			alert("아이디를 입력해 주세요.");
			$('#userId').focus();
			return;
		}else if($.trim($('#userPw').val()) == ''){
			alert("패스워드를 입력해 주세요.");
			$('#userPw').focus();
			return;
		}
		$('#loginFrm').submit();
	});
	if ('${msg}' == '탈퇴실패')
		alert("아이디 또는 패스워드가 틀렸습니다.");
});
</script>
</body>
</html>