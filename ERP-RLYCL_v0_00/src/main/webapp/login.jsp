<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>RLCLY·ERP管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="js/jquery.min.js"></script>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<script type="text/javascript">
	//如果该页面在iframe中出现，那么会自动调用最外层窗口刷新本链接
	if (window != top) {
		top.location.href = location.href;
	}
</script>

</head>
<body class="login-bg">

	<div class="login">
		<div class="message">RLCLY·ERP管理系统-用户登录</div>
		<div id="darkbannerwrap"></div>

		<form method="post" class="layui-form">
			<input id="username" placeholder="用户名" type="text"
				class="layui-input">
			<hr class="hr15">
			<input id="password" placeholder="密码" type="password"
				class="layui-input">
			<hr class="hr15">
			<input lay-submit lay-filter="login" style="width: 100%;"
				type="button" value="登录" onclick="dologin()" />
			<hr class="hr20">
		</form>
		<input type="checkbox" id="memoryuser" onchange="changeRemberMe()">&nbsp;30天内自动登录
	</div>

	<script>
		//进行登录处理
		function dologin() {
			var account=$("#username").val();
			var pwd=$("#password").val();
			var check=$("#memoryuser").prop("checked");
			if(account==""){
				layer.msg('账户不能为空', {icon:2});
			}else{
				if(pwd==""){
					layer.msg('密码不能为空', {icon: 2});
				}else{
					$.ajax({
						type:"POST",
						url:"userController/doLogin.ajax",
						data:{
							account:account,
							pwd:pwd,
							rememberMe:check
						},
						dataType:"text",
						success:function(result){
							layer.msg(result, {icon: 0})
							if(result=="登陆成功"){
								window.location.href="<%=basePath%>userController/toZone.do";
							}
						},
						error:function(){
							layer.msg('无法连接服务器，请稍后重试', {icon: 2});
						}
					});
				}
				
			}
			
		}
		function checkRememberMe(){
			//var check=$("#memoryuser").prop("checked");
			
				$.ajax({
					type:"POST",
					url:"userController/checkRembMe.ajax",
					data:{
						
					},
					dataType:"text",
					success:function(result){
						var rememberMe=eval("(" + result + ")");
						if((rememberMe.userAccount).length>1){
							$("#username").val(rememberMe.userAccount);
							$("#password").val(rememberMe.userPwd);
							var check=$("#memoryuser").prop("checked",true);
						}
						
					},
					erro:function(){
						
					}
					
				})
			
		}
		function changeRemberMe(){
			var check=$("#memoryuser").prop("checked")
			if(!check){
				$.ajax({
					type:"POST",
					url:"userController/cancelRememberMe.ajax",
					data:{
						
					},
					dataType:"text",
					success:function(result){
							$("#password").val("");	
					},
					erro:function(){
						
					}
					
				})
			}
		}
		
		$(function() {
			checkRememberMe();
			$("#username").change(function(){
				$("#password").val("");
			})
		});
	</script>
</body>
</html>