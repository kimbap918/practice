<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="mini02.MemberDAO"%>
<%@ page import="mini02.MemberVO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<h1>
		관리자 페이지입니다. <a href="/mini02/login.jsp"> <input type="button"
			value="로그아웃">
		</a>
	</h1>
	<hr>
	<table border="1">
		<tr>
			<th><a href="/mini02/MemberList.jsp">아이디</a></th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>등급</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<%
			MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers();

		for (int i = 0; i < list.size(); i++) {
			MemberVO mvo = (MemberVO) list.get(i);
			String id = mvo.getID();
			String pwd = mvo.getPWD();
			String name = mvo.getName();
			String email = mvo.getEmail();
			Date joinDate = mvo.getJoinDate();
			String custRank = mvo.getCustRank();

			session.setAttribute("id", mvo.getID());
			session.setAttribute("name", mvo.getName());
		%>
		<form action="MemInfo.jsp" method="post">
			<tr>
				<td><input type="text" name="id" value="<%=id%>"
					readonly="readonly"></td>
				<td><input type="text" name="pwd" value="<%=pwd%>"
					readonly="readonly"></td>
				<td><input type="text" name="name" value="<%=name%>"
					readonly="readonly"></td>
				<td><input type="text" name="email" value="<%=email%>"
					readonly="readonly"></td>
				<td><%=joinDate%></td>
				<td><input type="text" name="custRank" value="<%=custRank%>"
					readonly="readonly"></td>
				<td>
					<button type="submit">수정</button> <input type="hidden"
					name="command" value="change">
				</td>
				<td><a href="/mini02/member3?command=del&id=<%=id%>"> 삭제 </a></td>
			</tr>
		</form>
		<%
			}
		%>
	</table>
</body>
</html>