<%@page import="com.electric.entity.Product"%>
<%@page import="com.electric.entity.ProductType"%>
<%@page import="com.electric.entity.Page"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品列表页优化默认关键字-xxx公司</title>
<meta name="description" content="提供产品列表页详细优化描述默认描述图片及介绍">
<meta name="keywords" content="产品列表页优化默认关键字">
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
 ProductType productType=null;
 Object newsTypeObj=request.getAttribute("productType");
 if(newsTypeObj!=null){//从左侧点击类型过来的
	 productType=(ProductType)newsTypeObj;
 	   
 }

 List<ProductType> newsTypeList=(List<ProductType>)request.getAttribute("productTypeList");
 for(ProductType newsTypeItem:newsTypeList){
	 if(productType!=null&&productType.getTypeId()==newsTypeItem.getTypeId()){
		%>
		 <li class="small"> <a href="Producttypepage?typeId=<%=newsTypeItem.getTypeId()%>" style="background-color:#23539E;"> <b><%=newsTypeItem.getTypeName() %></b> </a></li>
   
		<% 
	 }else{
 %>
           <li class="small"><a href="Producttypepage?typeId=<%=newsTypeItem.getTypeId()%>"> <b><%=newsTypeItem.getTypeName() %></b> </a></li>
   
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
	<div class="box4_t"><span><a href=IndextServlet>首页</a>&nbsp;&raquo;&nbsp;<a href=Productpage>产品中心</a>
	<%
		if(productType!=null){
			out.print("&nbsp;&raquo;&nbsp;"+productType.getTypeName()+"=============");
		}
	%>
	</span></div>
	
	<div class="box4_m">
<table width="100%"  border="0" cellspacing="0" cellpadding="0" class="pro_list" align="center">
  <%
		List<Product> productList=(List<Product>)request.getAttribute("productList");
		for(int i=0;i<productList.size();i++){
			Product product=productList.get(i);
			if(i%3==0){
				out.print("<tr>");
			}
	%>
			<td align="center"  class="line">
			<div class="pro_show" style="width:150px;padding:2px;">
				
					<div class="pro_img" bgcolor="#FFFFFF"  >
					<a href="ProductServlet_findById?proId=<%=product.getProId()%>"><img src="images/picImages/<%=product.getPic() %>" width="150" height="150" border="0" />	</a>
					</div>
						<div class="pro_name"><a href="ProductServlet_findById?proId=<%=product.getProId()%>"><%=product.getTitle() %></a></div>
				<p style="line-height:15px;margin-top:6px;"><%=product.getContent() %></p>
			  </div>
			</td>
		
		<%
		if(i%3==2){
			out.print("</tr>");
		}
		
		} %>
</table>
	<div class="productlist-page">
		<%
			Page myPage=(Page)request.getAttribute("myPage");
		%>
<form action="http://t.mobanku.com/04437/products.html?" method="get" name="pagenumber-form" class="pagenumber-form">
<%
       String url="Productpage?";
      
       if(newsTypeObj!=null){//从左侧点击类型过来的
    	  
       	   url="Producttypepage?typeId="+productType.getTypeId()+"&";
       }
       
       	for(int p=1;p<=myPage.getPageCount();p++){
       		if(p==myPage.getPageNo()){
       			out.print("<span style='color:black;font-size:15px;margin-top:5px;'>"+p+"</span>");
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
        共<%=myPage.getRowCount()%>条&nbsp;&nbsp;<%=myPage.getPageNo()%>/<%=myPage.getPageCount()%>页&nbsp;&nbsp;每页<%=myPage.getPageSize() %>条 </span>
   <span class="pagenumber">
        
        <!--页码上半部分的数据 start-->
        
        <!--页码上半部分的数据 end-->
         
         <!--当前页码-->
         <!--  <b class="on-page">1</b>-->
         
        <!--页码下半部分的数据 start-->
         
		
         	<!--  <a href="http://t.mobanku.com/04437/products.html?page=2" title="第2页">2</a>-->
          
        <!--页码下半部分的数据 end-->
         </span>
		 
	<!--  <span class="next-page">
		<a href="http://t.mobanku.com/04437/products.html?page=2" title="下一页">下一页</a>
		<a href="http://t.mobanku.com/04437/products.html?page=2" title="尾页">尾页</a>
    </span>-->
		
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