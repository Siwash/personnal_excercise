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
<title>添加员工页面</title>
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
        <form class="layui-form" method="POST" action="personnelController/add.do">
          <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  员工姓名
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="emeName" 
                  autocomplete="off" class="layui-input">
              </div>
              
               <label for="L_email" class="layui-form-label">
               性别
               </label>
              <div  class="layui-input-inline">
                <input type="radio" name="sex"  title="男"  value="男" >
                <input type="radio" name="sex"  title="女"  value="女" >
              </div>
           </div>
              
           <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  入职时间
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  id="start" name="entryTimeStr" 
                  autocomplete="off" class="layui-input">
                 
              </div>
              
              <label for="L_email" class="layui-form-label">
                  身份证号码
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="idNum" 
                  autocomplete="off" class="layui-input">
              </div>
              </div>
         
              
              
              
           <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  学历
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="eduction" 
                  autocomplete="off" class="layui-input">
              </div>
               <label for="L_email" class="layui-form-label">
                  编号
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="emeNum" 
                  autocomplete="off" class="layui-input">
              </div>
           </div>
           
                
                
                  
           <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  电话
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="telNum" 
                  autocomplete="off" class="layui-input">
              </div>
               <label for="L_email" class="layui-form-label">
                  电子邮件
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="email" 
                  autocomplete="off" class="layui-input">
              </div>
           </div>
          
                
              
           <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  职位
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="jobTitle" 
                  autocomplete="off" class="layui-input">
              </div>
               <label for="L_email" class="layui-form-label">
                  部门
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="department" 
                  autocomplete="off" class="layui-input">
              </div>
            </div>
         
              
              
              
              
         <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  籍贯
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="origin" 
                  autocomplete="off" class="layui-input">
              </div>
              <label for="L_email" class="layui-form-label">
                  现住址
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="address" 
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          
        
        
        
          <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  描述
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="description" 
                  autocomplete="off" class="layui-input">
              </div>
              <label for="L_email" class="layui-form-label">
                  登录名
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="username" 
                  autocomplete="off" class="layui-input">
              </div>
           </div>
         
         
         
          
           <div class="layui-form-item" >
              <label for="L_email" class="layui-form-label">
                  密码
              </label>
              <div class="layui-input-inline" >
                  <input type="text"  name="password" 
                  autocomplete="off" class="layui-input">
              </div>
          </div>
       
        
          <div class="layui-form-item">
				<label class="layui-form-label"> </label>
				<button class="layui-btn" type="submit" lay-submit="">
					增加</button>
					
		</div>
      </form>
    </div>
    <script>
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
          
    </script>
  </body>

</html>