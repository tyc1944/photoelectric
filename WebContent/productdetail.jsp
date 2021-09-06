<%@page import="com.electric.entity.Product"%>
<%@page import="com.electric.entity.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="com.electric.entity.ProEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Round-xxx公司</title>
<meta name="description" content="">
<meta name="keywords" content="">
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
	<div class="box1_t"><h3>产品中心</h3></div>
	<div class="box1_m">
<ul class="sidebar">

<%
	List<ProductType> productTypeList=(List<ProductType>)request.getAttribute("productTypeList");
	for(ProductType productType:productTypeList){
%>

<li ><a href="Producttypepage?typeId=<%=productType.getTypeId() %>" ><b><%=productType.getTypeName() %></b></a></li>

<%} %>



</ul>
</div>
	</div>
	<!--classp end-->
	
	

	
	<jsp:include page="lianxi.jsp" />
	
	
	</div>
<div class="frame_r">


<%
ProEntity newsEntity=(ProEntity)request.getAttribute("proEntity");
			Product product=(Product)request.getAttribute("product");
		%>

	<!--关于我们  begin-->
	<div class="box4">
	<div class="box4_t"><span><a href=IndexServlet>首页</a>&nbsp;&raquo;&nbsp;<a href=Productpage>产品中心</a>&nbsp;&raquo;&nbsp;<a href=Productpage>产品应用</a>&nbsp;&raquo;&nbsp;<a href=ProductServlet_findById?proId=<%=product.getProId()%>><%=product.getTitle() %></a></span></div>
	<div class="box4_m"><div class="pro_detail_show">


	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
		<td width="5%" height="310" class="pro_detail_img"><img src="images/picImages/<%=product.getPic() %>"  width="300" height="300" border="0" /></td>
		<td width="95%" align="left" valign="top"  style="padding-left:10px;">
			
				<h3>名称：<%=product.getTitle()%></h3>
				
			
		</td>
	  </tr>
	</table>
  <div class="pro_detail_introduce">
   <%=product.getContent() %>
   </div>


<div style="margin-top:50px;"><!--next items -->
<div class="pro_next">

		
        <p style="margin-top: 3px; margin-bottom: 3px">上一个：<% if(newsEntity.getPreNews()==null){
			 out.print("无");
		 }else{
		 %> 
		  <a href="ProductServlet_findById?proId=<%=newsEntity.getPreNews().getProId() %>"><%=newsEntity.getPreNews().getTitle() %></a>
		  
		  <%} %></p>
        
        <p style="margin-top: 3px; margin-bottom: 3px">下一个：<%
		 if(newsEntity.getNextNews()==null){
			 out.print("无");
		 }else{
		 %>  
              
         		  <a href="ProductServlet_findById?proId=<%=newsEntity.getNextNews().getProId() %>"><%=newsEntity.getNextNews().getTitle() %></a>

			<%} %></p>
        
    
</div>
<!--next items end-->
</div>
</div></div>
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