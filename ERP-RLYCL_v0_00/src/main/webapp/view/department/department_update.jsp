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
<title>采购清单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form  method="POST">
          <input id="one" type="hidden" name="depId" value="${dm.depId }">
          <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  部门名称
              </label>
              <div class="layui-input-inline" >
                  <input id="two" type="text"  name="depName" value="${dm.depName }" 
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  部门经理
              </label>
              <div class="layui-input-inline">
                  <input id="three" type="text"  name="emeId" value="${dm.emeId }" 
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                 部门描述
              </label>
              <div class="layui-input-inline">
                  <input id="four" type=text"  name="descriptional" value="${dm.descriptional }"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  type="button" class="layui-btn" onclick="myajaxsubmit()"  >
                  提交修改
              </button>
          </div>
      </form>
    </div>
    <script>
    	function myajaxsubmit(){
    		var depName=$("#two").val();
    		console.log(depName);
    		var emeId=$("#three").val();
    		var descriptional=$("#four").val();
    		var depId=$("#one").val();
    		$.ajax({
    			type:"POST",
    			data:{
    				depName:depName,
    				emeId:emeId,
    				descriptional:descriptional,
    				depId:depId
    			},
    			url:"departmentsController/update.ajax",
    			dataType:"text",
    			success:function(result){
    				
    				if(result=="YES"){
    					layer.alert("修改成功", {icon : 6}, function() {
    						// 获得frame索引
    						var index = parent.layer.getFrameIndex(window.name);
    						//关闭当前frame
    						parent.layer.close(index);
    						parent.location.href="departmentsController/listDepartments.do";
    					});
    					
    					
    			}else{
    				layer.alert("修改失败", {icon : 6}, function() {
						// 获得frame索引
						var index = parent.layer.getFrameIndex(window.name);
						//关闭当前frame
						parent.layer.close(index);
						parent.location.href="departmentsController/listDepartments.do";
					});
    				}
    			},
    			
    			error:function(XMLHttpRequest, textStatus, errorThrown){
    				// 状态码
                    console.log(XMLHttpRequest.status);
    			}
    			
    		});
    	}
          
    </script>
  </body>

</html>