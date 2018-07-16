<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://shiro.apache.org/tags"  prefix="shiro"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>青阳ERP管理系统</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<link rel="stylesheet" href="css/cutsom-style.css">
<script type="text/javascript"
	src="js/jquery.min.js"></script>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>

</head>
<body>
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="index.jsp">青阳·ERP管理系统</a>
		</div>
		<div class="left_open">
			<i title="展开左侧栏" class="iconfont">&#xe699;</i>
		</div>
		<ul class="layui-nav left fast-add" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">+下拉菜单</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a onclick="x_admin_show('资讯','http://www.baidu.com')"><i
							class="iconfont">&#xe6a2;</i>模拟窗口A</a>
					</dd>
					<dd>
						<a onclick="x_admin_show('图片','http://www.baidu.com')"><i
							class="iconfont">&#xe6a8;</i>模拟窗口B</a>
					</dd>
					<dd>
						<a onclick="x_admin_show('用户','http://www.baidu.com')"><i
							class="iconfont">&#xe6b8;</i>模拟窗口C</a>
					</dd>
				</dl></li>
		</ul>
		<ul class="layui-nav right">
			<li class="layui-nav-item"><a href="javascript:;">管理员名称</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人中心</a>
					</dd>
					<dd>
						<a href="login.jsp">退出登录</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item to-index"><a href="index.jsp">系统首页</a></li>
		</ul>

	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">

				<!-- 示例：这是一个下拉菜单 -->
				<li><a href="javascript:;"> <img src="images/member.png"
						class="left-menu-icon"> <cite>人员管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<!-- 这是一个普通按钮 -->
						<li><a _href="view/member/member-list.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>用户管理</cite>
						</a></li>
						<!-- 按钮结束 -->
						<shiro:hasRole name="admin">
						<li><a _href="view/organization/organization-list.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>组织结构</cite>
						</a></li>
						</shiro:hasRole>
						<shiro:hasRole name="user">
						<li><a _href="view/department/department-list.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>部门管理</cite>
						</a></li>
						</shiro:hasRole>
						
						
					</ul></li>
				<!-- 这组下拉菜单结束 -->

				<!-- 这是另一组菜单示例 -->
				<li><a href="javascript:;"> <img src="images/authority.png"
						class="left-menu-icon"> <cite>权限管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a _href="#"> <i class="iconfont">&#xe6a7;</i> <cite>权限信息</cite>
						</a></li>
						<li><a _href="#"> <i class="iconfont">&#xe6a7;</i> <cite>角色设置</cite>
						</a></li>
						<li><a _href="#"> <i class="iconfont">&#xe6a7;</i> <cite>角色分配</cite>
						</a></li>
					</ul></li>
				<!-- 示例结束 -->

			</ul>
		</div>
	</div>

	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<!-- 打开的标签页，无需手动添加 -->
			<ul class="layui-tab-title">
				<li>欢迎进入本系统</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='welcome.jsp' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
			<!-- 标签页结束 -->
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright">青阳龙野 ©2017 前端：x-admin v2.3
			后端：华清远见成都中心-java EE项目</div>
	</div>
	<!-- 底部结束 -->
</body>
</html>