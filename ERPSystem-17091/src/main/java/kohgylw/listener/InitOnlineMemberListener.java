package kohgylw.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*用于初始化在线人数统计字段*/
public class InitOnlineMemberListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO 自动生成的方法存根
		ServletContext sc=sce.getServletContext();
		sc.setAttribute("LOGINMEMBERNUM", 0);//在服务器启动时初始化在线人数的统计参数
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO 自动生成的方法存根
		
	}
	
	

}
