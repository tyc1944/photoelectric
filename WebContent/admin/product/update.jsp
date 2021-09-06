<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入标签 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><!-- 引入标签 -->
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>修改新闻</title>
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
                	<input type="hidden" name="proId" value="${product.proId}">
                    <div class="layui-form-item">
                        <label for="title" class="layui-form-label">
                            <span class="x-red">*</span>标题</label>
                        <div class="layui-input-inline">
                            <input type="text" id="title" name="title" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${product.title}"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="pic" class="layui-form-label">
                            <span class="x-red">*</span>图片</label>
                        <div class="layui-input-inline">
                        	<img src="${pageContext.request.contextPath}/images/picImages/${product.pic}" style="width:150px;height:150px;"/>
                            <input type="hidden" id="pic" name="pic" required=""  autocomplete="off" class="layui-input" value="${product.pic}">
                            
                            
                            <div class="layui-upload-drag" id="test10">
							  <i class="layui-icon"></i>
							  <p>点击上传，或将文件拖拽到此处</p>
							  <div class="layui-hide" id="uploadDemoView">
							    <hr>
							    <img src="" alt="上传成功后渲染" style="max-width: 196px">
							  </div>
							</div>
                            
                            </div>
                    </div>                 
                    <div class="layui-form-item">
                        <label for="typeId" class="layui-form-label">
                            <span class="x-red">*</span>产品类型</label>
                        <div class="layui-input-inline">
                            <select id="typeId" name="typeId" class="valid">
                               <c:forEach var="productType" items="${productTypeList}">
                               		<c:if test="${productType.typeId==product.typeId}">
                               			<option value="${productType.typeId}" selected>${productType.typeName }</option>
                               		</c:if>
                                	<c:if test="${productType.typeId!=product.typeId}">
                               			<option value="${productType.typeId}" >${productType.typeName }</option>
                               		</c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                   <div class="layui-form-item">
                        <label for="postTime" class="layui-form-label">
                            <span class="x-red">*</span>发布时间</label>
                        <div class="layui-input-inline">
                            <input type="text" id="postTime" name="postTime" required=""  autocomplete="off" class="layui-input" value="<fmt:formatDate value='${product.postTime }' pattern='yyyy-MM-dd HH:mm:ss'/>"></div>
                    </div>
        <div class="layui-form-item layui-form-text">
            <label for="content" class="layui-form-label">内容</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" id="content" name="content" class="layui-textarea" lay-verify="content">${product.content }</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"></label>
            <button class="layui-btn" lay-filter="modify" lay-submit="">修改</button></div>
        </form>
        </div>
        </div>
        <script>layui.use(['form', 'layer','laydate','jquery','layedit','upload'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer,
                laydate = layui.laydate,
                upload = layui.upload;
                var layedit = layui.layedit;

              //执行一个laydate实例
                laydate.render({
                  elem: '#postTime', //指定元素
                  trigger: 'click',//呼出事件改成click
                  format: 'yyyy-MM-dd HH:mm:ss',
                  type: 'datetime'
                });
              
                
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
                var ieditor = layedit.build('content');
              
                //自定义验证规则
                form.verify({
                    content: function(value) {
                        return layedit.sync(ieditor);
                    }
                });
                
                
              //拖拽上传
                upload.render({
                  elem: '#test10'
                  ,url: '${pageContext.request.contextPath}/UploadProductServlet' //改成您自己的上传接口
                  ,done: function(res){
                    layer.msg('上传成功');
                    $("#pic").val(res.data.src);//返回的json中取出文件名放在图片隐藏域上
                    layui.$('#uploadDemoView').removeClass('layui-hide').find('img').attr('src', "${pageContext.request.contextPath}/images/picImages/"+res.data.src);
                    console.log(res)
                  }
                });
              
                //监听提交
                form.on('submit(modify)',
                function(data) {
                    console.log(data);
                    
                    $.ajax({
                    	type:"POST",
                    	url:"${pageContext.request.contextPath}/AdminProductServlet?flag=update",
                    	data:data.field,
                    	success:function(result){
                    		if(result=="ok"){
                    			  //发异步，把数据提交给php
                                layer.alert("修改成功", {
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