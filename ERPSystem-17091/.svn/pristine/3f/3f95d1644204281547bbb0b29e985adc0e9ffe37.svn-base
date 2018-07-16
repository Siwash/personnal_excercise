package kohgylw.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * 用于统计当前在线人数的监听器
 * */
public class CountLoginMemberNumListener implements HttpSessionListener {
	
	//当session生成时，自动将在线人数+1
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO 自动生成的方法存根
		System.out.println("侦测到新的session生成");
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		int loginMemberNum = 0;
		if (context.getAttribute("LOGINMEMBERNUM") != null) {
			loginMemberNum = (int) context.getAttribute("LOGINMEMBERNUM");
		} else {

		}
		loginMemberNum++;
		context.setAttribute("LOGINMEMBERNUM", loginMemberNum);
	}
	
	//当一个session销毁时，自动将在线人数-1
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO 自动生成的方法存根
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		int loginMemberNum = 0;
		if (context.getAttribute("LOGINMEMBERNUM") != null) {
			loginMemberNum = (int) context.getAttribute("LOGINMEMBERNUM");
		} else {

		}
		loginMemberNum--;
		if (loginMemberNum < 0) {
			loginMemberNum = 0;
		}
		context.setAttribute("LOGINMEMBERNUM", loginMemberNum);
	}

}
