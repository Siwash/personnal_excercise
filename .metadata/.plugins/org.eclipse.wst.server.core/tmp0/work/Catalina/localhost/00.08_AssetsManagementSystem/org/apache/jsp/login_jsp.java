/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.17
 * Generated at: 2018-05-22 16:21:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
  }

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
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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

      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\" />\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>企业资产管理系统</title>\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\"/>\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\"/>\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/xadmin.css\">\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"lib/layui/layui.js\"\r\n");
      out.write("\tcharset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/xadmin.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//如果该页面在iframe中出现，那么会自动调用最外层窗口刷新本链接\r\n");
      out.write("\tif (window != top) {\r\n");
      out.write("\t\ttop.location.href = location.href;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"login-bg\">\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"login\" >\r\n");
      out.write("\t\t<div class=\"message\">企业资产管理系统-用户登录</div>\r\n");
      out.write("\t\t<font  id=\"error\" size=\"10\" class=\"text-align:center\" color=\"red\"></font>\r\n");
      out.write("\t\t<div id=\"darkbannerwrap\"></div>\r\n");
      out.write("\t\t<form method=\"post\" class=\"layui-form\">\r\n");
      out.write("\t\t\t<input id=\"username\" placeholder=\"用户名\" type=\"text\"\r\n");
      out.write("\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t<hr class=\"hr15\">\r\n");
      out.write("\t\t\t<input id=\"password\" placeholder=\"密码\" type=\"password\"\r\n");
      out.write("\t\t\t\tclass=\"layui-input\">\r\n");
      out.write("\t\t\t<hr class=\"hr15\">\r\n");
      out.write("\t\t\t<input lay-submit lay-filter=\"login\" style=\"width: 100%;\"\r\n");
      out.write("\t\t\t\ttype=\"button\" value=\"登录\" onclick=\"login()\" />\r\n");
      out.write("\t\t\t<hr class=\"hr20\">\r\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\r\n");
      out.write("    <div class=\"layui-form-item\" pane=\"\">\r\n");
      out.write("    \r\n");
      out.write("      <input type=\"checkbox\" lay-filter=\"filter\"  id=\"memoryuser\" lay-skin=\"primary\" title=\"30天内自动登录\" >\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//进行登录处理\r\n");
      out.write("\tlayui.use(['layer', 'form'], function(){\r\n");
      out.write(" \t var layer = layui.layer\r\n");
      out.write("  \t,form = layui.form;\r\n");
      out.write(" \t var kick=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${kickOut}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\tif(kick==\"YES\"){\r\n");
      out.write("\t\tconsole.log('您已经被踢出，请重新登录！')\r\n");
      out.write("\t\tlayer.msg('您已经被踢出，请重新登录！', {icon: 2});\r\n");
      out.write("\t\t//layer.msg('您已经被踢出，请重新登录！');\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\turl:\"userController/rememberUser.ajax\",\r\n");
      out.write("\t\t\tdata:{\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType:\"text\",\r\n");
      out.write("\t\t\tsuccess:function(ifo){\r\n");
      out.write("\t\t\t\tif(ifo ==\"NOTREMBER\"){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tvar user=eval(\"(\"+ifo+\")\");\r\n");
      out.write("\t\t\t\t\t$(\"#username\").val(user.accountNumber);\r\n");
      out.write("\t\t\t\t\t$(\"#password\").val(user.password);\r\n");
      out.write("\t\t\t\t\t$(\"#memoryuser\").attr(\"checked\",\"checked\");\r\n");
      out.write("\t\t\t\t\tform.render();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror:function(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tform.on('checkbox(filter)', function(data){\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  console.log(data.elem.checked); //复选框value值，也可以通过data.elem.value得到\r\n");
      out.write("\t\t\t  if(data.elem.checked==false){\r\n");
      out.write("\t\t\t\t  $(\"#password\").val(\"\");\r\n");
      out.write("\t\t\t\t  $.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t\t\t\turl:\"userController/outLogin.ajax\",\r\n");
      out.write("\t\t\t\t\t\tdata:{\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tdataType:\"\",\r\n");
      out.write("\t\t\t\t\t\tsuccess:function(result){\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror:function(){\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t\t});  \r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction login() {\t\t\r\n");
      out.write("\t\t\tvar account=$(\"#username\").val();\r\n");
      out.write("\t\t\tvar pwd=$(\"#password\").val();\r\n");
      out.write("\t\t\t var rememberMe=\"NO\";\r\n");
      out.write("\t\t\t\tif($(\"#memoryuser\").prop(\"checked\")){\r\n");
      out.write("\t\t\t\t\trememberMe=\"YES\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(account==\"\"){\r\n");
      out.write("\t\t\t\tlayer.msg('账户不能为空', {icon:2});\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tif(pwd==\"\"){\r\n");
      out.write("\t\t\t\t\tlayer.msg('密码不能为空', {icon: 2});\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\t\t\turl : \"userController/login.ajax\",\r\n");
      out.write("\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\taccount : account,\r\n");
      out.write("\t\t\t\t\t\t\tpwd : pwd,\r\n");
      out.write("\t\t\t\t\t\t\trememberMe:rememberMe\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tdataType:\"text\",\r\n");
      out.write("\t\t\t\t\t\tsuccess:function(result){\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tif(result==\"登陆成功\"){\r\n");
      out.write("\t\t\t\t\t\t\t\twindow.location.href=\"");
      out.print(basePath);
      out.write("userController/toIndex.do\";\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\tlayer.msg(result, {icon: 0});\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror:function(){\r\n");
      out.write("\t\t\t\t\t\t\tlayer.msg('无法连接服务器，请稍后重试', {icon: 2});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#username\").change(function(){\r\n");
      out.write("\t\t\t$(\"#password\").val(\"\");\r\n");
      out.write("\t\t})\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
}
