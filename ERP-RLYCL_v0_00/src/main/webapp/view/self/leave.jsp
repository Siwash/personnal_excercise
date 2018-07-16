<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>添加用户</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="css/font.css">
<link rel="stylesheet" href="css/xadmin.css">
<script type="text/javascript"
	src="js/jquery.min.js"></script>
<script type="text/javascript" src="lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
	<div class="x-body">
	<xblock>
        
        <button class="layui-btn" onclick="x_admin_show('日志编辑','view/self/LeaveEdit.jsp')"><i class="layui-icon"></i>填写今日</button>
        <span class="x-right" style="line-height:40px" id="total">共有数据：88 条</span>
      </xblock>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>历史记录</legend>
</fieldset>  
 
<table class="layui-table" >
  
  <thead >
    <tr>
      <th>开始时间</th>
      <th>终止时间</th>
      <th>请假理由</th>
      <th>状态</th>
      <th>操作</th>
    </tr> 
  </thead>
  <tbody id="record">
    
  </tbody>
</table> 
<div id="test1" style="text-align:center"></div>
</div>
</body>
<script type="text/javascript">
var total=0;
layui.use('laypage', function(){
  var laypage = layui.laypage;
  showPage(0);
  $("#total").text("共有数据： "+total+"条");
  //执行一个laypage实例
  laypage.render({
	  elem: 'test1'
	  ,count: total //数据总数，从服务端得到
	  ,jump: function(obj, first){
	    //obj包含了当前分页的所有参数，比如：
	    console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
	    console.log(obj.limit); //得到每页显示的条数
	    
	    //首次不执行
	    if(!first){
	    	showPage(obj.curr);
	    }
	  }
	});
});

function showPage(n) {
	$.ajax({
		type : "POST",
		async:false,
		data : {
			pageIndex : n,
			flushData:total==0? 'flush':null
		},
		dataType : "text",
		url : "selfController/showAskLeave.ajax",
		success : function(result) {
			console.log(result);
			var tl = eval("(" + result + ")");
			total=tl.total;
			$("#record").html("");
			//json遍历
			if(tl.data.length>0){
				$.each(tl.data, function(n,val){
					console.log(n);
					var str="";
				    str+="<tr>";
				    str+="<td>"+new Date(val.startTime).format("yyyy-MM-dd hh:mm")+"</td>"
				    str+="<td>"+new Date(val.endingTime).format("yyyy-MM-dd hh:mm")+"</td>"
				    str+="<td>"+val.leaveReason+"</td>"
				    str+="<td>"+val.opinion+"</td>"
				    str+="<td><a class=\"layui-btn layui-btn-normal layui-btn-mini\" onclick=\"x_admin_show('日志预览','selfController/readLeave.do?leaveId="+val.leaveId+"')\" >查看</a></td>"
				    str+="</tr>";
					$("#record").append(str);
				})
			}else{
				$("#record").append("<tr><td colspan=5 align=\"center\">暂时没有您的数据哦，快去添加一条吧</td></tr>");
			}
			
		},
		error : function() {
			layer.msg('无法连接服务器', {icon: 2});
		}
	});
}
</script>
</html>