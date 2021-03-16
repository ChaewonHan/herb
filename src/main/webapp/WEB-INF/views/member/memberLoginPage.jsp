<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${empty sessionScope.userId}">
		<h2>로그인</h2>
		<form action="loginMember.do" id="loginFrm" method="POST">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userId" id="userId"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="userPw" id="userPw"></td>
				</tr>
				<tr>
					<td><a href="memberInsertForm.do">회원가입</a></td>
				</tr>
			</table>
			<input type="button" id="join_btn" value="로그인">
		</form>
	</c:when>
	<c:otherwise>
		<h3>${sessionScope.userId}님 환영합니다.</h3>
		<a href="logoutMember.do">로그아웃</a>
		<a href="myInfo.do?id=${sessionScope.userId}">마이페이지</a>
	</c:otherwise>
</c:choose>
<script>
	$(document).ready(function(e){
		$('#join_btn').click(function(){
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
		if ('${msg}' == '실패')
			alert("아이디 또는 패스워드가 틀렸습니다.");
		else if('${msg}' == '성공')
			alert("로그아웃 성공");
		else if('${msg}' == '탈퇴성공')
			alert("회원탈퇴를 완료하였습니다.");
		else if ('${msg}' == '수정실패')
			alert("회원정보 수정 실패");
		else if('${msg}' == '수정성공')
			alert("회원정보 수정을 완료하였습니다.");
	});
</script>
</body>
</html>