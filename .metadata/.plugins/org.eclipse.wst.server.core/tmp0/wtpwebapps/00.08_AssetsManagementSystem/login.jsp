<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>企业资产管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<script type="text/javascript"
	src="js/jquery.min.js"></script>
<script type="text/javascript" src="lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<script type="text/javascript">
	//如果该页面在iframe中出现，那么会自动调用最外层窗口刷新本链接
	if (window != top) {
		top.location.href = location.href;
	}
</script>

</head>
<body class="login-bg">

	<div class="login" >
		<div class="message">企业资产管理系统-用户登录</div>
		<font  id="error" size="10" class="text-align:center" color="red"></font>
		<div id="darkbannerwrap"></div>
		<form method="post" class="layui-form">
			<input id="username" placeholder="用户名" type="text"
				class="layui-input">
			<hr class="hr15">
			<input id="password" placeholder="密码" type="password"
				class="layui-input">
			<hr class="hr15">
			<input lay-submit lay-filter="login" style="width: 100%;"
				type="button" value="登录" onclick="login()" />
			<hr class="hr20">
			<div class="layui-form-item">
    <div class="layui-form-item" pane="">
    
      <input type="checkbox" lay-filter="filter"  id="memoryuser" lay-skin="primary" title="30天内自动登录" >
    
  </div>
		</form>
	</div>

	<script>
		//进行登录处理
	layui.use(['layer', 'form'], function(){
 	 var layer = layui.layer
  	,form = layui.form;
 	 var kick="${kickOut}";
	if(kick=="YES"){
		console.log('您已经被踢出，请重新登录！')
		layer.msg('您已经被踢出，请重新登录！', {icon: 2});
		//layer.msg('您已经被踢出，请重新登录！');
		};
		$.ajax({
			type:"POST",
			url:"userController/rememberUser.ajax",
			data:{
				
			},
			dataType:"text",
			success:function(ifo){
				if(ifo =="NOTREMBER"){
					
				}else{
					var user=eval("("+ifo+")");
					$("#username").val(user.accountNumber);
					$("#password").val(user.password);
					$("#memoryuser").attr("checked","checked");
					form.render();
				}
			},
			error:function(){
				
			}
		});
		
		form.on('checkbox(filter)', function(data){
			  
			  console.log(data.elem.checked); //复选框value值，也可以通过data.elem.value得到
			  if(data.elem.checked==false){
				  $("#password").val("");
				  $.ajax({
						type:"POST",
						url:"userController/outLogin.ajax",
						data:{
							
						},
						dataType:"",
						success:function(result){
							
						},
						error:function(){
							
						}
						
					});
			  }
			});  
	});
	
		
		function login() {		
			var account=$("#username").val();
			var pwd=$("#password").val();
			 var rememberMe="NO";
				if($("#memoryuser").prop("checked")){
					rememberMe="YES";
			}
			if(account==""){
				layer.msg('账户不能为空', {icon:2});
			}else{
				if(pwd==""){
					layer.msg('密码不能为空', {icon: 2});
				}else{
					$.ajax({
						type : "POST",
						url : "userController/login.ajax",
						data : {
							account : account,
							pwd : pwd,
							rememberMe:rememberMe
						},
						dataType:"text",
						success:function(result){
							
							if(result=="登陆成功"){
								window.location.href="<%=basePath%>userController/toIndex.do";
							}else{
								layer.msg(result, {icon: 0});
							}
						},
						error:function(){
							layer.msg('无法连接服务器，请稍后重试', {icon: 2});
						}
					});
				}
				
			}
					
		}
		
	$(function(){
		$("#username").change(function(){
			$("#password").val("");
		})	
		
	})
	
	</script>
	
	
</body>
</html>
