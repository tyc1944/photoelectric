<%@page import="com.electric.entity.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--联系我们 begin-->
	<div class="box0">
	<div class="box0_t"><h3>联系我们</h3></div>
	<div class="box0_m">
	
	<%
			Contact contact=(Contact)session.getAttribute("contact");
		%>
	地址：<%=contact.getGsdz() %><br />
邮编：<%=contact.getYoubian() %><br />
总机：<%=contact.getShouji() %><br />
电话：<%=contact.getShouji() %><br />
传真：<%=contact.getChuanzhen() %><br />
Email：<%=contact.getKfyx() %></div></div>
	
	<!--联系我们 end-->
</body>
</html>