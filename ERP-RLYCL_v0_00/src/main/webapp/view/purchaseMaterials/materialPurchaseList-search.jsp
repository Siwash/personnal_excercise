<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>用户管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<link rel="stylesheet" href="css/kkpager_orange.css">
<script type="text/javascript"
	src="js/jquery.min.js"></script>
<script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<script type="text/javascript" src="js/kkpager.min.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a>采购管理</a> <a> <cite>采购单管理</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" action="purchaseController/query.do" method="POST" >
				<span>快速查询：</span>
				<input id="name" class="layui-input" placeholder="请输入物流编号" name="trackingNumber">
				<input id="type" type="text" name="emeName" placeholder="请输入采购人员"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" type="submit" >
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<span id="mynum" class="x-right" style="line-height: 40px;font-size:20px">共有数据:${sessionScope.TDATAS }条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>物流编号</th>
					<th>材料ID</th>
					<th>材料型号</th>
					<th>采购数量</th>
					<th>采购总价</th>
					<th>采购时间</th>
					<th>采购人员</th>
					<th>采购意见</th>
				</tr>
			</thead>
			<tbody id="normal">
			<c:forEach items="${miList }" var="mi">
				<!-- 数据示例 -->
				<tr>
					<td>${mi.trackingNumber }</td>
					<td>${mi.materialId }</td>
					<td><c:forEach items="${materialList }" var="ma">
						<c:if test="${mi.materialId==ma.materialId }">
						${ma.materialName }
						</c:if>
					</c:forEach></td>
					<td>${mi.materialNum }</td>
					<td>${mi.purchasePrice }</td>
					<td><fmt:formatDate value="${mi.purchaseTime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${e.emeName }</td>
					<td>${mi.opinion }</td>
				</tr>
				</c:forEach>
				<!-- end 数据示例 -->
			</tbody>
		</table>
		<!-- 分页部分 -->
		<div id="kkpager"></div>
		<!-- end 分页 -->

	</div>
	<script>
	

		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				layer.msg('已删除!', {
					icon : 1,
					time : 500
				});
			});
		}
		
		
	</script>
</body>
</html>