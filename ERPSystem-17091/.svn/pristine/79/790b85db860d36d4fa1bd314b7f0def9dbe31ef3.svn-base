package kohgylw.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/*该工具用于从context中获取在线人数信息*/
@Component
public class GetOnlineMemberNumUtil {

	public int getNum(HttpServletRequest request) {
		ServletContext sc = request.getServletContext();
		int result = 0;
		result = (int) sc.getAttribute("LOGINMEMBERNUM");
		if(result==0) {
			result=1;
			sc.setAttribute("LOGINMEMBERNUM", result);
		}
		return result;
	}

}
