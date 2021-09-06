<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入标签 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><!-- 引入标签 -->
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>修改技术</title>
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
                	<input type="hidden" name="proId" value="${contact.proId}">
                    <div class="layui-form-item">
                        <label for="gsmc" class="layui-form-label">
                            <span class="x-red">*</span>公司名称</label>
                        <div class="layui-input-inline">
                            <input type="text" id="gsmc" name="gsmc" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.gsmc}"></div>
                    </div>              
                    <div class="layui-form-item">
                        <label for="gsdz" class="layui-form-label">
                            <span class="x-red">*</span>公司地址</label>
                        <div class="layui-input-inline">
                            <input type="text" id="gsdz" name="gsdz" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.gsdz}"></div>
                    </div>  
                                        <div class="layui-form-item">
                        <label for="youbian" class="layui-form-label">
                            <span class="x-red">*</span>邮编</label>
                        <div class="layui-input-inline">
                            <input type="text" id="youbian" name="youbian" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.youbian}"></div>
                    </div>  
                                        <div class="layui-form-item">
                        <label for="kfdh" class="layui-form-label">
                            <span class="x-red">*</span>客服电话</label>
                        <div class="layui-input-inline">
                            <input type="text" id="kfdh" name="kfdh" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.kfdh}"></div>
                    </div>  
                                        <div class="layui-form-item">
                        <label for="chuanzhen" class="layui-form-label">
                            <span class="x-red">*</span>传真 </label>
                        <div class="layui-input-inline">
                            <input type="text" id="chuanzhen" name="chuanzhen" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.chuanzhen}"></div>
                    </div>              
                    <div class="layui-form-item">
                        <label for="shouji" class="layui-form-label">
                            <span class="x-red">*</span>手机</label>
                        <div class="layui-input-inline">
                            <input type="text" id="shouji" name="shouji" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.shouji}"></div>
                    </div>  
                                        <div class="layui-form-item">
                        <label for="lianxiren" class="layui-form-label">
                            <span class="x-red">*</span>联系人</label>
                        <div class="layui-input-inline">
                            <input type="text" id="lianxiren" name="lianxiren" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.lianxiren}"></div>
                    </div>  
                                        <div class="layui-form-item">
                        <label for="msn" class="layui-form-label">
                            <span class="x-red">*</span>msn</label>
                        <div class="layui-input-inline">
                            <input type="text" id="msn" name="msn" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.msn}"></div>
                    </div> 
                                        <div class="layui-form-item">
                        <label for="qq" class="layui-form-label">
                            <span class="x-red">*</span>QQ</label>
                        <div class="layui-input-inline">
                            <input type="text" id="qq" name="qq" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.qq}"></div>
                    </div>              
                    <div class="layui-form-item">
                        <label for="swyx" class="layui-form-label">
                            <span class="x-red">*</span>商务邮箱</label>
                        <div class="layui-input-inline">
                            <input type="text" id="swyx" name="swyx" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.swyx}"></div>
                    </div>  
                                        <div class="layui-form-item">
                        <label for="kfyx" class="layui-form-label">
                            <span class="x-red">*</span>客服邮箱</label>
                        <div class="layui-input-inline">
                            <input type="text" id="kfyx" name="kfyx" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.kfyx}"></div>
                    </div>  
                                        <div class="layui-form-item">
                        <label for="gswz" class="layui-form-label">
                            <span class="x-red">*</span>公司网址</label>
                        <div class="layui-input-inline">
                            <input type="text" id="gswz" name="gswz" required="" lay-verify="required" autocomplete="off" class="layui-input" value="${contact.gswz}"></div>
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

              //执行一个laydate实例
            
              
               /*  //自定义验证规则
                form.verify({
                    nikename: function(value) {
                        if (value.length < 5) {
                            return '昵称至少得5个字符啊';
                        }
                    },
                    pass: [/(.+){6,12}$/, '密码必须6到12位'],
                    repass: function(value) {
                        if ($('#L_pass').val() != $('#L_repass').val()) {
                            return '两次密码不一致';
                        }
                    }
                }); */
                
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
            
            form.verify({
                content: function(value) {
                    return layedit.sync(ieditor);
                }
            }); 
            
                //监听提交
                form.on('submit(modify)',
                function(data) {
                    console.log(data);
                    
                    $.ajax({
                    	type:"POST",
                    	url:"${pageContext.request.contextPath}/AdminContactServlet?flag=update",
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