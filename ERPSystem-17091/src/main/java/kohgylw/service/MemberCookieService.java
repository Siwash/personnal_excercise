package kohgylw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCookieService {
	
	public void setMemberCookie(String loginid,HttpServletResponse response);
	
	public String getMemberCookie(HttpServletRequest request);
	
	public void CleanMemberCookie(HttpServletRequest request,HttpServletResponse response);

}
