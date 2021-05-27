<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
	function fn_sendMes() {
		var frlogin = document.frlogin;
		var id = frlogin.id.value;
		var pw = frlogin.pw.value;

		if (id.length == 0 || id == "") {
			alert("id 필수");
		} else if (pwd.length == 0 || pwd == "") {
			alert("pw 필수");
		} else {
			frlogin.method = "post";
			frlogin.action = "login";
			frlogin.submit();
		}
	}
</script>
</head>
<body>
	<form name="frlogin">
		아이디 : <input type="text" name="id"><br> 비밀번호 : <input
			type="password" name="pwd"><br> <input type="button"
			value="로그인" onclick="fn_sendMes()"> <input type="hidden"
			name="command" value="login"> <input type="reset"
			value="다시 작성"> <a href="/mini02/memberForm.html"> <input
			type="button" value="회원가입"></a>

	</form>
</body>
</html>