/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.17
 * Generated at: 2018-04-29 05:46:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>企业资产管理系统</title>\n");
      out.write("<meta name=\"renderer\" content=\"webkit|ie-comp|ie-stand\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("\tcontent=\"width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi\" />\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-siteapp\" />\n");
      out.write("\n");
      out.write("<link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/xadmin.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/cutsom-style.css\">\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<script src=\"lib/layui/layui.js\" charset=\"utf-8\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/xadmin.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<!-- 顶部开始 -->\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"logo\">\n");
      out.write("\t\t\t<a href=\"index.jsp\">企业资产管理系统</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"left_open\">\n");
      out.write("\t\t\t<i title=\"展开左侧栏\" class=\"iconfont\">&#xe699;</i>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<ul class=\"layui-nav left fast-add\" lay-filter=\"\">\n");
      out.write("\t\t\t<li class=\"layui-nav-item\"><a href=\"javascript:;\">+下拉菜单</a>\n");
      out.write("\t\t\t\t<dl class=\"layui-nav-child\">\n");
      out.write("\t\t\t\t\t<!-- 二级菜单 -->\n");
      out.write("\t\t\t\t\t<dd>\n");
      out.write("\t\t\t\t\t\t<a onclick=\"x_admin_show('资讯','http://www.baidu.com')\"><i\n");
      out.write("\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a2;</i>模拟窗口A</a>\n");
      out.write("\t\t\t\t\t</dd>\n");
      out.write("\t\t\t\t\t<dd>\n");
      out.write("\t\t\t\t\t\t<a onclick=\"x_admin_show('图片','http://www.baidu.com')\"><i\n");
      out.write("\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a8;</i>模拟窗口B</a>\n");
      out.write("\t\t\t\t\t</dd>\n");
      out.write("\t\t\t\t\t<dd>\n");
      out.write("\t\t\t\t\t\t<a onclick=\"x_admin_show('用户','http://www.baidu.com')\"><i\n");
      out.write("\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6b8;</i>模拟窗口C</a>\n");
      out.write("\t\t\t\t\t</dd>\n");
      out.write("\t\t\t\t</dl></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t\t<ul class=\"layui-nav right\">\n");
      out.write("\t\t\t<li class=\"layui-nav-item\"><a href=\"javascript:;\">管理员名称</a>\n");
      out.write("\t\t\t\t<dl class=\"layui-nav-child\">\n");
      out.write("\t\t\t\t\t<!-- 二级菜单 -->\n");
      out.write("\t\t\t\t\t<dd>\n");
      out.write("\t\t\t\t\t\t<a onclick=\"x_admin_show('个人信息','http://www.baidu.com')\">个人中心</a>\n");
      out.write("\t\t\t\t\t</dd>\n");
      out.write("\t\t\t\t\t<dd>\n");
      out.write("\t\t\t\t\t\t<a href=\"indexController/exitLogin.do\">退出登录</a>\n");
      out.write("\t\t\t\t\t</dd>\n");
      out.write("\t\t\t\t</dl></li>\n");
      out.write("\t\t\t<li class=\"layui-nav-item to-index\"><a href=\"index.jsp\">系统首页</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<!-- 顶部结束 -->\n");
      out.write("\t<!-- 中部开始 -->\n");
      out.write("\t<!-- 左侧菜单开始 -->\n");
      out.write("\t<div class=\"left-nav\">\n");
      out.write("\t\t<div id=\"side-nav\">\n");
      out.write("\t\t\t<ul id=\"nav\">\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- 示例：这是一个下拉菜单 -->\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\"> <img src=\"images/member.png\"\n");
      out.write("\t\t\t\t\t\tclass=\"left-menu-icon\"> <cite>职工管理</cite> <i\n");
      out.write("\t\t\t\t\t\tclass=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<ul class=\"sub-menu\">\n");
      out.write("\t\t\t\t\t\t<!-- 这是一个普通按钮 -->\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"view/member/member-list.jsp\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>用户管理</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<!-- 按钮结束 -->\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"view/organization/organization-list.jsp\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>组织结构</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"view/department/department-list.jsp\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>部门管理</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t<!-- 这组下拉菜单结束 -->\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- 这是另一组菜单示例 -->\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\"> <img src=\"images/authority.png\"\n");
      out.write("\t\t\t\t\t\tclass=\"left-menu-icon\"> <cite>权限管理</cite> <i\n");
      out.write("\t\t\t\t\t\tclass=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<ul class=\"sub-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"#\"> <i class=\"iconfont\">&#xe6a7;</i> <cite>权限信息</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"#\"> <i class=\"iconfont\">&#xe6a7;</i> <cite>角色设置</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"#\"> <i class=\"iconfont\">&#xe6a7;</i> <cite>角色分配</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t<!-- 示例结束 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- 这是另一组菜单示例 -->\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\"> <img src=\"images/property.png\"\n");
      out.write("\t\t\t\t\t\tclass=\"left-menu-icon\"> <cite>我的资产</cite> <i\n");
      out.write("\t\t\t\t\t\tclass=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<ul class=\"sub-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"applyController/showApplyByUserName.do\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>在用资产</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"applyController/addApply.do\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>资产申请</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"porchaseController/showPorchaseByUserName.do\">\n");
      out.write("\t\t\t\t\t\t\t\t<i class=\"iconfont\">&#xe6a7;</i> <cite>采购申请</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t<!-- 示例结束 -->\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- 这是另一组菜单示例 -->\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\"> <img\n");
      out.write("\t\t\t\t\t\tsrc=\"images/processmmt.png\" class=\"left-menu-icon\"> <cite>流程管理</cite>\n");
      out.write("\t\t\t\t\t\t<i class=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<ul class=\"sub-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"porchaseController/showPorchase.do\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>采购批准</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"applyController/showAllapply.do\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>申请批准</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"maintainController/showallmaintain.do\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>报修批准</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t<!-- 示例结束 -->\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- 这是另一组菜单示例 -->\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\"> <img src=\"images/gold.png\"\n");
      out.write("\t\t\t\t\t\tclass=\"left-menu-icon\"> <cite>资金核算</cite> <i\n");
      out.write("\t\t\t\t\t\tclass=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<ul class=\"sub-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"view/porchase/quary_bill.jsp\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>采购核算</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t<!-- 示例结束 -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<!-- 这是另一组菜单示例 -->\n");
      out.write("\t\t\t\t<li><a href=\"javascript:;\"> <img src=\"images/warehouse.png\"\n");
      out.write("\t\t\t\t\t\tclass=\"left-menu-icon\"> <cite>库存管理</cite> <i\n");
      out.write("\t\t\t\t\t\tclass=\"iconfont nav_right\">&#xe697;</i>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t<ul class=\"sub-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"propertyController/showAllProperty.do\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>库存资产</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a _href=\"propertyController/showBorrowreturn.do\"> <i\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"iconfont\">&#xe6a7;</i> <cite>资产流动记录</cite>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t<!-- 示例结束 -->\n");
      out.write("\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<!-- 左侧菜单结束 -->\n");
      out.write("\t<!-- 右侧主体开始 -->\n");
      out.write("\t<div class=\"page-content\">\n");
      out.write("\t\t<div class=\"layui-tab tab\" lay-filter=\"xbs_tab\" lay-allowclose=\"false\">\n");
      out.write("\t\t\t<!-- 打开的标签页，无需手动添加 -->\n");
      out.write("\t\t\t<ul class=\"layui-tab-title\">\n");
      out.write("\t\t\t\t<li>欢迎进入本系统</li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<div class=\"layui-tab-content\">\n");
      out.write("\t\t\t\t<div class=\"layui-tab-item layui-show\">\n");
      out.write("\t\t\t\t\t<iframe src='indexController/showWelcome.do' frameborder=\"0\"\n");
      out.write("\t\t\t\t\t\tscrolling=\"yes\" class=\"x-iframe\"></iframe>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!-- 标签页结束 -->\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"page-content-bg\"></div>\n");
      out.write("\t<!-- 右侧主体结束 -->\n");
      out.write("\t<!-- 中部结束 -->\n");
      out.write("\t<!-- 底部开始 -->\n");
      out.write("\t<div class=\"footer\">\n");
      out.write("\t\t<div class=\"copyright\">舒松©2017 前端：x-admin v2.3 后端：舒松-java EE项目</div>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- 底部结束 -->\n");
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
}
