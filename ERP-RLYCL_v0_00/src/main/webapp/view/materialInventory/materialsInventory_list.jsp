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
		<span class="layui-breadcrumb"> <a>仓库管理</a> <a> <cite>材料库存管理</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		</div>
		<span class="x-right" style="line-height: 20px;font-size:20px" >共有数据:${EACHNUM }条&nbsp;&nbsp;&nbsp;</span>
		<table class="layui-table">
			<thead>
				<tr>
					<th>材料ID</th>
					<th>材料型号</th>
					<th>材料库存数量</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody id="normal">
				<c:forEach items="${materList }" var="ml">
					<!-- 数据示例 -->
					<tr>
						<td>${ml.materialId }</td>
						<td><c:forEach items="${materialList}" var="mater">
								<c:if test="${ml.materialId==mater.materialId }">
							${mater.materialName }
								</c:if>
							</c:forEach></td>
						<td>${ml.repertoryNum }</td>
						<td>${ml.status }</td>
						<td class="td-manage">
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
		var i="${sessionScope.totolDatas}";
		var j="${sessionScope.totolPages}";
		$(function(){
			if(i==null|i==""){
				window.location.href="<%=basePath%>MaterialsInventoryListController/initKKpager.do"
			};
			kkpager.generPageHtml({
				pno:'1',//当前页面
				mode:'click',
				total:j,//总页码
				totalRecords:i,//总数据条数
				click : function(n) {
					//这里可以做自已的处理
					showPage(n);
					//处理完后可以手动条用selectPage进行页码选中切换
					this.selectPage(n);
				},
				getHref:function(n){
					return '#';
				}
			});
			showPage(1);
		});
		
		
		
		
		function showPage(n){
			$.ajax({
				type:"POST",
				url:"MaterialsInventoryListController/showPage.ajax",
				data:{
					n:n
				},
				dataType:"text",
				success:function(result){
					console.log(result);
					var mypage=eval("("+result+")");
					$("#normal").html("");
					$.each(mypage,function(n,val){
						$("#normal").append(
								"<tr><td>"+val.materialId+"</td><td>"+val.materialName+"</td><td>"+val.repertoryNum+"</td><td>"+val.status+"</td></tr>"
						)
					});
				},
				error:function(){
					
				}
				
			});
		}
	</script>
</body>
</html>