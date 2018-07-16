<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>申请审批</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<link rel="stylesheet" href="css/kkpager_orange.css">
<link rel="stylesheet" href="lib/layui/css/layui.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript" src="js/xadmin.js"></script>

<script src="<%=basePath%>resources/My97DatePicker/WdatePicker.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<%-- 分页相关 --%>
<script type="text/javascript" src="<%=basePath%>view/apply/listPage.js"></script>
<script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>js/kkpager/jpager.css">
<script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">

        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>

</head>

<body onload="load()">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a>流程管理</a> <a> <cite>申请批准</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="applyController/showAllapply.do" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" method="post"
				action="applyController/showAllapply.do">

				<div class="layui-input-inline">
					<select name="propertyName" id="quiz1" lay-filter="myselect">
						<option value="" selected="selected">请选择资产名字</option>
						<c:forEach items="${propertyList}" var="por">
							<option value="${por.propertyName }">${por.propertyName }</option>
						</c:forEach>
					</select>

				</div>
				<div class="layui-input-inline">
					<select name="type" id="quiz2" lay-filter="filter">
						<option value="">请选择型号</option>
						<option value="杭州">杭州</option>
						<option value="宁波" disabled="">宁波</option>
						<option value="温州">温州</option>
						<option value="温州">台州</option>
						<option value="温州">绍兴</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<button type="submit" class="layui-btn" lay-submit="sreach()"
						lay-filter="sreach">
						<i class="layui-icon">&#xe615;</i>
					</button>
				</div>

			</form>
		</div>

		<xblock> <span class="x-right" style="line-height: 40px">共有数据：${applysNum }
			条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>资产名称</th>
					<th>型号</th>
					<th>数量</th>
					<th>申请人</th>
					<th>审核状态</th>
					<th>申请时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<!-- 数据示例 -->
				<tr>
					<c:forEach items="${pageResult.dataList}" var="por"
						varStatus="index">
						<tr>
							<td>${por.propertyName }</td>
							<td>${por.type }</td>
							<td>${por.propertyNum }</td>
							<td>${por.userName }</td>
							<td class="td-status"><span
								<c:if test="${por.applyState == '同意'}">
						class="layui-btn layui-btn-normal layui-btn-mini"
						</c:if>
								<c:if test="${por.applyState == '审核中'}">
						class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled"
						</c:if>
								<c:if test="${por.applyState == '使用完'}">
						class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled"
						</c:if>>
									<c:if test="${por.applyState == '同意'}">
						已启用
						</c:if> <c:if test="${por.applyState == '审核中'}">
						未批准
						</c:if> <c:if test="${por.applyState == '使用完'}">
						使用完
						</c:if>
							</span></td>
							<td><fmt:formatDate value="${por.applyTime }"
									pattern="yyyy-MM-dd " /></td>

							<td class="td-manage"><c:if test="${por.applyState == '同意'}">
									<a class="layui-btn layui-btn-mini"
										onclick="member_stop(this,'${por.applyId}'
								  )"
										href="javascript:;"
										<c:if test="${por.applyState == '同意'}">
						title="启用"
						</c:if>
										<c:if test="${por.applyState == '审核中'}">
						 title="未批准"
						</c:if>>
										<c:if test="${por.applyState == '同意'}">
											<i class="layui-icon">&#xe627;</i>停用
									</c:if> <c:if test="${por.applyState == '审核中'}">
											<i class="layui-icon">&#xe626;</i>启动
									</c:if>
									</a>

								</c:if> <c:if test="${por.applyState == '审核中'}">
									<a class="layui-btn layui-btn-mini"
										onclick="member_stop(this,'${por.applyId}'
								  )"
										href="javascript:;"
										<c:if test="${por.applyState == '同意'}">
						title="启用"
						</c:if>
										<c:if test="${por.applyState == '审核中'}">
						 title="未批准"
						</c:if>>
										<c:if test="${por.applyState == '同意'}">
											<i class="layui-icon">&#xe627;</i>不同意
									</c:if> <c:if test="${por.applyState == '审核中'}">
											<i class="layui-icon">&#xe626;</i>同意
									</c:if>
									</a>

								</c:if> <a title="删除"
								class="layui-btn  layui-btn-mini layui-btn-danger"
								onclick="member_del(this,'${por.applyId}')" href="javascript:;">
									<i class="layui-icon">&#xe640;</i>删除
							</a></td>

						</tr>
					</c:forEach>

					<!-- end 数据示例 -->
			</tbody>
		</table>
		<div align="center" id="jpager"></div>
		<!-- 分页部分 -->
		<!-- <div id="kkpager"></div> -->
		<!-- end 分页 -->
	</div>
	<script type="text/javascript">
	
		layui.use(['layer', 'form'], function(){
			  var layer = layui.layer
			  ,form = layui.form;
			
			  form.on('select(filter)', function(data){
				  console.log(data.elem); //得到select原始DOM对象
				  console.log(data.value); //得到被选中的值
				  console.log(data.othis); //得到美化后的DOM对象
				});  
			  form.on('select(myselect)', function(data){
				  
				 var propertyName=$("#quiz1").val();
			  $.ajax({
	                 type: 'POST',
	                 url: 'applyController/returnType.do',
	                 data: {
	                	 "propertyName" : propertyName
	                 },
	                 dataType:  'json',
	                 success: function(allproperty){
	                		var str = "";
	    					$("#quiz2").empty();
	    					str += "<option>请选择型号</option>"
	    					$("#quiz2").html(str);

	    					for (var i = 0; i < allproperty.length; i++) {
	    						var property = allproperty[i];
	    						$("#quiz2").append("<option >" + property.type + "</option>");
	    						form.render('select');
	    						 $("#quiz2").get(0).selectedIndex=0;
	    					}
	                 },
	                 error : function(msg) {
		    				alert("无法连接服务器");
		    			}   
	         }); 
	});
	
		});
		
		
	</script>
</body>
</html>