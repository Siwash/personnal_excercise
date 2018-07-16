package kohgylw.service;

import javax.servlet.http.HttpSession;

public interface SysMemberInfoService {
	
	public String determineLoginMember(String loginid,String pwd,HttpSession session,String ip);
	
	public String getMemberPager(String pno,String MemberNum,String MemberName);

}
