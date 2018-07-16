package com.erp.listen;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		// 统计访问人数
		
	}

	public void sessionDestroyed(HttpSessionEvent hSessionEvent) {
		// 下线人数销毁
		String user=(String) hSessionEvent.getSession().getAttribute("USERID");
		if (user!=null) {
			ServletContext servletContext=hSessionEvent.getSession().getServletContext();
			@SuppressWarnings("unchecked")
			HashMap<String, String> logUser=(HashMap<String, String>) servletContext.getAttribute("LOGUSER");
			logUser.remove(user);
			servletContext.setAttribute("LOGUSER", logUser);
		}
		
	}



}

