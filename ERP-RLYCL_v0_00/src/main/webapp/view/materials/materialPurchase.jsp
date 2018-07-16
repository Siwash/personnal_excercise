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
<title>物流管理</title>
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
    
    
      <%-- 分页相关 --%>
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript" src="<%=basePath%>view/materials/listPage.js"></script>
<script type="text/javascript">
        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>
</head>

<body onload="load()">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a>仓库管理</a> <a> <cite>物流管理页面</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
		<h3>物流管理列表</h3>
		</div>
		
		<span class="x-right" style="line-height: 40px">共有数据:${materialPurchaseList.size()}条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>物流货物ID</th>
					<th>负责人编号</th>
					<th>物流编号</th>
					<th>物流货物价格</th>
					<th>物流货物数量</th>
					<th>货物下单时间</th>
				</tr>
			</thead>
			<tbody id="normal">
			<c:forEach items="${pageResult.dataList}" var="materialPurchase">
				<!-- 数据示例 -->
				<tr>
					<td>${materialPurchase.materialId}</td>
					<td>${materialPurchase.emeId}</td>
					<td>${materialPurchase.trackingNumber}</td>
					<td>${materialPurchase.purchasePrice}</td>
					<td>${materialPurchase.materialNum}</td>
					<td><fmt:formatDate value="${materialPurchase.purchaseTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					
				</tr>
				</c:forEach>
				<!-- end 数据示例 -->
			</tbody>
		</table>
		<!-- 分页部分 -->
		<div id="jpager"></div>
		<!-- end 分页 -->

	</div>
	<script>
	
	<%--	function search(){
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
						demo+="<td><a onclick='x_admin_show('添加订单','purchaseController/productPurchaseMaterialsList.do?materialId=${ml.materialId }')'>采购</a></td>";
						demo+="</tr>";
					}
					$("#normal").html(demo);
					
				},
				error:function(){
					
				}
			});
		}--%>

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
		
		/*分页控件设置*/
		kkpager.generPageHtml({
			//当前页数
			pno : '1',
			mode : 'link', //可选，默认就是link
			//总页码  
			total : '1',
			//总数据条数  
			totalRecords : '1',
			//链接前部  
			hrefFormer : 'view/member/member-list.jsp',
			//链接尾部  
			hrefLatter : '?pno=',
			//链接算法
			getLink : function(n) {
				return this.hrefFormer + this.hrefLatter + n;
			}

		});
	</script>
</body>
</html>