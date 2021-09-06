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
            <a href="">新闻管理</a>
            <a>
              <cite>新闻类型列表</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加新闻','${pageContext.request.contextPath}/AdminNewsTypeServlet?flag=toAdd',600,450)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>ID</th>
                                    <th>新闻类型名称</th>
                                    <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                               <c:forEach var="newstype" items="${newsTypeList}">
                                  <tr>
                                    <td>
                                      <input type="checkbox" name="id" value="1"   lay-skin="primary"> 
                                    </td>
                                    <td>${newstype.typeId}</td>
                                    <td>${newstype.typeName}</td>
                                    <td class="td-manage">
                                      <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">
                                        <i class="layui-icon">&#xe601;</i>
                                      </a>
                                      <a title="编辑"  onclick="xadmin.open('编辑','${pageContext.request.contextPath}/AdminNewsTypeServlet?flag=toUpdate&typeId=${newstype.typeId}',700,400)" href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                      </a>
                                      <a onclick="xadmin.open('修改密码','member-password.html',600,400)" title="修改密码" href="javascript:;">
                                        <i class="layui-icon">&#xe631;</i>
                                      </a>
                                    <a title="删除" onclick="member_del(this,'${newstype.typeId}')" href="javascript:;">
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
                                  <a class="prev" href="AdminNewsTypeServlet?flag=list&pageNo=${myPage.pageNo-1}">&lt;&lt;</a>
                                  
                                  <c:forEach var="p" begin="1" end="${myPage.pageCount}">
                                    <c:if test="${p==myPage.pageNo }">
                                    	 <span class="current">${p}</span>
                                    </c:if>
                                    <c:if test="${p!=myPage.pageNo }">
                                    	 <a class="num" href="AdminNewsTypeServlet?flag=list&pageNo=${p}">${p}</a>
                                    </c:if>
                                  </c:forEach>
                                  <a class="next" href="AdminNewsTypeServlet?flag=list&pageNo=${myPage.pageNo+1}">&gt;&gt;</a>
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
              	url:"${pageContext.request.contextPath}/AdminNewsTypeServlet?flag=delete&typeId="+id,
              	success:function(result){
              		console.log(result+"====");
              		if(result=="haveChildren"){
             			 layer.alert("先删除关联的新闻", {
                              icon: 5
                          });
             		}else if(result=="ok"){
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
                	url:"${pageContext.request.contextPath}/AdminNewsTypeServlet?flag=Manydelete&typeIds="+ids.toString(),
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