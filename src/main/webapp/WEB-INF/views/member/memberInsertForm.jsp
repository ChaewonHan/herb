<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="memberInsert.do" method="post" id="loginFrm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId"></td>
			<td><input type="button" id="idCheck" value="중복체크"></td>
		</tr>
		<tr>
			<td><div id="idCheckMessage" style="font-weight:bold"></div></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="userPhone"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" name="userEmail"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="userAddress"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="userBirth"></td>
		</tr>	
	</table>
	<input type="submit" id="join_btn" value="회원가입" disabled="disabled">
</form>
<script>

$('#idCheck').on("click", function(){
	var userId = $("input[name='userId']").val();
	if(userId == ''){
		$('#idCheckMessage').html('아이디를 입력해 주세요');
		$('#idCheckMessage').css( "color", "red" );
		return false;
	}
	$.ajax({
		async : true,
		type: 'POST',
		url: 'memberJoinIdCheck.do',
		data: {userId:userId},
		success: function(data){
			console.log(data);
			if(data > 0){ 
				$('#idCheckMessage').html('사용할 수 없는 아이디입니다.');
				$('#idCheckMessage').css( "color", "red" );
				 $("#join_btn").attr("disabled", "disabled");
			} else {
				$('#idCheckMessage').html('사용할 수 있는 아이디입니다.');
				$('#idCheckMessage').css( "color", "green" );
				$("#join_btn").removeAttr("disabled");
			}
		}
	})
});

</script>	
</body>
</html>