/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.17
 * Generated at: 2018-04-29 05:55:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view.maintain;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class maintain_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("<title>申请报修</title>\n");
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
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div class=\"x-body\">\n");
      out.write("\t\t<font color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ifo }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</font>\n");
      out.write("\t\t<form class=\"layui-form\" method=\"post\"\n");
      out.write("\t\t\taction=\"maintainController/maintainAdd.do\">\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\n");
      out.write("\t\t\t\t<label for=\"L_id\" class=\"layui-form-label\"> <span\n");
      out.write("\t\t\t\t\tclass=\"x-red\">*</span>名称\n");
      out.write("\t\t\t\t</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t\t<select name=\"propertyName\" id=\"quiz1\" lay-filter=\"myselect\" >\n");
      out.write("\t\t\t\t\t\t<option value=\"\" selected=\"selected\">请选择资产名字</option>\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\"> <span class=\"x-red\">*</span>型号\n");
      out.write("\t\t\t\t</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t\t<select name=\"type\" id=\"quiz2\" >\n");
      out.write("\t\t\t\t\t\t<option selected=\"selected\">请选择型号</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"\">Y650</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"\">N100</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"\">K350</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\n");
      out.write("\t\t\t\t<label for=\"L_pass\" class=\"layui-form-label\"> <span\n");
      out.write("\t\t\t\t\tclass=\"x-red\">*</span>预计花费\n");
      out.write("\t\t\t\t</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t\t<input name=\"maintainCost\" type=\"text\" id=\"L_pass\"\n");
      out.write("\t\t\t\t\t\tautocomplete=\"off\" class=\"layui-input\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"layui-form-item\">\n");
      out.write("\t\t\t\t<label for=\"L_repass\" class=\"layui-form-label\"> </label>\n");
      out.write("\t\t\t\t<button class=\"layui-btn\" type=\"submit\">提交</button>\n");
      out.write("\t\t\t\t<button class=\"layui-btn\" type=\"button\" onclick=\"returnUserApply()\">\n");
      out.write("\t\t\t\t\t重置</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\t<script>\n");
      out.write("\t\t/* layui.use('laydate', function() {\n");
      out.write("\t\t\tvar laydate = layui.laydate;\n");
      out.write("\t\t\t//执行一个laydate实例\n");
      out.write("\t\t\tlaydate.render({\n");
      out.write("\t\t\t\telem : '#L_entry' //指定元素\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}); */\n");
      out.write("\t\t/* \tfunction addmember() {\n");
      out.write("\t\t\t\t \n");
      out.write("\t\t\t\t\t//提交信息……\n");
      out.write("\t\t\t\t\t// 获得frame索引\n");
      out.write("\t\t\t\t\tvar index = parent.layer.getFrameIndex(window.name);\n");
      out.write("\t\t\t\t\t//关闭当前frame\n");
      out.write("\t\t\t\t\tparent.layer.close(index);\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t} */\n");
      out.write("\n");
      out.write("\t\tfunction returnUserApply() {\n");
      out.write("\t\t\twindow.location.href = \"maintainController/applyRepairs.do\";\n");
      out.write("\t\t}\n");
      out.write("\t\t/* layui的ajax联动菜单实现 */\n");
      out.write("\t\tlayui.use([ 'layer', 'form' ], function() {\n");
      out.write("\t\t\tvar layer = layui.layer, form = layui.form;\n");
      out.write("\t\t\tform.on('select(myselect)', function(data) {\n");
      out.write("\t\t\t\tvar propertyName = $(\"#quiz1\").val();\n");
      out.write("\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\ttype : 'POST',\n");
      out.write("\t\t\t\t\turl : 'applyController/returnType.do',\n");
      out.write("\t\t\t\t\tdata : {\n");
      out.write("\t\t\t\t\t\t\"propertyName\" : propertyName\n");
      out.write("\t\t\t\t\t},\n");
      out.write("\t\t\t\t\tdataType : 'json',\n");
      out.write("\t\t\t\t\tsuccess : function(allproperty) {\n");
      out.write("\t\t\t\t\t\tvar str = \"\";\n");
      out.write("\t\t\t\t\t\t$(\"#quiz2\").empty();\n");
      out.write("\t\t\t\t\t\tstr += \"<option>请选择型号</option>\"\n");
      out.write("\t\t\t\t\t\t$(\"#quiz2\").html(str);\n");
      out.write("\n");
      out.write("\t\t\t\t\t\tfor (var i = 0; i < allproperty.length; i++) {\n");
      out.write("\t\t\t\t\t\t\tvar property = allproperty[i];\n");
      out.write("\t\t\t\t\t\t\t$(\"#quiz2\").append(\n");
      out.write("\t\t\t\t\t\t\t\t\t\"<option >\" + property.type + \"</option>\");\n");
      out.write("\t\t\t\t\t\t\tform.render('select');\n");
      out.write("\t\t\t\t\t\t\t$(\"#quiz2\").get(0).selectedIndex = 0;\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t},\n");
      out.write("\t\t\t\t\terror : function(msg) {\n");
      out.write("\t\t\t\t\t\talert(\"无法连接服务器\");\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t});\n");
      out.write("\n");
      out.write("\t\t});\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("\n");
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
    // /view/maintain/maintain_add.jsp(51,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/view/maintain/maintain_add.jsp(51,6) '${propertyList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${propertyList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /view/maintain/maintain_add.jsp(51,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("por");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.propertyName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${por.propertyName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("\t\t\t\t\t\t");
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
}
