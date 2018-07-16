<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>欢迎页面-X-admin2.0</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script src="lib/layui/layui.js"></script>
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
</head>

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a>
			<a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" 
			>
				
				<div class="layui-input-inline">
            		<select id="status">
             			 <option selected>审批状态</option>
              			 <option value="1">已同意</option>
              			 <option value="2">不同意</option>
              			 <option value="3">未审批</option>
            		</select>
          		</div>
          	<button class="layui-btn" type="button" onclick="search()">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<span class="x-right" style="line-height: 40px;font-size:20px">共有数据：${LEAVENUM } 条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>请假单号</th>
					<th>请假员工</th>
					<th>开始时间</th>
					<th>截止时间</th>
					<th>请假事由</th>
					<th>意见</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="normal">
				<c:forEach items="${leaveList }" var="ll">
					<tr>

						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='2'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td>${ll.leaveId }</td>
						<td>登录测试员</td>
						<td><fmt:formatDate value="${ll.startTime }"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${ll.endingTime }"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${ll.leaveReason }</td>
						<td class="td-status"><span
							class="layui-btn layui-btn-normal layui-btn-mini" >${ll.opinion }</span></td>
						<td class="td-manage"><a onclick="member('${ll.leaveId }')" title="审批"> <i
								class="layui-icon">&#xe601;</i>
						</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page">
			<div>
				<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a> <span
					class="current">2</span> <a class="num" href="">3</a> <a
					class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
			</div>
		</div>

	</div>
	<script>
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
		});

		/*用户-请假*/
		function member(leaveId) {

			layer.msg('是否同意员工请假请求？', {
				time : 20000, //20s后自动关闭
				btn : [ '同意', '不同意', '取消' ],
				yes : function() {
					$.ajax({
						type : "POST",
						data : {
							leaveId : leaveId
						},
						dataType : "text",
						url : "leaveAskController/agreeLeave.ajax",
						success : function(result) {
							window.location.href="leaveAskController/listLeave.do";
						},
						error : function() {

						}

					});
				},
				btn2 : function() {
					$.ajax({
						type : "POST",
						data : {
							leaveId : leaveId
						},
						dataType : "text",
						url : "leaveAskController/refuseLeave.ajax",
						success : function() {
							window.location.href="leaveAskController/listLeave.do";
						},
						error : function() {

						}

					});
				},
				btn3 : function() {
					 layer.closeAll();
				}
			});

		}
		
		function search(){
			var selectvalue=$("#status  option:selected").text();
			$.ajax({
				type:"POST",
				url:"leaveAskController/queryOpinion.ajax",
				data:{
					opinion:selectvalue
				},
				dataType:"text",
				success:function(result){
					var xxx=eval("("+result+")");
					var demo="";
					for ( var x in xxx) {
						demo+="<tr>";
						demo+="<th><div class='layui-unselect layui-form-checkbox' lay-skin='primary' data-id='2'><i class='layui-icon'>&#xe605;</i></div></td>";
						demo+="<th>"+xxx[x].leaveId+"</th>";
						demo+="<th>登录测试员</th>";
						demo+="<th>"+new Date(xxx[x].startTime).format("yyyy年MM月dd日hh小时mm分ss秒")+"</th>";
						demo+="<th>"+new Date(xxx[x].endingTime).format("yyyy年MM月dd日hh小时mm分ss秒")+"</th>";
						demo+="<th>"+xxx[x].leaveReason+"</th>";
						demo+="<th>"+xxx[x].opinion+"</th>";
						demo+="<td><a onclick='member(\""+xxx[x].leaveId+"\")' title='审批'><i class='layui-icon'>&#xe601;</i></a></td>";
						demo+="</tr>";
					}
					$("#normal").html(demo);
					console.log(JSON.stringify(demo));
					
				},
				error:function(){
					
				}
				
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
	<script type="text/javascript">
	Date.prototype.format = function(format){
		 /*
		 * eg:format="YYYY-MM-dd hh:mm:ss";
		 */
		 var o = {
		 "M+" : this.getMonth()+1, //month
		 "d+" : this.getDate(),   //day
		 "h+" : this.getHours(),  //hour
		   "m+" : this.getMinutes(), //minute
		   "s+" : this.getSeconds(), //second
		   "q+" : Math.floor((this.getMonth()+3)/3),
		   "S" : this.getMilliseconds() //millisecond
		  }
		  
		  if(/(y+)/.test(format)) {
		  format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
		  }
		  
		  for(var k in o) {
		  if(new RegExp("("+ k +")").test(format)) {
		   format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
		  }
		  }
		 return format;
		}
	
		</script>
		


</body>
</html>