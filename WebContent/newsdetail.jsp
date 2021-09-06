<%@page import="com.electric.entity.NewsType"%>
<%@page import="java.util.List"%>
<%@page import="com.electric.entity.News"%>
<%@page import="com.electric.entity.NewsEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>
	被认定为广东省民营企业创新产业化示范基地公司新闻-xxx公司
</title>
<meta name="description" content="网站首页优化描述">
<meta name="keywords" content="xxx公司关键字">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>


<div class="body_frame">
		<jsp:include page="top.jsp" ></jsp:include>


	<!--adpic begin-->
    <div class="adpic"><img border="0" alt="" src="images/neiye.jpg" /></div>
	<!--adpic end-->	




<!--框架框架框架框架框架框架框架框架框架-->
<div id="main_frame">
<div class="frame_l">


	
	
	
	<!--classp begin-->
	<div class="box1">
	<div class="box1_t"><h3>新闻中心</h3></div>
	<div class="box1_m"><ul class="sidebar">      
   <%
 	List<NewsType> newsTypeList=(List<NewsType>)request.getAttribute("newsTypeList");
 for(NewsType newsType:newsTypeList){
 %>
           <li> <a href="FindListByTypeIdNewsServlet?typeId=<%=newsType.getTypeId()%>"> <%=newsType.getTypeName() %> </a></li>
           <%} %>
  
   
   
  </ul>
</div>
	</div>
	<!--classp end-->
	
	

	
	<jsp:include page="lianxi.jsp" />
	
	
	</div>
<div class="frame_r">




	<!--关于我们  begin-->
	<div class="box4">
	<div class="box4_t"><span><a href=IndexServlet>首页</a>&nbsp;&raquo;&nbsp;<a href=FindPageListNewsServlet>新闻中心</a>&nbsp;&raquo;&nbsp;公司新闻</span></div>
	<div class="box4_m"><!-- start news-->
<div class="show-news">
<%

NewsEntity newsEntity=(NewsEntity)request.getAttribute("newsEntity");

	News news=(News)request.getAttribute("news");
%>
        <h3 class="news-title"><%=news.getTitle() %></h3>
        <div class="time"><%=news.getPostTime() %> 点击：<%=news.getClicks() %> 来自:<%=news.getAuthor() %></div>
        <div class="news-content">
        	<%=news.getDescription() %>
        </div>
         <p class="previous">
		  上一篇：<% if(newsEntity.getPreNews()==null){
			 out.print("无");
		 }else{
		 %> 
		  <a href="FindByIdNewsServlet?newsId=<%=newsEntity.getPreNews().getNewsId() %>"><%=newsEntity.getPreNews().getTitle() %></a>
		  
		  <%} %>
          </p>	
          <p class="next">
			
              下一篇：<%
		 if(newsEntity.getNextNews()==null){
			 out.print("无");
		 }else{
		 %>  
              
         		  <a href="FindByIdNewsServlet?newsId=<%=newsEntity.getNextNews().getNewsId() %>"><%=newsEntity.getNextNews().getTitle() %></a>

			<%} %>
			
            </p>	
</div>
	<!-- end news--></div>
	</div>	
	<!--关于我们  end-->





</div>
<div class="clear"></div>
</div>	
<!--框架框架框架框架框架框架框架框架框架-->	





<!-- 引入底部页面 -->
<jsp:include page="foot.jsp" />



</div>
</body>
</html>