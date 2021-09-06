<%@page import="com.electric.entity.Contact"%>
<%@page import="com.electric.entity.News"%>
<%@page import="com.electric.entity.NewsType"%>
<%@page import="com.electric.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>xxx公司-xxx公司</title>
<meta name="description" content="网站首页优化描述">
<meta name="keywords" content="xxx公司关键字">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/swiper-bundle.min.css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
        .swiper-container {
        
            width: 900px;
            height: 300px;
        }
        .swiper-contain {
            width: 400px;
            height: 400px;
        }
    </style>
</head>


<body>



<div class="body_frame">
<jsp:include page="top.jsp" />

	<!--adpic begin-->
    <div class="adpic"><table width="990" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td><div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide"> <img src="images/01.jpg"> </div>
        <div class="swiper-slide"><img src="images/02.jpg"> </div>
        <div class="swiper-slide"><img src="images/neiye.jpg"> </div>


    </div>
    <!-- 如果需要分页器 -->
    <div class="swiper-pagination"></div>

    <!-- 如果需要导航按钮 -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>

    <!-- 如果需要滚动条 -->
<!--    <div class="swiper-scrollbar"></div>-->
</div>
<script src="js/swiper-bundle.min.js"></script>
<script>
    var mySwiper = new Swiper ('.swiper-container', {
        direction: 'horizontal', // 垂直切换选项
        loop: true, // 循环模式选项
        effect: 'cube',

        // 如果需要分页器
        pagination: {
            el: '.swiper-pagination',
        },

        // 如果需要前进后退按钮
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },

        // // 如果需要滚动条
        // scrollbar: {
        //     el: '.swiper-scrollbar',
        // },
    })
</script>


</td>
  </tr>
</table>



    <div class="clear"></div>
	
</div>
	<!--adpic end-->	


<!--框架框架框架框架框架框架框架框架框架-->
<div id="two_frame">
<div class="frame_l">
	
		<!--关于我们  begin-->
	<div class="box2">
	<div class="box2_t"><div class="more"><a href="about.jsp"><img src="images/more.gif" /></a></div><h3 style="color:black;">关于我们</h3></div>
	<div class="box2_m">
	<div class="box2_con_l"><div>
<table width="160" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td style="padding-top:10px;"><img width="180px" src="images/logo1.gif"></img>
</td>
  </tr>
</table>

</div></div>

	<div class="box2_con_r">&nbsp;&nbsp;&nbsp;<span style="font-size: x-small"><span style="font-size: small"><span style="font-family: 宋体">
	 <%
	 	String aboutContent=(String)request.getAttribute("aboutContent").toString();
	 		out.print(aboutContent);
	 %></span></span></span></div>
	</div>
	</div>	
	<!--关于我们  end-->






	<!--推荐  begin-->
	<div class="box2"  style="margin-top:10px;">
	<div class="box2_t"><div class="more_bid">
<a href="Productpage" >产品展厅</a>|
<a href="Productpage" >产品应用</a>|</div><h3>推荐产品</h3></div>
	<div class="box2_m">


<table width="100%"  border="0" cellspacing="0" cellpadding="0" id="tuijian_pro_1" align="center" >
   <tr >
	
			<%
					List<Product> productList=(List<Product>)request.getAttribute("productList");
						for(Product product:productList){
				%>
			<td align="center" class="line" >
				 <div  style="width:150px;border:1px solid #999;padding:5px;">
							<p><a href="ProductServlet_findById?proId=<%=product.getProId()%>"><img src="images/picImages/<%=product.getPic() %>" 
							 width="150" height="90" border="0" /></a>				
                  </p>
						 <div  class="tuijian_pro_name" >
							<a href="ProductServlet_findById?proId=<%=product.getProId()%>">
							<%=product.getTitle()%>					</a></div>
							</div>

   </td>
		<%
			}
		%>
		</tr><tr >
		<!-- product list page number -->
	</tr>
</table>



</div>
	</div>
	<!--推荐  end-->	



	
	
	</div>
<div class="frame_r">



	<!--首页新闻  begin-->

<style>
#main_tab2{ width:100%; padding:0px; margin:0px auto; height:100%; clear:both;background:url('css/images/box2_m.gif') right 27px   no-repeat;} 
#main_tab2 .titlebox2{position:relative; height:33px;line-height:33px;color:#666666;padding-left:15px;}

