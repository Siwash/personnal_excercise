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
  <base href="<%=basePath%>" />
    <meta charset="UTF-8">
    <title>采购申请</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <link rel="stylesheet"
	href="<%=basePath%>resources/bootstrap/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->

    <script src="<%=basePath%>resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>resources/My97DatePicker/WdatePicker.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <font color="red">${requisitionError}</font>
  
  <body>
    <div class="x-body">
    <div>
        <form class="layui-form"  action="<%=basePath%>StorehouseController/purchaseRequisition.do" method="post">
        <div>
          <div class="layui-form-item">
              <label for="materialId" class="layui-form-label">
                  <span class="x-red">*</span>元器件名称
              </label>
              <div class="layui-input-inline">
                 <select class="form-control input-sm" id="productId1">
						<option>------请选择元器件名称------</option>
						<c:forEach items="${materialsList}" var="materialsList">
							<option value="${materialsList.materialId}">${materialsList.materialName}</option>
						</c:forEach>
					</select>
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>请选择元器件名称
              </div>
          </div>
          <div class="layui-form-item">
              <label for="emeId" class="layui-form-label">
                  <span class="x-red">*</span>操作人编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="emeId" name="emeId" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>请输入操作人编号
              </div>
          </div>
          <div class="layui-form-item">
              <label for="materialNum" class="layui-form-label">
                  <span class="x-red">*</span>预采购数量
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="materialNum" name="materialNum" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>请输入预采购数量
              </div>
                </div>
               <div class="layui-form-item">
              <label for="purchaseTime" class="layui-form-label">
                  <span class="x-red">*</span>采购申请时间
              </label>
              <div class="layui-input-inline">
                 <input type="text" name="purchaseTime"
							value="<fmt:formatDate value="${user.brithday}" type="date"/>"
							onClick="
							WdatePicker()" readonly="readonly"
							value="2000-01-01" class="form-control input-sm"
							placeholder="请输入采购申请时间" />
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>请输入采购申请时间
              </div>
          </div>
           
          </div>
         
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <input type="submit" class="btn btn-success" value="保存" /> <input
					type="reset" class="btn  btn-danger" value="取消" />
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
          });
          
          
        });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>