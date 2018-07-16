<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
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
		<span class="layui-breadcrumb"> <a>人员管理</a> <a> <cite>用户管理</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" action="sysMemberController/sreachMember.do">
				<span>快速查询：</span> <input class="layui-input" placeholder="请输入工号"
					name="usernumber" id="MemberNum" value="${usernumber }"> <input type="text"
					name="username" placeholder="请输入姓名" autocomplete="off"
					class="layui-input" id="MemberName" value="${username }">
				<button type="submit" class="layui-btn">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn"
			onclick="x_admin_show('添加用户','view/member/member-add.jsp',500,500)">
			<i class="layui-icon">&#xe608;</i>添加
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：<span
			id="listSize"></span> 条
		</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>账号</th>
					<th>姓名</th>
					<th>工号</th>
					<th>电话</th>
					<th>E-mail</th>
					<th>公司职位</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
		<!-- 分页部分 -->
		<div id="kkpagerbox">
			<div id='kkpager'></div>
		</div>
		<!-- end 分页 -->

	</div>
	<script>
		/*用户-停用&启用*/
		function member_stop(id) {

		}

		/*用户-删除*/
		function member_del(id) {
			layer.confirm('确认要删除该用户吗？', function(id) {
				//发异步删除数据
				layer.msg('已删除!', {
					icon : 1,
					time : 500
				});
			});
		}
		
		/*初始化分页插件*/
		function initKkpager(total, totalRecords) {
			//对容器初始化
			var kkpagerSetting={
					pno : '1',
					mode : 'click', //设置为click模式
					//总页码  
					total : String(total),
					//总数据条数  
					totalRecords : String(totalRecords),
					//点击页码、页码输入框跳转、以及首页、下一页等按钮都会调用click
					//适用于不刷新页面，比如ajax
					click : function(n) {
						//这里可以做自已的处理
						getMemberPage(n);
						//处理完后可以手动条用selectPage进行页码选中切换
						this.selectPage(n);
					},
					//getHref是在click模式下链接算法，一般不需要配置，默认代码如下
					getHref : function(n) {
						return '#';
					}

				};
			kkpager.generPageHtml(kkpagerSetting);//使用心得json数据初始化分页插件
		}

		function getMemberPage(n) {
			var MemberNum = $("#MemberNum").val();
			var MemberName = $("#MemberName").val();
			$.ajax({
				type : 'POST',
				dataType : 'text',
				data : {
					pno : n,
					MemberNum : MemberNum,
					MemberName : MemberName
				},
				url : 'sysMemberController/initMemberPage.ajax',
				success : function(result) {
					var memberJson = eval("(" + result + ")");
					var memberinfos = memberJson.memberinfos;
					$("#listSize").text(memberJson.totalRecords);//显示总条数
					showMemberPage(memberinfos);//生成列表
					initKkpager(memberJson.total, memberJson.totalRecords);//初始化分页插件
				},
				error : function() {

				}
			});
		}

		$(function() {
			getMemberPage(1);
		});

		//用于生成列表的
		function showMemberPage(memberinfos) {
			$("#tbody").html("");
			$
					.each(
							memberinfos,
							function(n, value) {
								var row = "<tr><td>"
										+ value.memberinfoLoginid
										+ "</td><td>"
										+ value.memberinfoName
										+ "</td><td>"
										+ value.memberinfoNumber
										+ "</td><td>"
										+ value.memberinfoPhone
										+ "</td><td>"
										+ value.memberinfoEmail
										+ "</td><td>"
										+ value.memberinfoPosition
										+ "</td>"
										+ "<td>"
										+ value.memberinfoState
										+ "</td>"
										+ "<td class='td-manage'><a onclick=''"
										+ "title='启用/停用'> <i class='layui-icon'>&#xe601;</i>"
										+ "</a> <a title='显示详细信息'"
										+ "onclick=''"
										+ "> <i class='layui-icon'>&#xe642;</i>"
										+ "</a> <a onclick=''"
										+ "title='修改用户信息'> <i class='layui-icon'>&#xe631;</i>"
										+ "</a> <a title='删除' onclick=''"
										+ "> <i class='layui-icon'>&#xe640;</i>"
										+ "</a></td></tr>"
								$("#tbody").append(row);
							});
		}
	</script>
</body>
</html>