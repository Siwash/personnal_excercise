<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ "/" + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<html>

<head>
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="js/jquery.min.js"></script>
<script type="text/javascript" src="./lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
      <%-- 分页相关 --%>
    
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript" src="<%=basePath%>view/product/listPage2.js"></script>
<script type="text/javascript">
        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>
</head>

<body  onload="load()">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">仓库</a>
			<a> <cite>产品库存统计管理</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so layui-form-pane">
				<div class="layui-input-inline">
					
				</div>



				
				
			</form>
		</div>

		<div class="queryProduct_title">
		
	
			<h4>产品出入库记录</h4>
			
		</div>
		<span class="x-right" style="line-height: 40px">共有数据:${productTurnoverList.size()}条</span> </xblock>
         <table class="layui-table" id="normal">
			<thead>
				<tr>

					<th>产品ID</th>
					<th>产品出入库数量</th>
					<th>产品出入库时间</th>
					<th>负责人编号</th>
					<th>出入库状态</th>
			</thead>
			<tbody>
				<c:forEach items="${pageResult.dataList}" var="ProductTurnover">
					<tr>
						<td>${ProductTurnover.productId}</td>
						<td>${ProductTurnover.productNumber}</td>
						<td><fmt:formatDate value="${ProductTurnover.inventoryTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${ProductTurnover.emeId}</td>
						<td>${ProductTurnover.type}</td>



					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="jpager"></div>
		

	</div>
	<script>
	<%--  	function queryStore() {
			alert(111);

			var productId = "";
			//if ($("#productId1").prop("selected")) {
			productId = $("#productId1 option:selected").val();
			//}
			alert(productId);
			$.ajax({

				type : "POST",
				url : "StorehouseController/querySomeProduct.ajax",
				data : {

					productId : productId
				},
				dataType : "text",
				success : function(result) {

					var pInventory = eval("(" + result + ")");

					var demo = "";
					demo += "<table>";
					demo += "<thead>";
					demo += "<tr>";
					demo += "<th>库存ID</th>";
					demo += "<th>产品ID</th>";
				
					demo += "<th>库存数量</th>";
					demo += "</thead>";

					demo += "<tr>";
					demo += "<th>" +pInventory.pInventoryId + "</th>";
					demo += "<th>" + pInventory.productId + "</th>";
					
					demo += "<th>" + pInventory.inventoryNumber + "</th>";
 
					demo += "</tr>";
					demo += "</table>";
					$("#normal").html(demo);

				},
				error : function() {

				}
			});

		}--%>

		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});

			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});
		});-->

		/*用户-停用*/
		function member_stop(obj, id) {
			layer.confirm('确认要停用吗？', function(index) {

				if ($(obj).attr('title') == '启用') {

					//发异步把用户状态进行更改
					$(obj).attr('title', '停用')
					$(obj).find('i').html('&#xe62f;');

					$(obj).parents("tr").find(".td-status").find('span')
							.addClass('layui-btn-disabled').html('已停用');
					layer.msg('已停用!', {
						icon : 5,
						time : 1000
					});

				} else {
					$(obj).attr('title', '启用')
					$(obj).find('i').html('&#xe601;');

					$(obj).parents("tr").find(".td-status").find('span')
							.removeClass('layui-btn-disabled').html('已启用');
					layer.msg('已启用!', {
						icon : 5,
						time : 1000
					});
				}

			});
		}

		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		}

		function delAll(argument) {

			var data = tableCheck.getData();

			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			});
		}
	</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>

</html>