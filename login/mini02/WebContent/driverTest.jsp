<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

<h2>JDBC드라이버 테스트 </h2>

<%

  try{
	 String driverClassName="com.mysql.cj.jdbc.Driver";
	 String url = "jdbc:mysql://database-1.cu5eqyqkc3ar.us-east-2.rds.amazonaws.com:3306/database-1?autoReconnect=true&amp;serverTimezone=UTC";
     String username = "choicho";
     String password = "jun901800!";
	
	 Class.forName(driverClassName);
	 Connection con = DriverManager.getConnection(url, username, password);
	 out.println("제대로 연결되었습니다.");
  }catch(Exception e){ 
	 out.println("연결되지 않았습니다.");  }
%>