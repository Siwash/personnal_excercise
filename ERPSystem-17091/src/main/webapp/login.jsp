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
<base href="<%=basePath %>">
<meta charset="UTF-8">
<title>青阳ERP管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
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
		<div class="message">青阳ERP管理系统-用户登录</div>
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
		<input type="checkbox" onclick="cancelUserStatus()" id="memoryuser">&nbsp;30天内自动登录
	</div>

	<script>
		//进行登录处理
		function dologin() {
			var account = $("#username").val();
			var pwd = $("#password").val();
			var rememberMe = "No";
			if ($("#memoryuser").prop("checked")) {
				rememberMe = "Yes";
			}
			$.ajax({
				type : "POST",
				url : "sysUserController/checkLogin.ajax",
				data : {
					account : account,
					pwd : pwd,
					rememberMe : rememberMe
				},
				dataType : "text",
				success : function(result) {
					if (result == "PRIMITLOGIN") {
						window.location.href = "indexController/entryIndex.do";
					} else if (result == "PWDERROR") {
						alert("密码错误，请重新输入");
					} else if (result == "USERNOTFOUND") {
						alert("用户不存在，请检查");
					} else {
						alert("用户名不合法，请检查");
					}
				},
				error : function() {
					alert("无法连接服务器，请稍后重试");
				}
			});
		}

		$(function() {
			$.ajax({
				type : "POST",
				url : "sysUserController/getLoginStatus.ajax",
				dataType : "text",
				data : {

				},
				success : function(result) {
					console.log(result);
					if (result == "NOTREMBER") {

					} else {
						var loginstatus = eval("(" + result + ")");
						$("#memoryuser").attr("checked", "checked");
						$("#username").val(loginstatus.account);
						$("#password").val(loginstatus.pwd);
					}
				},
				error : function() {

				}
			});
		});

		function cancelUserStatus() {
			if ($("#memoryuser").prop("checked")) {

			} else {
				$.ajax({
					type : "POST",
					url : "sysUserController/cancelUserStatus.ajax",
					dataType : "text",
					data : {

					},
					success : function(result) {

					},
					error : function() {

					}
				});
			}
		}
	</script>
</body>
</html>