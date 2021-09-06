<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--header begin-->
<div id="header">
<div class="logo"><img src="images/logo.gif" alt="" /></div>
<div class="search0"><div id="search"><form  id="headerSearchForm" method="post" action="products.html" name="productSearch">

   <span> <input name="myKeyword"  class="input"  value="——输入关键字——" onfocus="if(this.value=='——输入关键字——')this.value='';" onblur="if(this.value=='')this.value='——输入关键字——';" type="text"/><input type="image" class="buttom" value="" onclick="return click_search()"  src="images/go.gif"/></span><!--<input type="image" id="search-button" src="css/images/botton.gif"/>--><span class="buttom"><input name="search" value="true" type="hidden" /></span></form></div> 
<script language="javascript">
	function click_search(){
		searchkey=document.getElementById("headerSearchForm");
		var keywords;
		keywords=searchkey.myKeyword.value;
//		alert(keywords);
		if(keywords==""){
			alert("请输入要搜索的产品名称!");
			searchkey.myKeyword.select();
			searchkey.myKeyword.focus();
			return false;
		}
		else if(keywords=="产品搜索"){
			alert("请输入要搜索的产品名称!");
			searchkey.myKeyword.select();
			searchkey.myKeyword.focus();
			return false;
		}
	
	}
</script>




</div>
<div class="clear"></div>
</div>

<!--header end-->



<div id="nav">
<ul class="main_nav">
    <li id="index_nav"><a href="IndexServlet"><span>首页</span></a></li>
	
		
    <li id="about_nav"><a href="aboutServlet_findAll"><span>关于我们</span></a></li>
		
    <li id="news_nav"><a href="FindPageListNewsServlet"><span>新闻中心</span></a></li>
	
    <li id="products_nav"><a href="Productpage"><span>产品中心</span></a></li>
		
    <li id="service_nav"><a href="jishuServlet_findAll"><span>技术创新</span></a></li>
		
    <li id="sales_nav"><a href="pingzhiServlet_findAll"><span>品质战略</span></a></li>
		
    <li id="contact_nav" ><a href="ContactServlet"><span>联系我们</span></a></li>
		
    <li id="liuyan_nav"><a href="liuyan.jsp"><span>在线留言</span></a></li>
		
	
	
	
</ul>

</div>
<script language="javascript">
<!--
 	var geturl=window.location.pathname;
		switch (geturl){
			case '/index.html':
			document.getElementById('index_nav').className='on';
			break

			case '/products.html':
			document.getElementById('products_nav').className='on';
			break
			case '/productshow.html':
			document.getElementById('products_nav').className='on';
			break			
			case '/service.html':
			document.getElementById('service_nav').className='on';
			break;
			case '/sales.html':
			 document.getElementById('sales_nav').className='on';
			break
			case '/contact.html':
			document.getElementById('contact_nav').className='on';
			break
			case '/about.html':
			document.getElementById('about_nav').className='on';
			break
			case '/newslist.html':
			document.getElementById('news_nav').className='on';
			break
			case '/news.html':
			 document.getElementById('news_nav').className='on';
			break
			case '/support.html':
			 document.getElementById('support_nav').className='on';
			break
			case '/anli.html':
			document.getElementById('anli_nav').className='on';
			break
			case '/down.html':
			document.getElementById('down_nav').className='on';
			break
			case '/job.html':
			document.getElementById('job_nav').className='on';
			break
			case '/partner.html':
			document.getElementById('partner_nav').className='on';
			break
			case '/solution.html':
			document.getElementById('solution_nav').className='on';
			break
			case '/application.html':
			 document.getElementById('application_nav').className='on';
			break
			case '/shop.html':
			document.getElementById('shop_nav').className='on';
			break
			case '/software.html':
			document.getElementById('software_nav').className='on';
			break
			case '/links.html':
			document.getElementById('link_nav').className='on';
			break
			case '/liuyan.html':
			document.getElementById('liuyan_nav').className='on';
			break
			case '/liuyanlist.html':
			document.getElementById('liuyan_nav').className='on';
			break
			
			
			
		}
-->
</script>
</body>
</html>