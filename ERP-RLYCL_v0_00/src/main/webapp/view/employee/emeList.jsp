<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<title>欢迎页面-X-admin2.0</title>
 
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
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
<script type="text/javascript" src="<%=basePath%>view/employee/listPage.js"></script>
    <script type="text/javascript">
        function load() {
        	arrayPage(${pageResult.pages},${pageResult.total});
        }
</script>
    <body onload="load()">
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="<%=basePath%>index.jsp">首页</a>
        <a>
          <cite>导航元素</cite></a>
      </span>

    </div>
    <div class="x-body">
   
      <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加用户','<%=basePath%>personnelController/addUI.do')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">你好，小宝宝</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <!--  <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>-->
       
        <th>.</th>
		<td>姓名</td>
		<td>性别</td>
		<td>身份证号</td>
		<td>职务</td>
		<td>所属部门</td>
		<td colspan="2">操作</td>
        </thead>
       
	<c:forEach items="${pageResult.dataList}" var="employee">
				<tr>
					<td>.</td>
					<td>${employee.emeName }</td>
					<td>${employee.sex }</td>
					<td>${employee.idNum }</td>
					<td>${employee.jobTitle }</td>
					<td>${employee.department }</td>
					<td><a
						href="<%=basePath%>personnelController/delete.do?emeId=${employee.emeId }">删除</a></td>
					<td><a
						href="<%=basePath%>personnelController/updateUI.do?emeId=${employee.emeId }">修改</a></td>
				</tr>
			</c:forEach>
     
      </table>
      <div id="jpager"></div>
    </div> 
  
  </body>

</html>