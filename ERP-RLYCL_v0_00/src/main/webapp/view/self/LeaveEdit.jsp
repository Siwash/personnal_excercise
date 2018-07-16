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
  <legend>请假申请</legend>
</fieldset>
<form id="form1" class="layui-form layui-form-pane" action="">
   <div class="layui-form-item">
				<label class="layui-form-label">开始时间</label>
				<div class="layui-input-inline">
					<input id="start" name="startTime" class="layui-input" type="text"
						placeholder="请输入标题" autocomplete="off" lay-verify="required">
				</div>

				<label class="layui-form-label">结束时间</label>

				<div class="layui-input-inline">
					<input id="end" name="endingTime" class="layui-input" type="text"
						placeholder="请输入标题" autocomplete="off" lay-verify="required">
				</div>
			</div>
  
 
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">请假理由填写</label>
    <div class="layui-input-block">
      <textarea name="leaveReason" lay-verify="required|content" class="layui-textarea" placeholder="请输入内容"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
         
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  增加
              </button>
          </div>
</form>
	</div>
	<script>
	 layui.use(['form','layer','laydate'], function(){
		 var end='2080-10-14';
			var start=new Date().format('yyyy-MM-dd hh:mm:ss');
		  	var form = layui.form
		  	,layer = layui.layer
		  	,layedit = layui.layedit
		  	,laydate = layui.laydate;
	//时间
	var ins1= laydate.render({
    elem: '#start'
    ,min: start
    ,type:'datetime'
    ,max:end
    ,done: function(value, dates, endDate) {
				 ins2.config.min ={  
                         year:dates.year,   
                         month:dates.month-1, //关键  
                         date: dates.date,   
                         hours: dates.hours,   
                        minutes: dates.minutes,   
                        seconds : dates.seconds
                };      
			}
  });
 var ins2=laydate.render({
    elem: '#end'
    ,type:'datetime'
    ,min: start
    ,done: function(value, dates, endDate) {
    			ins1.config.max={  
                    year:dates.year,   
                        month:dates.month-1,//关键   
                        date: dates.date,   
                        hours: dates.hours,   
                        minutes: dates.minutes,   
                        seconds : dates.seconds 
               }  
				
			}
  });
     
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
       		url : "selfController/doAskLeave.ajax",
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