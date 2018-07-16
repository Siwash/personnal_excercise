<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>添加用户</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<script type="text/javascript"
	src="js/jquery.min.js"></script>
<script type="text/javascript" src="lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-body">
  
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>您的工作日志详情</legend>
</fieldset>
<form id="form1" class="layui-form layui-form-pane" action="">
  <div class="layui-form-item">
    <label class="layui-form-label">标题</label>
    <div class="layui-input-block">
      <input lay-verify="required" value="${record.title }" readOnly="readonly" name="title" class="layui-input" type="text" placeholder="请输入标题" autocomplete="off">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">日志类型</label>
    <div class="layui-input-inline">
      <input lay-verify="required" value="${record.recordType=='day'? '日志':'周报' }" readOnly="readonly" name="title" class="layui-input" type="text" placeholder="请输入标题" autocomplete="off">
    </div>
  </div>
  
 
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">日志内容</label>
    <div class="layui-input-block">
      <textarea name="content" readOnly="readonly" lay-verify="required|content" class="layui-textarea" placeholder="请输入内容">${record.content}</textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">编辑时间</label>
    <div class="layui-input-inline">
      <input id="time" lay-verify="required" value="${record.recordTime }" readOnly="readonly" name="title" class="layui-input" type="text" placeholder="请输入标题" autocomplete="off">
    </div>
  </div>
</form>
	</div>
	<script>
	$(function(){
		$("#time").val(new Date($("#time").val()).format("yyyy/MM/dd hh:mm"));
	})
	 layui.use(['form','layer'], function(){
         $ = layui.jquery;
       var form = layui.form
       ,layer = layui.layer;
     
       //自定义验证规则
       form.verify({
    	   content: function(value){
           if(value.length < 5){
             return '内容不能少于50字哦';
           }
         }
         ,pass: [/(.+){6,12}$/, '密码必须6到12位']
         ,repass: function(value){
             if($('#L_pass').val()!=$('#L_repass').val()){
                 return '两次密码不一致';
             }
         }
       });
   
       form.on('submit(add)', function(data){
           console.log(data);
           $.ajax({
       		type : "POST",
       		data : $('#form1').serialize(),
       		dataType : "text",
       		url : "selfController/doRecoder.ajax",
       		success : function(result) {
       		 //发异步，把数据提交给php
                layer.msg("增加成功",{
             		icon : 1,
              		time: 500,
              	},function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.location.reload();
                    parent.layer.close(index);
                });
       		},
       		error : function() {
       			layer.msg('无法连接服务器', {icon: 2});
       		}
       	});   
           return false;
         });
       //监听提交
	 });
	</script>
</body>

</html>