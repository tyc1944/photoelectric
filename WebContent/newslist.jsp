<%@page import="com.electric.entity.Page"%>
<%@page import="com.electric.entity.NewsType"%>
<%@page import="com.electric.service.NewsTypeService"%>
<%@page import="com.electric.entity.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中心--xxx公司</title>
<meta name="description" content="网站首页优化描述">
<meta name="keywords" content="xxx公司关键字">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>


<div class="body_frame">
	<jsp:include page="top.jsp" /><!-- 引入页面 -->


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
 NewsType newsType=null;
 Object newsTypeObj=request.getAttribute("newsType");
 if(newsTypeObj!=null){//从左侧点击类型过来的
	   newsType=(NewsType)newsTypeObj;
 	   
 }
 
 	List<NewsType> newsTypeList=(List<NewsType>)request.getAttribute("newsTypeList");
 for(NewsType newsTypeItem:newsTypeList){
	 if(newsType!=null&&newsType.getTypeId()==newsTypeItem.getTypeId()){
		%>
		 <li > <a href="FindPageListByTypeIdNewsServlet?typeId=<%=newsTypeItem.getTypeId()%>" style="background-color:#23539E;"> <%=newsTypeItem.getTypeName() %> </a></li>
   
		<% 
	 }else{
 %>
           <li> <a href="FindPageListByTypeIdNewsServlet?typeId=<%=newsTypeItem.getTypeId()%>"> <%=newsTypeItem.getTypeName() %> </a></li>
   
    <%}
	 } %>
  
   
  </ul>
</div>
	</div>
	<!--classp end-->
	
	

	
	<jsp:include page="lianxi.jsp" />
	
	
	</div>
<div class="frame_r">




	<!--关于我们  begin-->
	<div class="box4">
	<div class="box4_t"><span><a href=IndexServlet>首页</a>&nbsp;&raquo;&nbsp;新闻中心
	<%
		if(newsType!=null){
			out.print("&nbsp;&raquo;&nbsp;"+newsType.getTypeName());
		}
	%>
	</span></div>
	<div class="box4_m">
<!-- start news-->
<ul class="newslist">
  
<%
	List<News> newsList=(List<News>)request.getAttribute("newsList");
	for(News news:newsList){
%>
<li><span class="news-content"><a href="FindByIdNewsServlet?newsId=<%=news.getNewsId() %>" title="<%=news.getTitle()%>"><%=news.getTitle()%></a></span>
<span class="news-time">
		[
         <%=news.getPostTime()%>
	]
</span>
</li>

<%} %>

</ul>
<div class="newslist-page">
		<%
			Page myPage=(Page)request.getAttribute("myPage");
		%>
<form action="http://t.mobanku.com/04437/newslist.html?" method="get" name="pagenumber-form" class="pagenumber-form">
       
       <%
       String url="FindPageListNewsServlet?";
      
       if(newsTypeObj!=null){//从左侧点击类型过来的
    	  
       	   url="FindPageListByTypeIdNewsServlet?typeId="+newsType.getTypeId()+"&";
       }
       
       	for(int p=1;p<=myPage.getPageCount();p++){
       		if(p==myPage.getPageNo()){
       			out.print("<span>"+p+"</span>");
       		}else{
       	%>
       	 <a href="<%=url%>pageNo=<%=p%>"><%=p%></a>&nbsp;
       	<%
       		}
       	}
     
       %>
         &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
       <a href="<%=url%>pageNo=1">首页</a>&nbsp;
       <a href="<%=url%>pageNo=<%=myPage.getPageNo()-1%>">上一页</a>&nbsp;
       <a href="<%=url%>pageNo=<%=myPage.getPageNo()+1%>">下一页</a>&nbsp;
       <a href="<%=url%>pageNo=<%=myPage.getPageCount()%>">尾页</a>&nbsp;
       
       
        <span class="sum-page">
            共<%=myPage.getRowCount() %>条&nbsp;&nbsp;<%=myPage.getPageNo() %>/<%=myPage.getPageCount() %>页&nbsp;&nbsp;每页<%=myPage.getPageSize() %>条
        </span>
		
        

	<!-- <span class="key-page">
	到第<input type="text" name="page" class="input-page" value="1" />页
    <input type="submit" value="确定" class="page-button"/>
	 </span>-->
    </form>
	 
	 
	</div>
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