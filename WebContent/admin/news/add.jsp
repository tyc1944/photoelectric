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
                <form class="layui-form" name="myform" >
                    <div class="layui-form-item">
                        <label for="title" class="layui-form-label">
                            <span class="x-red">*</span>标题</label>
                        <div class="layui-input-inline">
                            <input type="text" id="title" name="title" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="author" class="layui-form-label">
                            <span class="x-red">*</span>发布人</label>
                        <div class="layui-input-inline">
                            <input type="text" id="author" name="author" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="clicks" class="layui-form-label">
                            <span class="x-red">*</span>点击率</label>
                        <div class="layui-input-inline">
                            <input type="text" id="clicks" name="clicks" required=""  autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="typeId" class="layui-form-label">
                            <span class="x-red">*</span>新闻类型</label>
                        <div class="layui-input-inline">
                            <select id="typeId" name="typeId" class="valid">
                               <c:forEach var="newsType" items="${ newsTypeList}">
                                	<option value="${newsType.typeId }">${newsType.typeName }</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                   
        <div class="layui-form-item layui-form-text">
            <label for="description" class="layui-form-label">内容</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" id="description" name="description" class="layui-textarea" lay-verify="description"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"></label>
            <button class="layui-btn" lay-filter="add" lay-submit="">增加</button></div>
        </form>
        </div>
        </div>
        <script>layui.use(['form', 'layer','layedit','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;
                
                
                /* var layedit = layui.layedit;
                layedit.set({
                    //暴露layupload参数设置接口 --详细查看layupload参数说明
                    uploadImage: {
                        url: '${pageContext.request.contextPath}/UploadImageServlet',
                        accept: 'image',
                        acceptMime: 'image/*',
                        exts: 'jpg|png|gif|bmp|jpeg',
                        size: '10240'
                    }
                    , uploadVideo: {
                        url: '/Attachment/LayUploadFile',
                        accept: 'video',
                        acceptMime: 'video/*',
                        exts: 'mp4|flv|avi|rm|rmvb',
                        size: '20480'
                    }
                    //右键删除图片/视频时的回调参数，post到后台删除服务器文件等操作，
                    //传递参数：
                    //图片： imgpath --图片路径
                    //视频： filepath --视频路径 imgpath --封面路径
                    , calldel: {
                        url: '/Attachment/DeleteFile'
                    }
                    //开发者模式 --默认为false
                    , devmode: true
                    //插入代码设置
                    , codeConfig: {
                        hide: true,  //是否显示编码语言选择框
                        default:'javascript' //hide为true时的默认语言格式
                    }
                    , tool: [
                        'html', 'code', 'strong', 'italic', 'underline', 'del', 'addhr', '|', 'fontFomatt', 'colorpicker', 'face'
                        , '|', 'left', 'center', 'right', '|', 'link', 'unlink','images', 'image_alt', 'video', 'anchors'
                        , '|','table', 'fullScreen'
                    ]
                    , height: '90%'
                });
                var ieditor = layedit.build('description');//控件id */
                
                
                
                var layedit = layui.layedit;
                layedit.set({
                    //暴露layupload参数设置接口 --详细查看layupload参数说明
                    uploadImage: {
                        url: '${pageContext.request.contextPath}/UploadImageServlet',
                        accept: 'image',
                        acceptMime: 'image/*',
                        exts: 'jpg|png|gif|bmp|jpeg',
                        size: '10240'
                    }
                    
                    //右键删除图片/视频时的回调参数，post到后台删除服务器文件等操作，
                    //传递参数：
                    //图片： imgpath --图片路径
                    //视频： filepath --视频路径 imgpath --封面路径
                    , calldel: {
                        url: '/Attachment/DeleteFile'
                    }
                    //开发者模式 --默认为false
                    , devmode: true
                    //插入代码设置
                    , codeConfig: {
                        hide: true, //是否显示编码语言选择框
                        default:'javascript' //hide为true时的默认语言格式
                    }
                    , tool: [
                        'html', 'code', 'strong', 'italic', 'underline', 'del', 'addhr', '|', 'fontFomatt', 'colorpicker', 'face'
                        , '|', 'left', 'center', 'right', '|', 'link', 'unlink','images', 'image_alt', 'anchors'
                        , '|','table', 'fullScreen'
                    ]
                    , height: '90%'
                });
                var ieditor = layedit.build('description');
                
                
                //自定义验证规则
                form.verify({
                    description: function(value) {
                        return layedit.sync(ieditor);
                    }
                }); 

                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    
                    $.ajax({
                    	type:"POST",
                    	url:"${pageContext.request.contextPath}/AdminNewsServlet?flag=add",
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