.titlebox2 ul{ position:absolute; top:0; left:0; z-index:1; height:100%; overflow:hidden; width:100%;color:#2f6cbd;}
.titlebox2 ul li{ float:left; width:164px; display:block; cursor:pointer;  text-align:left; line-height:24px;color:#2f6cbd;}
.titlebox2 ul li a{text-decoration:none; color:#2f6cbd; font-weight:bold; display:block; width:100%;}
.titlebox2 ul li a:visited{color:#3B8E44;}
.titlebox2 ul li.hover{ border-bottom:none;}
.titlebox2 ul li.hover a{color:red;}
.titlebox2 ul li.hover a:visited{ color:#f00;}
.contentbox2{ clear:both; margin-top:-1px; border-top:0px solid #b3ccb7; width:100%; overflow:hidden; height:100%;}
.contentbox2 .content2{padding:0px; width:100%;height:160px;overflow:hidden;margin-bottom:5px;}
.contentbox2 .content2 ul{ display:none; overflow:hidden; width:100%; height:100%; padding-top:10px; padding-left:10px; } 
.contentbox2 .content2 ul li img{ vertical-align:text-top;}
.contentbox2 .content2 ul.block{display:block;}
.contentbox2 .content2 ul li{float:left;width:96%;background:url(css/images/ico1.gif) left center no-repeat;line-height:21px;}
.contentbox2 .content2 ul li a{color:#666666;font-size:12px;padding-left:10px;}
.contentbox2 .content2 ul li a:hover{color:red;}
.contentbox2 .content2 .data{float:right;color:#666;padding-right:5px;}
.county2{position:relative; margin:0px 0px; overflow:hidden; height:100%; }

.county2 #main_tab2 .titlebox2 .more{float:right;line-height:33x;}
.county2 #main_tab2 .titlebox2 ul li{color:#2f6cbd;width:85px;text-align:center;float:left;height:27px;line-height:27px;background:url('css/images/tab_t.gif')   repeat-x;font-weight:bold;}
.county2 #main_tab2 .titlebox2 ul li.hover{ background: url('css/images/tab_h.gif') repeat-x;color:#fff;}
.county2 .contentbox2{ border:0px solid #ccc;}


</style>
<script>
function news(m,n){
	var tli=document.getElementById("news_b"+m).getElementsByTagName("li"); 
	var mli=document.getElementById("news_s"+m).getElementsByTagName("ul"); 
		for(i=0;i<tli.length;i++){
			tli[i].className=i==n?"hover":""; mli[i].style.display=i==n?"block":"none"; 
			} 
		}
</script>

<div class="county2">

	
     <div id="main_tab2">
          <div class="titlebox2"> 
		
            <ul id="news_b1"> 
             <%
              	List<NewsType> newsList=(List<NewsType>)request.getAttribute("newsList1");
              				for(NewsType news:newsList){
              %>
                <li class='hover' onmouseover="news(1,0)" style="color:black;">
               
				
                    
								
					<%=news.getTypeName()%>
					
                   
                   
					  
                </li> 
			    <%
 			    	}
 			    %>
			        
            </ul> 
        </div>
        <div class="contentbox2"> 
            <div class="content2" id="news_s1"> 
            
						<ul  class='block'>
						
						
					<%List<News> newsList1=(List<News>)request.getAttribute("newsList");
			for(News news:newsList1){
																	%>
                    <li>
					<div class="data">[<%=news.getPostTime()%>]</div>			
					<a href="FindByIdNewsServlet?newsId=<%=news.getNewsId()%>"><%=news.getTitle()%></a>
					</li>
                   
                    <%
                                       	}
                                       %>
					
					
                    
					  
					 
					 
			
					  </ul>
					 
                </div> 
        </div>
	</div>
</DIV>
	<!--首页新闻  end-->
	<%
		Contact contact=(Contact)session.getAttribute("contact");
	%>
<!--联系我们 begin-->
	<div class="box0">
	<div class="box0_t"><h3>联系我们</h3></div>
	<div class="box0_m"><div  style="position:relative;padding-right:60px;">
	<span style="position:absolute;right:0px;top:5px;"><a href="Liuyan.jsp"><img alt="" src="images/message.gif" /></a></span>
	<span style="position:absolute;right:0px;top:70px;"><img alt="" src="images/service.gif" /></span>
	地址：<%=contact.getGsdz() %><br />
邮编：<%=contact.getYoubian() %><br />
总机：<%=contact.getShouji() %><br />
电话：<%=contact.getShouji() %><br />
传真：<%=contact.getChuanzhen() %><br />
Email：<%=contact.getKfyx() %></div></div>
	</div>
	<!--联系我们 end-->
	
	
	





</div>
<div class="clear"></div>
</div>	
<!--框架框架框架框架框架框架框架框架框架-->	








<jsp:include page="foot.jsp" />



</div>



</body>
</html>