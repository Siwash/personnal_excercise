package com.erp.listen;

import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		

	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		//创建一个在线用户的统计
		
		servletContextEvent.getServletContext().setAttribute("LOGUSER", new HashMap<String,String>());
	}

}
