
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>在线留言-xxx公司</title>
<meta name="description" content="网站首页优化描述">
<meta name="keywords" content="xxx公司关键字">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

<link href="css/style.css" rel="stylesheet" type="text/css">
<script>
	function changeCode()
	{
		 var date = new Date().getTime();
         //加时间戳是为了不重复的请求资源
         document.getElementById("codeImg").src = "CheckCodeServlet?"+date;  
	}
</script>
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
	<div class="box1_t"><h3>联系我们</h3></div>
	<div class="box1_m">
<ul class="sidebar">
    
	

<li><a href="liuyan.jsp">联系方式</a></li>
     
	

<li><a href="CompanyMapServlet">地理位置</a></li>
     
	
</ul> </div>
	</div>
	<!--classp end-->
	
	

	
	<jsp:include page="lianxi.jsp" />
	
	
	</div>
<div class="frame_r">




	<!--关于我们  begin-->
	<div class="box4">
	<div class="box4_t"><span>首页&nbsp;&raquo;&nbsp;在线留言</span></div>
	<div class="box4_m"><!-- liuyan start-->

    <form name="guestbook" action="LiuyanServlet" method="post" onSubmit="return checkMe(this)" id="liuyan">
        <TABLE>
          <tr> 
            <td colspan="2" class="L-title"><strong>添加留言</strong><span class="look-liuyan"><a href="liuyanlist.html">查看留言>></a></span>
            </td>
          </tr>
          <tr> 
            <td class="column-name">姓 名</td>
            <td><input type="text" name="username" size="30" onFocus="showbg(this);" onBlur="hiddenbg(this);"> <font color="#ff0000">*&nbsp;必填</font></td>
          </tr>
          <tr> 
            <td class="column-name">公 司</td>
            <td> <input type="text" name="company" size="30"  onFocus="showbg(this);" onBlur="hiddenbg(this);"></td>
          </tr>
		  <tr> 
            <td class="column-name">电 话</td>
            <td><input type="text" name="phone" size="30"  onFocus="showbg(this);" onBlur="hiddenbg(this);"></td>
          </tr>
          
<!--          <tr> 
            <td  class="column-name">移动电话：</td>
            <td><input type="text" name="mobile" size="30"  onFocus="showbg(this);" onBlur="hiddenbg(this);"></td>
          </tr>
-->          
          <tr> 
            <td  class="column-name">邮 箱</td>
            <td><input type="text" name="email" size="30"  onFocus="showbg(this);" onBlur="hiddenbg(this);"> <font color="#ff0000">*&nbsp;必填</font></td>
          </tr>
          
          
          <tr> 
            <td  class="column-name">网 站</td>
            <td><input type="text" name="homepage" size="30"  onFocus="showbg(this);" onBlur="hiddenbg(this);"></td>
          </tr>
          <tr> 
            <td class="column-name">主 题</td>
            <td><input type="text" name="title" size="30"  onFocus="showbg(this);" onBlur="hiddenbg(this);"> <font color="#ff0000">*&nbsp;必填</font></td>
          </tr>
          <tr> 
            <td class="column-name">留 言</td>
            <td> <textarea name="content" cols="50" rows="10"  onFocus="showbg(this);" onBlur="hiddenbg(this);"></textarea> <font color="#ff0000">*&nbsp;必填</font></td>
          </tr>
		  <tr> 
            <td class="column-name">验证码</td>
            <td><input name="verifycode" maxlength="20" size="5"  onFocus="showbg(this);" onBlur="hiddenbg(this);">
            <!-- <b class="yanzheng_font">5523</b> -->
            <img src="CheckCodeServlet" alt="" id="codeImg" onclick="changeCode()"/>
            </td>
          </tr>
          <tr> 
            <td colspan="2" align="center"> 
            <input type="hidden" value="223.4.28.56" name="userIP">
                <input type="submit" name="Submit3" value="提交">
                <input type="reset" name="Submit4" value="重写">
           
            </td>
          </tr>
        </table>
      </form>

	<script language="javascript">
//	alert("222");
		function checkMe(e){
				if(e.userName.value==""){
						alert("请输入您的姓名！");
						e.userName.focus();
						return false;
					}
				if(e.email.value==""){
						alert("请输入您的E-mail地址！");
						e.email.focus();
						return false;
					}
				if(e.title.value==""){
						alert("请输入您的留言主题题！");
						e.title.focus();
						return false;
					}
				if(e.content.value==""){
						alert("请输入留言内容！");
						e.content.focus();
						return false;
					}
				if(e.verifycode2.value!=""){
					if(e.verifycode2.value!=5523){
						alert("您输入的验证码不正确！");
						e.verifycode2.focus();
						e.verifycode2.select();
						return false;
						}
					}
				else{
						alert("请输入验证码！");
						e.verifycode2.focus();
						return false;
					}
}
function showbg(e){
		e.style.backgroundColor="#fee09e";
		e.style.borderWidth="2px";
		e.style.borderStyle="solid";
		e.style.borderColor="#87b7fe";
		e.style.padding="2px";
	}
function hiddenbg(e){
		e.style.backgroundColor="#ffffff";
		e.style.padding="1px";
		e.style.borderWidth="1px";
		e.style.borderStyle="solid";
		e.style.borderColor="#7F9DB9";
}

	</script>
		
	  <!-- 留言结束 --></div>
	</div>	
	<!--关于我们  end-->





</div>
<div class="clear"></div>
</div>	
<!--框架框架框架框架框架框架框架框架框架-->	




<jsp:include page="foot.jsp" />

	
		<%
			Object objMsg=request.getAttribute("msg");
			if(objMsg!=null){
				out.print("<script>alert('"+objMsg.toString()+"');</script>");
			}
		%>

</div>
</body>
</html>