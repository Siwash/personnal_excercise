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
        <form class="layui-form" method="POST" action="purchaseController/addPurchaseList.do">
        <input type="hidden" name="materialId" value="${mr.materialId }">
          <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  材料型号
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="materialName" value="${mr.materialName }" readonly="readonly"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  材料价格
              </label>
              <div class="layui-input-inline">
                  <input type="text"  name="materialPrice" value="${mr.materialPrice }" readonly="readonly"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                 进货数量
              </label>
              <div class="layui-input-inline">
                  <input type="number" min="0" name="materialNum" 
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                 物流编号
              </label>
              <div class="layui-input-inline">
                  <input type="number" min="0" name="trackingNumber"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label"> 
               采购人员
              </label>
              <div class="layui-input-inline">
                  <input type="text"  name="emeName" value="${em.emeName }" readonly="readonly"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
       <div class="layui-form-item">
              <label class="layui-form-label"><span class="x-red"></span>人员审批</label>
              <div class="layui-input-block">
                <input type="radio" name="like" lay-skin="primary" title="部门经理审批" value="1" >
                <input type="radio" name="like" lay-skin="primary" title="老总审批" value="0">
                <input type="radio" name="like" lay-skin="primary" title="拒绝审批通过" value="-1">
              </div>
          </div>
        	<font color="red">${CaiGouFailed }</font>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  type="submit" class="layui-btn"  >
                  提交订单
              </button>
          </div>
      </form>
    </div>
    <script>
    	
          
    </script>
  </body>

</html>