package kohgylw.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import kohgylw.mapper.SysAuthAuthinfoMapper;
import kohgylw.mapper.SysAuthMemberauthtableMapper;
import kohgylw.model.SysAuthAuthinfo;
import kohgylw.model.SysAuthMemberauthtable;
import kohgylw.model.SysMembermanageMemberinfo;

/*
 * 对于发送到权限模块的请求进行二次甄别
 * */
public class AuthModuleRequestFilter implements Filter{
	
	private SysAuthAuthinfoMapper saam;
	private SysAuthMemberauthtableMapper samm;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 自动生成的方法存根
		ServletContext sc=filterConfig.getServletContext();
		ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		saam=context.getBean(SysAuthAuthinfoMapper.class);
		samm=context.getBean(SysAuthMemberauthtableMapper.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO 自动生成的方法存根
		HttpServletRequest req=(HttpServletRequest) request;
		String reqURL=req.getRequestURI();//本次请求的URL
		List<SysAuthAuthinfo> authAuthinfos=saam.queryAll();//查询所有权限
		boolean key=false;
		SysAuthAuthinfo saai=null;
		for(SysAuthAuthinfo saa : authAuthinfos) {
			String AuthURL="/ERPSystem-17091/"+saa.getAuthinfoUrl();//权限规定的权限模块跳转URL
			if(reqURL.equals(AuthURL)) {
				key=true;
				saai=saa;//保存该次请求对应的权限对象
			}
		}
		if(key==false) {
			chain.doFilter(request, response);
		}else {
			SysMembermanageMemberinfo memberinfo=(SysMembermanageMemberinfo) req.getSession().getAttribute("MEMBERINFO");
			Map<String, Object> map=new HashMap<>();
			map.put("memberinfoId", memberinfo.getMemberinfoId());
			map.put("authinfoId", saai.getAuthinfoId());
			SysAuthMemberauthtable sam=samm.queryByMemberAndAuth(map);//根据用户以及本次请求对应的权限对象来查询是否有这个对应关系
			if(sam!=null&&sam instanceof SysAuthMemberauthtable) {
				chain.doFilter(request, response);//如果存在这样的对应关系，说明该用户请求合法，放行
			}else {
				//否则不执行任何操作
			}
		}
	}

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

}
