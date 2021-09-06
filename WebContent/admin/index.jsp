<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.electric.entity.User" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入标签 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><!-- 引入标签 -->
<!doctype html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>后台登录-X-admin2.2</title>
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <!-- <link rel="stylesheet" href="./css/theme5.css"> -->
        <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
            // 是否开启刷新记忆tab功能
            // var is_remember = false;
        </script>
    </head>
    <body class="index">
    <%
	User user =(User)session.getAttribute("LOGIN_USER");
	if(user==null){
		response.sendRedirect("login.jsp");	
	}
	
	 %>
        <!-- 顶部开始 -->
        <div class="container">
            <div class="logo">
                <a href="./index.jsp">${sessionScope.LOGIN_USER.uname }</a></div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>
            <!-- <ul class="layui-nav left fast-add" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">+新增</a>
                    <dl class="layui-nav-child">
                        二级菜单
                        <dd>
                            <a onclick="xadmin.open('最大化','http://www.baidu.com','','',true)">
                                <i class="iconfont">&#xe6a2;</i>弹出最大化</a></dd>
                        <dd>
                            <a onclick="xadmin.open('弹出自动宽高','http://www.baidu.com')">
                                <i class="iconfont">&#xe6a8;</i>弹出自动宽高</a></dd>
                        <dd>
                            <a onclick="xadmin.open('弹出指定宽高','http://www.baidu.com',500,300)">
                                <i class="iconfont">&#xe6a8;</i>弹出指定宽高</a></dd>
                        <dd>
                            <a onclick="xadmin.add_tab('在tab打开','member-list.html')">
                                <i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>
                        <dd>
                            <a onclick="xadmin.add_tab('在tab打开刷新','member-del.html',true)">
                                <i class="iconfont">&#xe6b8;</i>在tab打开刷新</a></dd>
                    </dl>
                </li>
            </ul> -->
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;">${sessionScope.LOGIN_USER.uname }</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('修改密码','${pageContext.request.contextPath}/admin/update/update.jsp',450,300)">修改密码</a></dd>
                        <dd>
                            <a onclick="xadmin.open('切换帐号','${pageContext.request.contextPath}/AdminOutServlet')">切换帐号</a></dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/AdminOutServlet">退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item to-index">
                    <a href="${pageContext.request.contextPath}/IndexServlet" target="_blank">前台首页</a></li>
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">
                	<li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="新闻管理">&#xe723;</i>
                            <cite>新闻管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('新闻列表','${pageContext.request.contextPath}/AdminNewsServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>新闻列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('添加新闻','${pageContext.request.contextPath}/AdminNewsServlet?flag=toAdd')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>添加新闻</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('新闻类型列表','${pageContext.request.contextPath}/AdminNewsTypeServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>新闻类型列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('添加新闻类型','${pageContext.request.contextPath}/AdminNewsTypeServlet?flag=toAdd')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>添加新闻类型</cite></a>
                            </li>
                            
                        </ul>
                    </li>
                
                
                
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="产品管理">&#xe6b8;</i>
                            <cite>产品管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('产品列表','${pageContext.request.contextPath}/AdminProductServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>产品列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('添加产品','${pageContext.request.contextPath}/AdminProductServlet?flag=toAdd')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>添加产品</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('产品类型','${pageContext.request.contextPath}/AdminProductTypeServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>产品类型</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('添加新闻类型','${pageContext.request.contextPath}/AdminProductTypeServlet?flag=toAdd')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>添加产品类型</cite></a>
                            </li>
                            
                        </ul>
                    </li>
                     <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="技术管理">&#xe723;</i>
                            <cite>技术管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('技术列表','${pageContext.request.contextPath}/AdminJishuServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>技术列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('添加技术','${pageContext.request.contextPath}/AdminJishuServlet?flag=toAdd')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>添加技术</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="品质管理">&#xe723;</i>
                            <cite>品质管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('品质列表','${pageContext.request.contextPath}/AdminPingzhiServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>品质列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('添加品质','${pageContext.request.contextPath}/AdminPingzhiServlet?flag=toAdd')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>添加品质</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="关于管理">&#xe723;</i>
                            <cite>关于管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                        <li>
                                <a onclick="xadmin.add_tab('关于列表','${pageContext.request.contextPath}/AdminAboutServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>关于列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('修改关于','${pageContext.request.contextPath}/AdminAboutServlet?flag=toUpdate')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>修改关于</cite></a>
                            </li>

                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="联系管理">&#xe723;</i>
                            <cite>联系管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('修改联系','${pageContext.request.contextPath}/AdminContactServlet?flag=toUpdate')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>修改联系</cite></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="留言管理">&#xe723;</i>
                            <cite>留言管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('留言列表','${pageContext.request.contextPath}/AdminLiuyanServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>留言列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('添加留言','${pageContext.request.contextPath}/AdminLiuyanServlet?flag=toAdd')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>添加留言</cite></a>
                            </li>
                        </ul>
                    </li>

 					<li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="地图管理">&#xe726;</i>
                            <cite>地图管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('地图列表','${pageContext.request.contextPath}/AdminCompanyMapServlet?flag=toUpdate')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>地图列表</cite></a>
                            </li>
                          

                        </ul>
                    </li>
                     <c:if test="${sessionScope.LOGIN_USER.uname=='admin'}">
                     
                     
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="管理员管理">&#xe726;</i>
                            <cite>管理员管理</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('管理员列表','${pageContext.request.contextPath}/AdminManagerServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>管理员列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('角色管理','${pageContext.request.contextPath}/AdminAdminServlet?flag=list')">
                                    <i class="iconfont">&#xe6a7;</i>
                                    <cite>角色管理</cite></a>
                            </li>

                        </ul>
                    </li>
                    </c:if>

                </ul>
            </div>
        </div>
        <!-- <div class="x-slide_left"></div> -->
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
                <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                    <dl>
                        <dd data-type="this">关闭当前</dd>
                        <dd data-type="other">关闭其它</dd>
                        <dd data-type="all">关闭全部</dd></dl>
                </div>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='./welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <style id="theme_style"></style>
        <!-- 右侧主体结束 -->
        <!-- 中部结束 -->
       
    </body>

</html>