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


<!--footer begin-->
<div class="links">
 <select  name="11" onchange="window.open(this.options[this.selectedIndex].value,'_blank')">
        <option value="" selected>*友情链接*</option>
<option value=http://www.baidu.com >百度</option><option value=http://.cn/ >网页模板</option><option value=http:///moban/qymoban/index.html >企业网站模板</option><option value=http://.cn/products.html?bid=1&sid=81 >礼品网站模板</option><option value=http://.cn/products.html?bid=1&sid=83 >家居网站模板</option><option value=http://www.mobanku.com >网页模板</option> </select></div>
<div class="footer">
<div class="service"><p>京ICP备12485645号</p><p>技术支持：</p></div>
<div class="quick_access"><a href="aboutServlet_findAll">关于我们</a>|<a href="Productpage">产品中心</a>|<a href="pingzhiServlet_findAll">品质战略</a>|<a href="ContactServlet">联系我们</a></div>
<div class="copyright">
<p>版权所有：<a href="IndexServlet">
<%
	Contact contact=(Contact)session.getAttribute("contact");//从session中获取联系我们对象
%>
	<%=contact.getGsmc() %></a> 地址：<%=contact.getGsdz() %> 总机：<%=contact.getKfdh() %>&nbsp;&nbsp;电话：<%=contact.getKfdh() %>&nbsp; 传真：<%=contact.getChuanzhen() %></p>
</div>
</div>
<style type="text/css">
.qqbox a:link {
color: #000;
text-decoration: none;
}
.qqbox a:visited {
color: #000;
text-decoration: none;
}
.qqbox a:hover {
color: #f80000;
text-decoration: underline;
}
.qqbox a:active {
color: #f80000;
text-decoration: underline;
}

.qqbox{
width:132px;
height:auto;
overflow:hidden;
position:absolute;
right:0;
top:100px;
color:#000000;
font-size:12px;
letter-spacing:0px;
}
.qqlv{
width:25px;
height:256px;
overflow:hidden;
position:relative;
float:right;
z-index:50px;
}
.qqkf{
width:120px;
height:auto;
overflow:hidden;
right:0;
top:0;
z-index:99px;
border:6px solid #FF5D0C;
background:#fff;
}
.qqkfbt{
width:118px;
height:20px;
overflow:hidden;
background:#FF5D0C;
line-height:20px;
font-weight:bold;
color:#fff;
position:relative;
border:1px solid #fff;
cursor:pointer;
text-align:center;
}
.qqkfhm{
width:112px;
height:22px;
overflow:hidden;
line-height:22px;
padding-right:8px;
position:relative;
margin:3px 0;
}
.bgdh{
width:102px;
padding-left:10px;
}
</style>
</head>
<body>
<div class="qqbox" id="divQQbox">
<div class="qqlv" id="meumid" onMouseOver="show()"><img src="images/qq.gif" /></div>
<div class="qqkf" style="display:none;" id="contentid" onMouseOut="hideMsgBox(event)">
<div class="qqkfbt" onMouseOut="showandhide('qq-','qqkfbt','qqkfbt','K',1,1);" id="qq-1" onfocus="this.blur();">客 服 中 心</div>
<div id="K1" align="left" style="padding:5px">

<div>
<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=667333502&site=qq&menu=yes"><img border="0" src="images/pa.gif" alt="点击这里给我发消息" title="点击这里给我发消息"></a>

<br /></div>

	





<!--msn -->
 

<img src="images/msn.gif" border="0" alt="业务员1"><A title="msn" href="msnim:chat?contact=mobanku@gmail.com" ?>业务咨询</A></a><br />

	


<img src="images/msn.gif" border="0" alt="ee"><A title="msn" href="msnim:chat?contact=ee" ?>业务咨询</A></a><br />

	



<!--taobao -->
 

<a target="_blank" href="http://amos1.taobao.com/msg.ww?v=2&uid=12oaks&s=1" >
<img border="0" src="images/pa.gif" alt="模板库淘宝" /></a>
	


<a target="_blank" href="http://amos1.taobao.com/msg.ww?v=2&uid=33&s=1" >
<img border="0" src="images/pa.gif" alt="11" /></a>
	

	
	



</div>

</div>
</div>
<script language="javascript">
function showandhide(h_id,hon_class,hout_class,c_id,totalnumber,activeno) {
var h_id,hon_id,hout_id,c_id,totalnumber,activeno;
for (var i=1;i<=totalnumber;i++) {
document.getElementById(c_id+i).style.display='none';
document.getElementById(h_id+i).className=hout_class;
}
document.getElementById(c_id+activeno).style.display='block';
document.getElementById(h_id+activeno).className=hon_class;
}
var tips; 
var theTop = 40;
var old = theTop;
function initFloatTips() 
{ 
tips = document.getElementById('divQQbox');
moveTips();
}
function moveTips()
{
var tt=50; 
if (window.innerHeight) 
{
pos = window.pageYOffset 
}else if (document.documentElement && document.documentElement.scrollTop) {
pos = document.documentElement.scrollTop 
}else if (document.body) {
pos = document.body.scrollTop; 
}
pos=pos-tips.offsetTop+theTop; 
pos=tips.offsetTop+pos/10; 
if (pos < theTop){
pos = theTop;
}
if (pos != old) { 
tips.style.top = pos+"px";
tt=10; //alert(tips.style.top); 
}
old = pos;
setTimeout(moveTips,tt);
}
initFloatTips();
if(typeof(HTMLElement)!="undefined") //firefox定义contains()方法，ie下不起作用
{ 
HTMLElement.prototype.contains=function (obj) 
{ 
while(obj!=null&&typeof(obj.tagName)!="undefind"){
if(obj==this) return true; 
obj=obj.parentNode;
} 
return false; 
}
}
function show()
{
document.getElementById("meumid").style.display="none"
document.getElementById("contentid").style.display="block"
}
function hideMsgBox(theEvent){
if (theEvent){
var browser=navigator.userAgent;
if (browser.indexOf("Firefox")>0){ //如果是Firefox
if (document.getElementById("contentid").contains(theEvent.relatedTarget)) {
return
}
}
if (browser.indexOf("MSIE")>0 || browser.indexOf("Presto")>=0){
if (document.getElementById('contentid').contains(event.toElement)) {
return; 
}
}
}
document.getElementById("meumid").style.display = "block";
document.getElementById("contentid").style.display = "none";
}
</script>

<!--footer end-->



</div>
</body>
</html>