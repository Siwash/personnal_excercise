/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.17
 * Generated at: 2018-04-29 05:46:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
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

      out.write('\n');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>欢迎进入本系统</title>\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("\tcontent=\"width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi\" />\n");
      out.write("<link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/xadmin.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/cutsom-style.css\">\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"x-body\">\n");
      out.write("\t\t<blockquote class=\"layui-elem-quote\">欢迎进入企业资产管理系统！v1.0；登录时间：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${LOGINTIME }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("；</blockquote>\n");
      out.write("\t\t<fieldset class=\"layui-elem-field\">\n");
      out.write("\t\t\t<legend>信息总览</legend>\n");
      out.write("\t\t\t<div class=\"layui-field-box\">\n");
      out.write("\t\t\t\t<table class=\"layui-table\">\n");
      out.write("\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<th colspan=\"2\" scope=\"col\">您的账户信息</th>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<th width=\"30%\">您的账号</th>\n");
      out.write("\t\t\t\t\t\t\t<td><span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.accountNumber }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>您的姓名</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>您的登录时间</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${LOGINTIME }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>您的浏览器信息</td>\n");
      out.write("\t\t\t\t\t\t\t<td id=\"browserVersion\"></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>您的IP地址</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userIp }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t</table>\n");
      out.write("\t\t\t\t<table class=\"layui-table\">\n");
      out.write("\t\t\t\t\t<thead>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<th colspan=\"2\" scope=\"col\">服务器信息</th>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</thead>\n");
      out.write("\t\t\t\t\t<tbody>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<th width=\"30%\">本系统访问路径</th>\n");
      out.write("\t\t\t\t\t\t\t<td><span id=\"lbServerName\">");
      out.print(basePath );
      out.write("</span></td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>服务器名称</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${serverName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>服务器ip地址</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${localIp }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr class=\"spanLinkTr\">\n");
      out.write("\t\t\t\t\t\t\t<td>当前在线人数</td>\n");
      out.write("\t\t\t\t\t\t\t<td><span id=\"sasd\">加载中...</span>&nbsp; <span id=\"ronBtn\" onclick=\"reOnlineNum()\" class=\"spanLink\">点击刷新</span>\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td>登录超时时间</td>\n");
      out.write("\t\t\t\t\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${timeout }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("秒</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t<tr class=\"spanLinkTr\">\n");
      out.write("\t\t\t\t\t\t\t<td>服务器当前时间</td>\n");
      out.write("\t\t\t\t\t\t\t<td><span id=\"st\">加载中...</span>&nbsp; <span id=\"rstBtn\"\n");
      out.write("\t\t\t\t\t\t\t\tonclick=\"reServerTime()\" class=\"spanLink\">点击刷新</span>\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</tbody>\n");
      out.write("\t\t\t\t</table>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</fieldset>\n");
      out.write("\t\t<!-- 示例：调用父窗口的某个方法 -->\n");
      out.write("\t\t<blockquote class=\"layui-elem-quote layui-quote-nm\">\n");
      out.write("\t\t\t本系统前端框架支持：X-admin（<a\n");
      out.write("\t\t\t\tonclick=\"parent.x_admin_show('X-admin主页','http://x.xuebingsi.com/')\">http://x.xuebingsi.com/</a>）；\n");
      out.write("\t\t\t前端框架整合：舒松（ss112476@163.com）； 项目开发：企业资产管理系统（<a\n");
      out.write("\t\t\t\tonclick=\"parent.x_admin_show('企业资产管理系统主页','http://localhost:8080/00.07_AssetsManagementSystem/indexController/entryIndex.do')\">http://localhost:8080/00.07_AssetsManagementSystem/indexController/entryIndex.do</a>）java\n");
      out.write("\t\t\tEE项目组\n");
      out.write("\t\t</blockquote>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t//页面初始化方法\n");
      out.write("\tfunction showBrowserVersion() {\n");
      out.write("\t\tvar userAgent = window.navigator.userAgent;\n");
      out.write("\t\t$(\"#browserVersion\").text(userAgent);\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tfunction reServerTime() {\n");
      out.write("\t\t$(\"#rstBtn\").attr(\"disabled\", \"disabled\");\n");
      out.write("\t\t$(\"#rstBtn\").css(\"display\", \"none\");\n");
      out.write("\t\t//执行获取服务器时间的方法……\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t\ttype:\"POST\",\n");
      out.write("\t\t\turl:\"indexController/getServerTime.ajax\",\n");
      out.write("\t\t\tdata:{\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tdataType:\"text\",\n");
      out.write("\t\t\tsuccess:function(result){\n");
      out.write("\t\t\t\t$(\"#st\").text(result);\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\terror:function(){\n");
      out.write("\t\t\t\t$(\"#st\").text(\"获取失败\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\t//回弹按钮\n");
      out.write("\t\tsetTimeout(\"popRstBtn()\", 5000);\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tfunction popRstBtn() {\n");
      out.write("\t\t$(\"#rstBtn\").removeAttr(\"disabled\");\n");
      out.write("\t\t$(\"#rstBtn\").css(\"display\", \"inline\");\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tfunction reOnlineNum() {\n");
      out.write("\t\t$(\"#ronBtn\").attr(\"disabled\", \"disabled\");\n");
      out.write("\t\t$(\"#ronBtn\").css(\"display\", \"none\");\n");
      out.write("\t\t//执行获取在线人数的方法……\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t\ttype:\"POST\",\n");
      out.write("\t\t\turl:\"indexController/OnlineNum.ajax\",\n");
      out.write("\t\t\tdata:{\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\tdataType:\"text\",\n");
      out.write("\t\t\tsuccess:function(ifo){\n");
      out.write("\t\t\t\t$(\"#sasd\").text(ifo);\n");
      out.write("\t\t\t},\n");
      out.write("\t\t\terror:function(){\n");
      out.write("\t\t\t\t$(\"#sasd\").text(\"获取失败\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\t//回弹按钮\n");
      out.write("\t\tsetTimeout(\"popRonBtn()\", 1000);\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tfunction popRonBtn() {\n");
      out.write("\t\t$(\"#ronBtn\").removeAttr(\"disabled\");\n");
      out.write("\t\t$(\"#ronBtn\").css(\"display\", \"inline\");\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t$(function() {\n");
      out.write("\t\tshowBrowserVersion();\n");
      out.write("\t\treOnlineNum();\n");
      out.write("\t\treServerTime();\n");
      out.write("\t});\n");
      out.write("</script>\n");
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
}
