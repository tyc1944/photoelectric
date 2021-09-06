<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入标签 -->
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>添加新闻</title>
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
            <input type="hidden" id="oldRightPass" name="oldRightPass" value="${sessionScope.LOGIN_USER.upass}">
                <form class="layui-form" name="myform" >
                 <%--    <div class="layui-form-item">
                        <label for="title" class="layui-form-label">
                            用户名</label>
                        <div class="layui-input-inline">
                          
                            <span class="layui-input"> ${sessionScope.LOGIN_USER.uname}</span>
                            </div>
                    </div> --%>
                    <div class="layui-form-item">
                        <label for="oldpass" class="layui-form-label">
                            <span class="x-red">*</span>原始密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="oldpass" name="oldpass" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="newpass" class="layui-form-label">
                            <span class="x-red">*</span>新密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="newpass" name="newpass" required=""  autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="newpass2" class="layui-form-label">
                            <span class="x-red">*</span>确认新密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="newpass2" name="newpass2" lay-verify="required|confirmPass" autocomplete="off" class="layui-input"></div>
                    </div>
                    
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"></label>
            <button class="layui-btn" lay-filter="modify" lay-submit="">修改</button></div>
        </form>
        </div>
        </div>
        <script>layui.use(['form', 'layer'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;
                
                
                
                //自定义验证规则
                form.verify({
                    description: function(value) {
                        return layedit.sync(ieditor);
                    },
                    confirmPass:function(value){
                        if($('#newpass').val() !== value){
                        	$('#newpass').val("");
                        	$('#newpass2').val("");
                        	return '两次输入密码不一致！';
                        	
                        }
                            
                    }

                }); 

                //监听提交
                form.on('submit(modify)',
                function(data) {
                    console.log(data);
                    $.ajax({
                    	type:"POST",
                    	url:"${pageContext.request.contextPath}/AdminUserServlet?flag=updatePass",
                    	data:data.field,
                    	success:function(result){
                    		console.log(result);
                    		if(result=="oldpassError"){ 
                    			layer.alert("原始密码错误", {
                                	icon: 5
                            	});
                    		}else if(result=="ok"){
                    			  //发异步，把数据提交给php
                                layer.alert("修改成功", {
                                    icon: 6
                                },
                                function() {
                                    // 获得frame索引
                                    var index = parent.layer.getFrameIndex(window.name);
                                   
                                    //关闭当前frame
                                    parent.layer.close(index);
                                    parent.location.href='${pageContext.request.contextPath}/admin/login.jsp';
                                    
                                });
                    		}else{
                    			 layer.alert("修改失败", {
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