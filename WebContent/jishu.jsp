<%@page import="com.electric.entity.Jishu"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>技术创新-xxx公司</title>
<meta name="description" content="网站首页优化描述">
<meta name="keywords" content="xxx公司关键字">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>


<div class="body_frame">

<jsp:include page="top.jsp" />



	<!--adpic begin-->
    <div class="adpic"><img border="0" alt="" src="images/neiye.jpg" /></div>
	<!--adpic end-->	




<!--框架框架框架框架框架框架框架框架框架-->
<div id="main_frame">
<div class="frame_l">


	
	
	
	<!--classp begin-->
	<div class="box1">
	<div class="box1_t"><h3>技术创新</h3></div>
	<div class="box1_m">
<ul class="sidebar">
    
	<%
    		List<Jishu> list=(List<Jishu>)request.getAttribute("List");
    		for(Jishu jishu:list){
    	%>

     <li><a href="jishuServlet_findAll?jishuId=<%=jishu.getProId()%>"><%=jishu.getTitle()%></a></li>
    
    <%
        	}
        %>
	
</ul></div>
	</div>
	<!--classp end-->
	
	

	
	<jsp:include page="lianxi.jsp" />
	
	
	</div>
<div class="frame_r">




	<!--关于我们  begin-->
	<div class="box4">
	<div class="box4_t"><span><a href=IndexServlet>首页</a>&nbsp;&raquo;&nbsp;技术创新</span></div>
	<%
		Jishu jishu=(Jishu)request.getAttribute("jishu");
	%>
	<div class="box4_m">
	
<%=jishu.getContent() %>
</div>
	</div>	
	<!--关于我们  end-->





</div>
<div class="clear"></div>
</div>	
<!--框架框架框架框架框架框架框架框架框架-->	




<jsp:include page="foot.jsp" />



</div>
</body>
</html>