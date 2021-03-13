<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>탈퇴여부</th>
		<th>가입일</th>
</tr>
<c:forEach var="member" items="${memberList}">
	<tr>
		<td><a href="memberView.do?id=${member.userId }">${member.userId }</a></td>
		<td>${member.userName }</td>
		<td>${member.userEmail }</td>
		<td>${member.userDel }</td>
		<td>${member.userDate }</td>
	</tr>	
</c:forEach>
</table>
</body>
</html>