<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入标签 -->
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/xadmin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]--></head>
    
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form">
                    <div class="layui-form-item">
                        <label for="uname" class="layui-form-label">
                            <span class="x-red">*</span>用户名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="uname" name="uname" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div> 
                       <div class="layui-form-item">
                        <label for="upass" class="layui-form-label">
                            <span class="x-red">*</span>密码</label>
                        <div class="layui-input-inline">
                            <input type="text" id="upass" name="upass" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>                     
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"></label>
            <button class="layui-btn" lay-filter="add" lay-submit="">增加</button></div>
        </form>
        </div>
        </div>
        <script>layui.use(['form', 'layer'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

              
                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    
                    $.ajax({
                    	type:"POST",
                    	url:"${pageContext.request.contextPath}/AdminAdminServlet?flag=add",
                    	data:data.field,
                    	success:function(result){
                    		if(result=="ok"){
                    			  //发异步，把数据提交给php
                                layer.alert("添加成功", {
                                    icon: 6
                                },
                                function() {
                                    // 获得frame索引
                                    var index = parent.layer.getFrameIndex(window.name);
                                    parent.location.reload();//
                                    //关闭当前frame
                                    parent.layer.close(index);
                                    
                                });
                    		}else{
                    			 layer.alert("添加失败", {
                                     icon: 5
                                 });
                    		}
                    	},
                    	error:function(){
                    		layer.msg("请求失败");
                    	}
                    })
                    
                  
                    
                    
                    return false;
                });

            });</script>
        
    </body>

</html>