<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<title>Kkpager快速开始</title>
<link rel="stylesheet" href="<%=basePath%>CSS/kkpager_blue.css">
<link rel="stylesheet" href="<%=basePath%>CSS/bootstrap.min.css">
</head>
<body>
	<h2>kkpager</h2>

	<div class="container">
		<table class="table table-hover table-bordered table table-condensed">
			<thead>
				<tr>
					<th width="100">id</th>
					<th width="200">name</th>
					<th width="100">sex</th>
					<th width="100">age</th>
				</tr>
			</thead>
			<tbody id="tbox">
				<tr>
					<td>1</td>
					<td>喜洋洋</td>
					<td>公</td>
					<td>公</td>
				</tr>
				<tr>
					<td>2</td>
					<td>美羊羊</td>
					<td>公</td>
					<td>公</td>
				</tr>
				<tr>
					<td>3</td>
					<td>小金刚</td>
					<td>男</td>
					<td>男</td>
				</tr>
			</tbody>
		</table>
		<div id="kkpager"></div>
		<div class="panel panel-default">
			<div class="panel-heading">添加随机people数据</div>
			<div class="panel-body">
				<form action="<%=basePath%>/kkpagerController/addp.do" method="post">
					个数： <input name="number" class="input"> <input class="btn-sm btn btn-primary" type="submit" value="确定">
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">设置每页显示数据条数</div>
			<div class="panel-body">
					条数： <input name="number" class="input" id="PageData"> 
					<input class="btn-sm btn btn-primary" type="button" id="PageDataBtn" value="确定">
					<a id="dataInfo" class="text-danger"></a>
	
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">设置总页数</div>
			<div class="panel-body">
					<a  class="text-danger"> 总数据：  ${totalData}</a>
					总页数： <input id="totalPage" class="input"> <input class="btn-sm btn btn-primary" type="button" id="totalBtn" value="确定">
					<a id="totalInfo" class="text-danger"></a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager.min.js"></script>
<script >
var i="${sessionScope.totalData}";
var j="${sessionScope.totalPage}";
var k="${sessionScope.PageData}";
$(function() {
	
	if(i==null|i==""){
		window.location="<%=basePath%>/kkpagerController/init.do?Method=PD";
	};
	kkpager.generPageHtml({
		pno : '1',
		mode : 'click', //设置为click模式
		//总页码  
		total : j,
		//总数据条数  
		totalRecords : i,
		//点击页码、页码输入框跳转、以及首页、下一页等按钮都会调用click
		//适用于不刷新页面，比如ajax
		click : function(n) {
			//这里可以做自已的处理
			showPage(n);
			//处理完后可以手动条用selectPage进行页码选中切换
			this.selectPage(n);
		},
		//getHref是在click模式下链接算法，一般不需要配置，默认代码如下
		getHref : function(n) {
			return '#';
		}
	});
	showPage(1);
	$("#totalBtn").click(function(){
		var totalPage=$("#totalPage").val();
		if(totalPage==""){
			$("#totalInfo").text("输入不合法");
		}else{
			window.location="<%=basePath%>/kkpagerController/init.do?total="+totalPage+"&Method=TP"
		}
	})
	$("#PageDataBtn").click(function(){
		var PageData=$("#PageData").val();
		if(totalPage==""){
			$("#dataInfo").text("输入不合法");
		}else{
			window.location="<%=basePath%>/kkpagerController/init.do?PageData="+PageData+"&Method=PD"
		}
	})
});

	function showPage(n) {
		$.ajax({
			type : "POST",
			data : {
				n : n,
			},
			dataType : "text",
			url : "<%=basePath%>kkpagerController/showPage.ajax",
			success : function(result) {
				console.log(result);
				var tl = eval("(" + result + ")");
				$("#tbox").html("");
				//json遍历
				$.each(tl, function(n,val) {
					console.log(n);
					$("#tbox").append(
							"<tr><td>" + val.id + "</td><td>" + val.name
									+ "</td><td>" + val.sex + "</td><td>" + val.age + "</td></tr>");
				});
			},
			error : function() {

			}
		});
	}
</script>
</html>
