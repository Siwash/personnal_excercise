package company.items.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUserStatus implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest hRequest=(HttpServletRequest) request;
		HttpServletResponse hResponse=(HttpServletResponse) response;
		String URI=hRequest.getRequestURI();
		String objPath=hRequest.getContextPath();
		if (URI.equals(URI+"/")||URI.equals(URI+"/login.html")) {
			filterChain.doFilter(hRequest, hResponse);
		}else {
			String userId=(String) hRequest.getSession().getAttribute("USERID");
			if (userId!=null) {
				filterChain.doFilter(hRequest, hResponse);
			}else {
				hResponse.sendRedirect(objPath+"/login.html");
			}
		}
		

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
