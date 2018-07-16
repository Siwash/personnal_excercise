<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<meta  content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<p>111</p>
</body>
<script src="lib/layer.js"></script>
<script type="text/javascript">
layer.open({
	  type: 2 //此处以iframe举例
	  ,title: '当你选择该窗体时，即会在最顶端'
	  ,area: ['390px', '330px']
	  ,shade: 0
	  ,offset: [ //为了演示，随机坐标
	    Math.random()*($(window).height()-300)
	    ,Math.random()*($(window).width()-390)
	  ]
	  ,maxmin: true
	  ,content: 'settop.html'
	  ,btn: ['继续弹出', '全部关闭'] //只是为了演示
	  ,yes: function(){
	    $(that).click(); //此处只是为了演示，实际使用可以剔除
	  }
	  ,btn2: function(){
	    layer.closeAll();
	  }
</script>
</html>