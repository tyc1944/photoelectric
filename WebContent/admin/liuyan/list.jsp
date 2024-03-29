<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- 引入标签 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><!-- 引入标签 -->
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
        <script src="${pageContext.request.contextPath}/admin/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/xadmin.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">留言管理</a>
            <a>
              <cite>留言列表</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                      
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加留言','${pageContext.request.contextPath}/AdminLiuyanServlet?flag=toAdd',600,450)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th width="5%">
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>公司</th>                
                                    <th>手机</th>
                                    <th>邮箱</th>
                                    <th>网站</th>
                                    <th>主题</th>
                                    <th>留言</th> 
                                       <th>操作</th>             
                                    </tr>
                                </thead>
                                <tbody>
                               <c:forEach var="liuyan" items="${liuyanList}">
                                  <tr>
                                    <td>
                                      <input type="checkbox" name="id" value="${liuyan.id}"   lay-skin="primary"> 
                                    </td>
                                    <td>${liuyan.id}</td>
                                    <td>${liuyan.username}</td>
                                    <td>${liuyan.company}</td>
                                     <td>${liuyan.phone}</td>
                                    <td>${liuyan.email}</td>
                                    <td>${liuyan.homepage}</td>
                                     <td>${liuyan.title}</td>
                             <td>${liuyan.content}</td>                            
                                    <td class="td-manage">
                                     
                                      <a title="编辑"  onclick="xadmin.open('编辑','${pageContext.request.contextPath}/AdminLiuyanServlet?flag=toUpdate&id=${liuyan.id}',700,500)" href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                      </a>
                                      
                                      <a title="删除" onclick="member_del(this,'${liuyan.id}')" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i>
                                      </a>
                                    </td>
                                  </tr>
                                  </c:forEach>
                                 
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <a class="prev" href="AdminLiuyanServlet?flag=list&pageNo=${myPage.pageNo-1}">&lt;&lt;</a>
                                  
                                  <c:forEach var="p" begin="1" end="${myPage.pageCount}">
                                    <c:if test="${p==myPage.pageNo }">
                                    	 <span class="current">${p}</span>
                                    </c:if>
                                    <c:if test="${p!=myPage.pageNo }">
                                    	 <a class="num" href="AdminLiuyanServlet?flag=list&pageNo=${p}">${p}</a>
                                    </c:if>
                                  </c:forEach>
                                  <a class="next" href="AdminLiuyanServlet?flag=list&pageNo=${myPage.pageNo+1}">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var  form = layui.form;


        // 监听全选
        form.on('checkbox(checkall)', function(data){

          if(data.elem.checked){
            $('tbody input').prop('checked',true);
          }else{
            $('tbody input').prop('checked',false);
          }
          form.render('checkbox');
        }); 
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });


      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
        	  $.ajax({
              	type:"POST",
              	url:"${pageContext.request.contextPath}/AdminLiuyanServlet?flag=delete&id="+id,
              	success:function(result){
              		console.log(result+"====");
              		if(result=="ok"){
              		  //发异步删除数据
                        $(obj).parents("tr").remove();
                        layer.msg('已删除!',{icon:1,time:1000});
              		}else{
              			 layer.alert("删除失败", {
                               icon: 5
                           });
              		}
              	},
              	error:function(){
              		layer.msg("请求失败");
              	}
              });
          });
      }



      function delAll (argument) {
        var ids = [];

        // 获取选中的id 
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
               ids.push($(this).val())
            }
        });
  
        layer.confirm('确认要删除吗？',function(index){
        	
        	 $.ajax({
               	type:"POST",
               	url:"${pageContext.request.contextPath}/AdminLiuyanServlet?flag=Manydelete&Ids="+ids.toString(),
               	success:function(result){
               		console.log(result+"====");
               		if(result=="ok"){
               		  //发异步删除数据
                         $(obj).parents("tr").remove();
                         layer.msg('已删除!',{icon:1,time:1000});
               		}else{
               			 layer.alert("批量删除失败", {
                                icon: 5
                            });
               		}
               	},
               	error:function(){
               		layer.msg("请求失败");
               	}
               });
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
            
            
            
        });
      }
    </script>
</html>