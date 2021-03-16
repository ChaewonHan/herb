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
	<c:set var="member" value="${member }"/>
	<form action="memberUpdate.do" method="post" id="loginFrm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId" value="${sessionScope.userId }" readonly="readonly"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPw" value="${member.userPw }"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" value="${member.userName }"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="userPhone" value="${member.userPhone }"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" name="userEmail" value="${member.userEmail }"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="userAddress" value="${member.userAddress }"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="userBirth" value="${member.userBirth }"></td>
		</tr>	
	</table>
	<input type="submit" id="join_btn" value="수정 완료">
</form>
	<input type="button" value="회원 탈퇴" onclick="location.href='memberDeleteForm.do'">
</body>
</html>