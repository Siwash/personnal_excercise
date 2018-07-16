<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
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
<title>欢迎进入本系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<link rel="stylesheet" href="css/cutsom-style.css">
<script type="text/javascript"
	src="js/jquery.min.js"></script>
</head>
<body>
	<div class="x-body">
		<blockquote class="layui-elem-quote">RLCLY·ERP管理系统！v1.0；登录时间：<fmt:formatDate value="${LOGINDATE }" pattern="yyyy-MM-dd HH:mm:ss"/> </blockquote>
		<fieldset class="layui-elem-field">
			<legend>信息总览</legend>
			<div class="layui-field-box">
				<table class="layui-table">
					<thead>
						<tr>
							<th colspan="2" scope="col">您的个人信息</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th width="30%">您的账号</th>
							<td><span>${user.username}</span></td>
						</tr>
						<tr>
							<td>您的姓名</td>
							<td>${user.emeName}</td>
						</tr>
						<tr>
							<td>您的职务</td>
							<td>${user.jobTitle}</td>
						</tr>
						<tr>
							<td>您的所属部门</td>
							<td >${user.department}</td>
						</tr>
						<tr>
							<td>您的员工编号</td>
							<td>${user.emeNum}</td>
						</tr>
						<tr>
							<td>您的入职时间</td>
							<td><fmt:formatDate value="${user.entryTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  </td>
						</tr>
						<tr>
							<td>您的邮箱</td>
							<td>${user.email}</td>
						</tr>
						<tr>
							<td>您的联系方式</td>
							<td>${user.telNum}</td>
						</tr>
					</tbody>
				
			</div>
		</fieldset>
		<!-- 示例：调用父窗口的某个方法 -->
		<blockquote class="layui-elem-quote layui-quote-nm">
			本系统前端框架支持：X-admin（<a
				onclick="parent.x_admin_show('X-admin主页','http://x.xuebingsi.com/')">http://x.xuebingsi.com/</a>）；
			前端框架整合：RLCLY·； 项目开发：RLCLY
		</blockquote>
	</div>
</body>

</html>