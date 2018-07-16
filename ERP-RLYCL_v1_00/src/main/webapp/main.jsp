<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>new poject</title>
</head>
<body>
<h1>main Jsp</h1>
<ul>
	<ol><a href="admin.jsp">验证admin</a></ol>
	<ol ><a href="user.jsp">验证user</a></ol>
	<ol><a href="logout">退出登陆</a></ol>
	<ol><a href="userController/getUserInfo.do">验证注解</a></ol>
</ul>
</body>
</html>