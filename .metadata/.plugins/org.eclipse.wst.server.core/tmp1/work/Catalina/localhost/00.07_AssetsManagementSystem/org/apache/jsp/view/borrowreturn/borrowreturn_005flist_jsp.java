/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.17
 * Generated at: 2018-04-29 06:28:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.borrowreturn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class borrowreturn_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/SSM-GY/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/00.07_AssetsManagementSystem/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1522309388777L));
    _jspx_dependants.put("jar:file:/D:/SSM-GY/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/00.07_AssetsManagementSystem/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>流动记录</title>\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("\tcontent=\"width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi\" />\n");
      out.write("<link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/xadmin.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/kkpager_orange.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"lib/layui/css/layui.css\">\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"lib/layui/layui.js\" charset=\"utf-8\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/xadmin.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/kkpager.min.js\"></script>\n");
      out.write("<script src=\"");
      out.print(basePath);
      out.write("resources/My97DatePicker/WdatePicker.js\"></script>\n");
      out.write("<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("      <script src=\"https://cdn.staticfile.org/html5shiv/r29/html5.min.js\"></script>\n");
      out.write("      <script src=\"https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/jquery.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath);
      out.write("js/kkpager/jpager.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"");
      out.print(basePath);
      out.write("js/kkpager/jpager.css\">\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"");
      out.print(basePath);
      out.write("view/borrowreturn/listPage.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("        function load() {\n");
      out.write("        \tarrayPage(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageResult.pages}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(',');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageResult.total}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(");\n");
      out.write("        }\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body onload=\"load()\">\n");
      out.write("\t<div class=\"x-nav\">\n");
      out.write("\t\t<span class=\"layui-breadcrumb\"> <a>库存管理</a> <a> <cite>流动记录</cite></a>\n");
      out.write("\t\t</span> <a class=\"layui-btn layui-btn-small\"\n");
      out.write("\t\t\tstyle=\"line-height: 1.6em; margin-top: 3px; float: right\"\n");
      out.write("\t\t\thref=\"propertyController/showBorrowreturn.do\" title=\"刷新\"> <i\n");
      out.write("\t\t\tclass=\"layui-icon\" style=\"line-height: 30px\">ဂ</i></a>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"x-body\">\n");
      out.write("\t\t<div class=\"layui-row\">\n");
      out.write("\t\t\t<form class=\"layui-form layui-col-md12 x-so\" method=\"post\"\n");
      out.write("\t\t\t\taction=\"propertyController/showBorrowreturn.do\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t\t\t<select name=\"propertyName\" id=\"quiz1\" lay-filter=\"myselect\">\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\" selected=\"selected\">请选择资产名字</option>\n");
      out.write("\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t\t\t<select name=\"type\" id=\"quiz2\">\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">请选择型号</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"杭州\">杭州</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"宁波\" disabled=\"\">宁波</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"温州\">温州</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"温州\">台州</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"温州\">绍兴</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"layui-btn\" lay-submit=\"sreach()\"\n");
      out.write("\t\t\t\t\t\t\tlay-filter=\"sreach\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"layui-icon\">&#xe615;</i>\n");
      out.write("\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<xblock> <span class=\"x-right\" style=\"line-height:40px\">共有数据：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${borrowreturnsNum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\t\t\t条</span>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</xblock>\n");
      out.write("\t\t<table class=\"layui-table\">\n");
      out.write("\t\t\t<thead>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th>资产名称</th>\n");
      out.write("\t\t\t\t\t<th>型号</th>\n");
      out.write("\t\t\t\t\t<th>数量</th>\n");
      out.write("\t\t\t\t\t<th>申请人</th>\n");
      out.write("\t\t\t\t\t<th>审核状态</th>\n");
      out.write("\t\t\t\t\t<th>时间</th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</thead>\n");
      out.write("\t\t\t<tbody>\n");
      out.write("\t\t\t\t<!-- 数据示例 -->\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<!-- end 数据示例 -->\n");
      out.write("\t\t\t</tbody>\n");
      out.write("\t\t</table>\n");
      out.write("\t\t<div align=\"center\" id=\"jpager\"></div>\n");
      out.write("\t\t<!-- 分页部分 -->\n");
      out.write("\t\t<!-- <div id=\"kkpager\"></div> -->\n");
      out.write("\t\t<!-- end 分页 -->\n");
      out.write("\t</div>\n");
      out.write("\t<script>\n");
      out.write("\t/* 根据名字查询型号 */\n");
      out.write("\n");
      out.write("\t\t/* $.ajax({\n");
      out.write("\t\t\ttype : \"post\", // 提交方式\n");
      out.write("\t\t\turl : \"applyController/returnPropertyName.ajax\", // 访问路径\n");
      out.write("\t\t\tdataType : \"json\", // 返回值类型，只要不是String 一般都为json\n");
      out.write("\t\t\tdata : {\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tsuccess : function(propertys) // 括号里为返回的数据\n");
      out.write("\t\t\t{\t\n");
      out.write("\t\t\t\tif (propertys !== null) {\n");
      out.write("\t\t\t\t\tvar str = \"\";\n");
      out.write("\t\t\t\t\t$(\"#quiz1\").html(\"\");\n");
      out.write("\t\t\t\t\tstr += \"<option>请选择资产名字</option>\"\n");
      out.write("\t\t\t\t\t$(\"#quiz1\").html(str);\n");
      out.write("\n");
      out.write("\t\t\t\t\tfor (var i = 0; i < propertys.length; i++) {\n");
      out.write("\t\t\t\t\t\tvar property = propertys[i];\n");
      out.write("\t\t\t\t\t\tif (i==1) {\n");
      out.write("\t\t\t\t\t\t\t$(\"#quiz1\").append(\"<option selected='selected'> \" + property.propertyName + \"</option>\");\n");
      out.write("\t\t\t\t\t\t}else {\n");
      out.write("\t\t\t\t\t\t\t$(\"#quiz1\").append(\"<option> \" + property.propertyName + \"</option>\");\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t} else {\n");
      out.write("\t\t\t\t\talert(\"没有申请记录！！\");\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\terror : function(msg) {\n");
      out.write("\t\t\t\talert(\"无法连接服务器\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}); */\n");
      out.write("\t\t\n");
      out.write("\t\tlayui.use(['layer', 'form'], function(){\n");
      out.write("\t\t\t  var layer = layui.layer\n");
      out.write("\t\t\t  ,form = layui.form;\n");
      out.write("\t\t\t  form.on('select(myselect)', function(data){\n");
      out.write("\t\t\t\t var propertyName=$(\"#quiz1\").val();\n");
      out.write("\t\t\t  $.ajax({\n");
      out.write("\t                 type: 'POST',\n");
      out.write("\t                 url: 'applyController/returnType.do',\n");
      out.write("\t                 data: {\n");
      out.write("\t                \t \"propertyName\" : propertyName\n");
      out.write("\t                 },\n");
      out.write("\t                 dataType:  'json',\n");
      out.write("\t                 success: function(allproperty){\n");
      out.write("\t                \t\tvar str = \"\";\n");
      out.write("\t    \t\t\t\t\t$(\"#quiz2\").empty();\n");
      out.write("\t    \t\t\t\t\tstr += \"<option>请选择型号</option>\"\n");
      out.write("\t    \t\t\t\t\t$(\"#quiz2\").html(str);\n");
      out.write("\n");
      out.write("\t    \t\t\t\t\tfor (var i = 0; i < allproperty.length; i++) {\n");
      out.write("\t    \t\t\t\t\t\tvar property = allproperty[i];\n");
      out.write("\t    \t\t\t\t\t\t$(\"#quiz2\").append(\"<option >\" + property.type + \"</option>\");\n");
      out.write("\t    \t\t\t\t\t\tform.render('select');\n");
      out.write("\t    \t\t\t\t\t\t $(\"#quiz2\").get(0).selectedIndex=0;\n");
      out.write("\t    \t\t\t\t\t}\n");
      out.write("\t                 },\n");
      out.write("\t                 error : function(msg) {\n");
      out.write("\t\t    \t\t\t\talert(\"无法连接服务器\");\n");
      out.write("\t\t    \t\t\t}   \n");
      out.write("\t         }); \n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t\t /*  $(\"#quiz1\").change(function(){  \n");
      out.write("\t        \tvar propertyName=$(\"#quiz1\").val();\n");
      out.write("\t    \t\t\n");
      out.write("\t    \t\t$.ajax({\n");
      out.write("\t    \t\t\ttype : \"post\", // 提交方式\n");
      out.write("\t    \t\t\turl : \"applyController/returnType.do\", // 访问路径\n");
      out.write("\t    \t\t\tdataType : \"json\", // 返回值类型，只要不是String 一般都为json\n");
      out.write("\t    \t\t\tdata : {\n");
      out.write("\t    \t\t\t\t// 后台方法的参数\n");
      out.write("\t    \t\t\t\t\"propertyName\" : propertyName\n");
      out.write("\n");
      out.write("\t    \t\t\t},\n");
      out.write("\t    \t\t\tsuccess : function(propertys) // 括号里为返回的数据\n");
      out.write("\t    \t\t\t{\n");
      out.write("\t    \t\t\t\talert(propertys);\n");
      out.write("\t    \t\t\t\tvar allproperty = $.extend(true, [], propertys);\n");
      out.write("\t    \t\t\t\tif (allproperty !== null) {\n");
      out.write("\t    \t\t\t\t\tvar str = \"\";\n");
      out.write("\t    \t\t\t\t\t$(\"#quiz2\").empty();\n");
      out.write("\t    \t\t\t\t\tstr += \"<option>请选择型号</option>\"\n");
      out.write("\t    \t\t\t\t\t$(\"#quiz2\").html(str);\n");
      out.write("\n");
      out.write("\t    \t\t\t\t\tfor (var i = 0; i < allproperty.length; i++) {\n");
      out.write("\t    \t\t\t\t\t\tvar property = allproperty[i];\n");
      out.write("\t    \t\t\t\t\t\t$(\"#quiz2\").append(\"<option>\" + property.type + \"</option>\");\n");
      out.write("\t    \t\t\t\t\t}\n");
      out.write("\t    \t\t\t\t} else {\n");
      out.write("\t    \t\t\t\t\talert(\"没有该资产！！\");\n");
      out.write("\t    \t\t\t\t}\n");
      out.write("\t    \t\t\t},\n");
      out.write("\t    \t\t\terror : function(msg) {\n");
      out.write("\t    \t\t\t\talert(\"无法连接服务器\");\n");
      out.write("\t    \t\t\t}\n");
      out.write("\t    \t\t});\n");
      out.write("\t    \t\t\n");
      out.write("\t\t  }); */\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t/* $(function(){  \n");
      out.write("        //触发的下拉框chang事件  \n");
      out.write("      \n");
      out.write("        }); */\n");
      out.write("\t\n");
      out.write("\t/* \tfunction doNest() {\n");
      out.write("\t\t\n");
      out.write("\t} */\n");
      out.write("\t\t/*用户-控制*/\n");
      out.write("\t\tfunction member_stop(obj,applyId) {\n");
      out.write("\t\t\tlayer.confirm('确认要批准该申请吗？', function(index) {\n");
      out.write("\t\t\t\tif ($(obj).attr('title') == '启用') {\n");
      out.write("\t\t\t\t\t//发异步把用户状态进行更改\n");
      out.write("\t\t\t\t\t$(obj).attr('title', '未批准')\n");
      out.write("\t\t\t\t\t$(obj).find('i').html('&#xe626;');\n");
      out.write("\t\t\t\t\t$(obj).parents(\"tr\").find(\".td-status\").find('span')\n");
      out.write("\t\t\t\t\t\t\t.addClass('layui-btn-disabled').html('未批准');\n");
      out.write("\t\t\t\t\tlayer.msg('申请失败!', {\n");
      out.write("\t\t\t\t\t\ticon : 1,\n");
      out.write("\t\t\t\t\t\ttime : 500\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t\ttype:\"post\",\n");
      out.write("\t\t\t\t\t\turl:\"applyController/updateStateDo.ajax\",\n");
      out.write("\t\t\t\t\t\tdata:{\n");
      out.write("\t\t\t\t\t\t\tapplyId:applyId\n");
      out.write("\t\t\t\t\t\t},\n");
      out.write("\t\t\t\t\t\tdatatype:\"text\",\n");
      out.write("\t\t\t\t\t\tsuccess:function(result){\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t},\n");
      out.write("\t\t\t\t\t\terror:function(){\n");
      out.write("\t\t\t\t\t\t\talert(\"无法连接服务器\");\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t} else {\n");
      out.write("\t\t\t\t\t$(obj).attr('title', '启用')\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t\ttype:\"post\",\n");
      out.write("\t\t\t\t\t\turl:\"applyController/updateState.ajax\",\n");
      out.write("\t\t\t\t\t\tdata:{\n");
      out.write("\t\t\t\t\t\t\tapplyId:applyId\n");
      out.write("\t\t\t\t\t\t},\n");
      out.write("\t\t\t\t\t\tdatatype:\"text\",\n");
      out.write("\t\t\t\t\t\tsuccess:function(result){\n");
      out.write("\t\t\t\t\t\t\tif(result==\"库存不足\"){\n");
      out.write("\t\t\t\t\t\t\t\t$(obj).parents(\"tr\").find(\".td-status\").find('span')\n");
      out.write("\t\t\t\t\t\t\t\t.addClass('layui-btn-disabled').html('未批准');\n");
      out.write("\t\t\t\t\t\t\t\tlayer.msg('库存不够，启用失败!', {\n");
      out.write("\t\t\t\t\t\t\t\t\ticon : 1,\n");
      out.write("\t\t\t\t\t\t\t\t\ttime : 500\n");
      out.write("\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t}else {\n");
      out.write("\t\t\t\t\t\t\t\t$(obj).find('i').html('&#xe627;');\n");
      out.write("\t\t\t\t\t\t\t\t$(obj).parents(\"tr\").find(\".td-status\").find('span')\n");
      out.write("\t\t\t\t\t\t\t\t.removeClass('layui-btn-disabled').html('已启用');\n");
      out.write("\t\t\t\t\t\t\t\tlayer.msg('申请成功!', {\n");
      out.write("\t\t\t\t\t\t\t\t\ticon : 1,\n");
      out.write("\t\t\t\t\t\t\t\t\ttime : 500\n");
      out.write("\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t},\n");
      out.write("\t\t\t\t\t\terror:function(){\n");
      out.write("\t\t\t\t\t\t\talert(\"无法连接服务器\");\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t}\n");
      out.write("\n");
      out.write("\t\t\t});\n");
      out.write("\t\t} \n");
      out.write("\n");
      out.write("\t\t/*用户-删除*/\n");
      out.write("\t\tfunction member_del(obj, applyId) {\n");
      out.write("\t\t\tlayer.confirm('确认要删除吗？', function(index) {\n");
      out.write("\t\t\t\t//发异步删除数据\n");
      out.write("\t\t\t\tlayer.msg('已删除!', {\n");
      out.write("\t\t\t\t\ticon : 1,\n");
      out.write("\t\t\t\t\ttime : 500\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t\twindow.location.href = \"applyController/deleteApply.do?applyId=\"+applyId+\"\";\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /view/borrowreturn/borrowreturn_list.jsp(69,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/view/borrowreturn/borrowreturn_list.jsp(69,7) '${propertyList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${propertyList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /view/borrowreturn/borrowreturn_list.jsp(69,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("por");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.propertyName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.propertyName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /view/borrowreturn/borrowreturn_list.jsp(111,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/view/borrowreturn/borrowreturn_list.jsp(111,5) '${pageResult.dataList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageResult.dataList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /view/borrowreturn/borrowreturn_list.jsp(111,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("por");
    // /view/borrowreturn/borrowreturn_list.jsp(111,5) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVarStatus("index");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t<tr>\n");
          out.write("\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.propertyName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.type }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.propertyNum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t<td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t\t<td><span class=\"layui-btn layui-btn-normal layui-btn-mini\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.borrowreturnState }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</span></td>\n");
          out.write("\t\t\t\t\t\t\t<td>");
          if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
            return true;
          out.write("</td>\n");
          out.write("\t\t\t\t\t\t</tr>\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_005fformatDate_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
    // /view/borrowreturn/borrowreturn_list.jsp(119,11) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.borrowreturnTime }", java.util.Date.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
    // /view/borrowreturn/borrowreturn_list.jsp(119,11) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_fmt_005fformatDate_005f0.setPattern("yyyy-MM-dd ");
    int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
    if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
    return false;
  }
}
