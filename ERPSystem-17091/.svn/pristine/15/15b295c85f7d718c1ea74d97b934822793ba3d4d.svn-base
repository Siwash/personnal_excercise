package kohgylw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import kohgylw.mapper.SysMembermanageMemberinfoMapper;
import kohgylw.model.SysMembermanageMemberinfo;

public class MemberLoginFilter implements Filter{
	
	private SysMembermanageMemberinfoMapper smmm;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 自动生成的方法存根
		//根据项目的上下文（ServletContext）获取spring配置文件所在路径并初始化IOC容器
		ServletContext sc=filterConfig.getServletContext();
		//使用spring IOC容器获取一个查询用户信息的映射接口
		ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		smmm=context.getBean(SysMembermanageMemberinfoMapper.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO 自动生成的方法存根
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		SysMembermanageMemberinfo memberinfo=(SysMembermanageMemberinfo) session.getAttribute("MEMBERINFO");
		if(memberinfo==null) {
			res.sendRedirect("/ERPSystem-17091/login.jsp");
		}else {
			SysMembermanageMemberinfo member=smmm.queryByLoginid(memberinfo.getMemberinfoLoginid());
			if(member.getMemberinfoState().equals("enable")) {
				session.setAttribute("MEMBERINFO", member);//这样一来，用户每触发一次跳转，session里面存储的用户信息都会被实时更新
				chain.doFilter(request, response);//放行
			}else if(member.getMemberinfoState().equals("disable")) {
				session.invalidate();//如果用户被停用了，那么先立即注销它
				res.sendRedirect("/ERPSystem-17091/login.jsp");//重定向到登录页面
			}else {
				session.setAttribute("MEMBERINFO", member);
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

}
