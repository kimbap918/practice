<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<style type="text/css">
	table {
		width : 30%;
		border-collapse: collapse;
	}
	td {border: 1px solid;}
	
</style>
 <script type="text/javascript">
    	function fn_change() {
    		var frinfo = document.frinfo;
			var id = frinfo.id.value;
			var pwd = frinfo.pwd.value;
			var name = frinfo.name.value;
			var email = frinfo.email.value;
			
			if(name.length == 0 || name == ""){
				alert("name 필수");
			}else if(pwd.length == 0 || pwd == ""){
				alert("pw 필수");
			}else if(email.length == 0 || email == ""){
				alert("email 필수");
			}else{
				frinfo.action = "member3";
				frinfo.method = "post";
				frinfo.submit();
			}
		}
    	
    	function fn_list(){
    		frinfo.method = "post";
			frinfo.action = "MemberList.jsp";
			
			frinfo.submit();
    	} 
    	
    	function fn_del() {
    		var frinfo = document.frinfo;
			var id = frinfo.id.value;
			
			frinfo.method = "post";
			frinfo.action = "member3";
			frinfo.submit();
    	}
    </script>
</head>
<body>
    <%
    String id = (String)session.getAttribute("id");
    String userid = request.getParameter("id");
    
    String name = null;
    String pwd = null;
    String email = null;
    String custRank = null;
    
    String username = null;
    String userpwd = null;
    String useremail = null;
    String usercustRank = null;
    
    if(id != null){
	    name = (String)session.getAttribute("name");
	    pwd = (String)session.getAttribute("pwd");
	    email = (String)session.getAttribute("email");
	    custRank = (String)session.getAttribute("custRank");
	    //out.println("name : " + name);
	    
	    if(id.equals("admin")){
	    	userid = request.getParameter("id");
	        username = request.getParameter("name");
	        userpwd = request.getParameter("pwd");
	        useremail = request.getParameter("email");
	        usercustRank = request.getParameter("custRank");
	          
	    }%> 
	    <div id = "login">
	    <%=name%>님, 반갑습니다. <a href="/mini02/login.jsp"> 
	    <input type="button" value="로그아웃" ></a>
	    </div>
   <%}else{ 
		response.sendRedirect("/mini02/login.jsp");
   } %>
   <hr>
    <form name="frinfo">
	   <table>
	   		<tr><td>column</td><td>info</td></tr>
	   		<%if(id.equals("admin")){ %>
		   		<tr><td>ID : </td><td><input type="text" name="id" value="<%=userid%>" readonly="readonly"></td></tr>
		   		<tr><td>PW : </td><td><input type="password" name ="pwd" value="<%=userpwd%>"></td></tr>
		   		<tr><td>이름 : </td><td><input type="text" name ="name" value="<%=username%>"></td></tr>
		   		<tr><td>email : </td><td><input type="email" name ="email" value="<%=useremail%>"></td></tr>
	   		<%}else{ %>
		   		<tr><td>ID : </td><td><input type="text" name="id" value="<%=id%>" readonly="readonly"></td></tr>
		   		<tr><td>PW : </td><td><input type="password" name ="pwd" value="<%=pwd%>"></td></tr>
		   		<tr><td>이름 : </td><td><input type="text" name ="name" value="<%=name%>"></td></tr>
		   		<tr><td>email : </td><td><input type="email" name ="email" value="<%=email%>"></td></tr>
	   		<%} %>   	
	   </table>
   
   <input type="button" value="수정" onclick="fn_change()">
   <input type="hidden" name="command" value="change">
   
   <input type="button" value="탈퇴" onclick="fn_del()">
    <!-- <button type="button" name="command" value="change" onclick="fn_change()">수정</button>
    <button type="button" name="command" value="del" onclick="fn_del()">탈퇴</button> -->
	<%if(id.equals("admin")){ %>
		<button type="button" name="command" value="list" onclick="fn_list()">목록보기</button>
	<%} %>
   </form>
</body>
</html>