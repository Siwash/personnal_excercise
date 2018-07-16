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
		</form>
		<input type="checkbox" id="memoryuser" onclick="outLogin()">&nbsp;30天内自动登录
	</div>

	<script>
		//进行登录处理
		function login() {
			/*  var ipt = document.getElementById("error").getElementsByTagName(
					"input"); //查找one这个div里的所有文本框
			for (var i = 0; i < ipt.length; i++) { //循环
				if (ipt[i].value.length == 0 || ipt[i].value=="") { //如果其中一个文本框没有填写
					alert("所有文本框都需要填写"); //弹出提示
					ipt[i].focus(); //定位到没有填写的文本框
					return false;
				}
			}  */
			var account = $("#username").val();
			var pwd = $("#password").val();
			 var rememberMe="NO";
			if($("#memoryuser").prop("checked")){
				rememberMe="YES";
			} 
			$.ajax({
				type : "POST",
				url : "userController/checkUser.ajax",
				data : {
					account : account,
					pwd : pwd,
					rememberMe:rememberMe 
				},
				dataType : "text",
				success : function(result) {
					if (result == "SUCCESS") {
						window.location.href = "indexController/entryIndex.do";
					} else if (result == "ACCOUNTERROR") {
						$("#error").text("用户名错误");
					} else if(result == "PWDERROR"){
						$("#error").text("密码错误");
					} else if(result == "ACCOUNTNULL"){
						$("#error").text("用户名不能为空");
					}else {
						$("#error").text("密码不能为空");
					}	
				},
				error : function() {
					alert("无法连接服务器，请稍后重试");
				}
			});
		}
		
	$(function(){
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
				}
			},
			error:function(){
				
			}
		});
	})
	
	function outLogin(){
		if($("#memoryuser").prop("checked")){
			
		}else{
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
		
	}
	</script>
	
	
</body>
</html>
