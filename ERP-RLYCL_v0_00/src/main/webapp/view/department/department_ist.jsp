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
		<span class="layui-breadcrumb"> <a>部门管理</a> <a> <cite>部门列表</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:refresh();" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
		<button class="layui-btn"
			onclick="window.location.href='view/department/department_add.jsp'">
			<i class="layui-icon">&#xe608;</i>添加
		</button>
		<span class="x-right" style="line-height: 40px;font-size:20px">共有数据:${DPNUM }条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>部门名称</th>
					<th>部门经理</th>
					<th>部门描述</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="normal">
			<c:forEach items="${dpList }" var="dp">
				<!-- 数据示例 -->
				<tr>
					<td>${dp.depName }</td>
					<td>${dp.emeId }</td>
					<td>${dp.descriptional }</td>
					<td class="td-manage">
				<a title="修改"  onclick="x_admin_show('修改信息','departmentsController/updateUI.do?depId=${dp.depId }')" >
                <i class="layui-icon">&#xe642;</i></a>
                <a onclick="mydelete('${dp.depId }')" title="删除">
                <i class="layui-icon">&#xe640;</i>
              </a>
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
		function mydelete(depId) {
			layer.msg('是否删除本部门？', {
				time : 20000, //20s后自动关闭
				btn : [ '删除', '取消' ],
				yes : function() {
					$.ajax({
						type : "POST",
						data : {
							depId : depId
						},
						dataType : "text",
						url : "departmentsController/delete.ajax",
						success : function(result) {
							window.location.href="departmentsController/listDepartments.do";
						},
						error : function() {

						}

					});
				},
				btn2 : function() {
					 layer.closeAll();
				}
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
		
		function refresh(){
			location.replace(location.href);
		}
	</script>
</body>
</html>