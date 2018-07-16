package kohgylw.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import kohgylw.mapper.SysMembermanageMemberinfoMapper;
import kohgylw.model.SysMembermanageMemberinfo;
import kohgylw.pojo.MemberLoginData;
import kohgylw.service.MemberCookieService;

@Service
public class MemberCookieServiceImpl implements MemberCookieService{
	
	@Resource
	private SysMembermanageMemberinfoMapper smmm;
	
	//用于存入用户登录信息cookie
	@Override
	public void setMemberCookie(String loginid, HttpServletResponse response) {
		// TODO 自动生成的方法存根
		SysMembermanageMemberinfo memberinfo=smmm.queryByLoginid(loginid);
		if(memberinfo!=null) {
			Cookie c=new Cookie("ERPSystem1709MemberLoginData", loginid);
			c.setMaxAge(7*60*24);
			response.addCookie(c);
		}else {
			
		}
	}
	
	//用于获取用户登录信息cookie
	@Override
	public String getMemberCookie(HttpServletRequest request) {
		// TODO 自动生成的方法存根
		Cookie[] cookies=request.getCookies();
		for(Cookie c:cookies) {
			if(c.getName().equals("ERPSystem1709MemberLoginData")) {
				String loginid=c.getValue();
				SysMembermanageMemberinfo member=smmm.queryByLoginid(loginid);
				if(member!=null) {
					MemberLoginData mld=new MemberLoginData();
					mld.setUsername(member.getMemberinfoLoginid());
					mld.setPassword(member.getMemberinfoPwd());
					Gson g=new Gson();
					return g.toJson(mld);
				}
			}
		}
		return "{}";
	}

	public SysMembermanageMemberinfoMapper getSmmm() {
		return smmm;
	}

	public void setSmmm(SysMembermanageMemberinfoMapper smmm) {
		this.smmm = smmm;
	}

	//销毁储存用户登录信息的cookie
	@Override
	public void CleanMemberCookie(HttpServletRequest request,HttpServletResponse response) {
		// TODO 自动生成的方法存根
		Cookie[] cookies=request.getCookies();
		for(Cookie c:cookies) {
			if(c.getName().equals("ERPSystem1709MemberLoginData")) {
				c.setMaxAge(0);
				response.addCookie(c);//销毁cookie
			}
		}
	}

}
