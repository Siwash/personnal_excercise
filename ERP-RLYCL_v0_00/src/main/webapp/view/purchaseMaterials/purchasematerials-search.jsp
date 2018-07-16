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
		<span class="layui-breadcrumb"> <a>采购管理</a> <a> <cite>材料清单</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:refresh();" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<span>快速查询：</span>
				<input id="name" class="layui-input" placeholder="请输入材料型号" name="materialName">
				<input id="type" type="text" name="materialType" placeholder="请输入材料类型"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" type="button" onclick="search()">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn"
			onclick="">
			<i class="layui-icon">&#xe608;</i>添加
		</button>
		<span class="x-right" style="line-height: 40px;font-size:20px">
		共有数据:${sessionScope.totolDatas }条&nbsp;&nbsp;&nbsp;</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>材料ID</th>
					<th>材料型号</th>
					<th>材料类型</th>
					<th>材料价格</th>
					<th>材料描述</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="normal">
			<c:forEach items="${mlList }" var="ml">
				<!-- 数据示例 -->
				<tr>
					<td>${ml.materialId }</td>
					<td>${ml.materialName }</td>
					<td>${ml.materialType }</td>
					<td>${ml.materialPrice }</td>
					<td>${ml.materialDescribe }</td>
					<td class="td-manage">
					<a onclick="x_admin_show('添加订单','purchaseController/productPurchaseMaterialsList.do?materialId=${ml.materialId }')">采购</a>
					</td>
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
	
		function search(){
			var materialName=$("#name").val();
			var materialType=$("#type").val()
			$.ajax({
				type:"POST",
				data:{
					materialName:materialName,
					materialType:materialType
				},
				dataType:"text",
				url:"purchaseController/selectMaterialNameAndType.ajax",
				success:function(result){
					var mlist=eval("("+result+")");
					var demo="";
					for(var x in mlist){
						
						demo+="<tr>";
						demo+="<th>"+mlist[x].materialId+"</th>";
						demo+="<th>"+mlist[x].materialName+"</th>";
						demo+="<th>"+mlist[x].materialType+"</th>";
						demo+="<th>"+mlist[x].materialPrice+"</th>";
						demo+="<th>"+mlist[x].materialDescribe+"</th>";
						demo+="<td><a onclick='x_admin_show('添加订单','purchaseController/productPurchaseMaterialsList.do?materialId="+mlist[x].materialId+"')'>采购</a></td>";
						demo+="</tr>";
					}
					$("#normal").html(demo);
					
				},
				error:function(){
					
				}
			});
		}

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
		
		
		function refresh(){
			location.replace(location.href);
		}
	</script>
</body>
</html>