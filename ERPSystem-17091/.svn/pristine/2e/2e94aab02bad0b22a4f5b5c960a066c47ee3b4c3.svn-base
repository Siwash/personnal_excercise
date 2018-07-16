package kohgylw.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kohgylw.model.SysMembermanageMemberinfo;
import kohgylw.pojo.AuthModule;
import kohgylw.service.MemberCookieService;
import kohgylw.service.SysAuthService;
import kohgylw.service.SysMemberInfoService;
import kohgylw.util.FormateDateUtil;
import kohgylw.util.GetNetMessageUtil;
import kohgylw.util.GetOnlineMemberNumUtil;

/**
 * 
 * @author kohgylw
 * @version 1.0 用于处理用户管理模块的请求
 * 
 */
@Controller
@RequestMapping("/sysMemberController")
public class SysMemberController {

	@Resource
	private SysMemberInfoService smis;

	@Resource
	private GetNetMessageUtil gbriu;

	@Resource
	private FormateDateUtil fdu;
	
	@Resource
	private GetOnlineMemberNumUtil gomnu;
	
	@Resource
	private SysAuthService sas;
	
	@Resource
	private MemberCookieService mcs;
	
	/*
	 * 用于获取用户登录信息cookie并传回页面
	 * */
	@RequestMapping("/getMemberCookieData.ajax")
	public @ResponseBody String getMemberCookieData(HttpServletRequest request) {
		return mcs.getMemberCookie(request);//用于读取用户登录信息cookie并封装成json对象发送给登录页面
	}

	/*
	 * 用于进行ajax登录判定
	 */
	@RequestMapping("/doLoginDetermineByAjax.ajax")
	public @ResponseBody String doLoginDetermineByAjax(HttpServletRequest request, HttpSession session, String loginid,
			String pwd,String remberMe,HttpServletResponse response) {
		if(remberMe.equals("y")) {//如果用户勾选了7天记住登录信息，那么设置cookie
			mcs.setMemberCookie(loginid, response);//设置用户登录信息cookie
		}else if(remberMe.equals("n")){
			mcs.CleanMemberCookie(request, response);//如果用户没勾，该方法会销毁该cookie（如果有的话）
		}
		return smis.determineLoginMember(loginid, pwd, session, gbriu.getIp(request));
	}

	/*
	 * 用于进入index系统主界面
	 */
	@RequestMapping("/entrySystemIndex.do")
	public String entrySystemIndex(HttpSession session, HttpServletRequest request) {
		SysMembermanageMemberinfo Loginmember = (SysMembermanageMemberinfo) session.getAttribute("MEMBERINFO");
		request.setAttribute("Loginmember", Loginmember);
		List<AuthModule> authModules=sas.getAllAuthByMember(Loginmember);
		request.setAttribute("authModules", authModules);
		return "index";
	}

	/* 打开欢迎页面，并初始化页面信息 */
	@RequestMapping("/showWelcomePage.do")
	public String showWelcomePage(HttpSession session, HttpServletRequest request) {
		SysMembermanageMemberinfo loginmember = (SysMembermanageMemberinfo) session.getAttribute("MEMBERINFO");
		request.setAttribute("loginmember", loginmember);
		request.setAttribute("LOGINTIME", session.getAttribute("LOGINTIME"));
		request.setAttribute("BOSWERIP", gbriu.getIp(request));
		request.setAttribute("LOCALNAME", gbriu.getLocalName());
		request.setAttribute("LOGINMEMBERNUM", gomnu.getNum(request));
		request.setAttribute("SESSIONTIMEOUT", session.getMaxInactiveInterval() / 60);
		request.setAttribute("SERVERTIME", fdu.getFormateDate());
		return "welcome";
	}

	/* 获取在线人数的接口（例如，欢迎页面的在线人数刷新） */
	@RequestMapping("/reOnlineMemberNum.ajax")
	public @ResponseBody String reOnlineMemberNum(HttpServletRequest request) {
		return gomnu.getNum(request) + "";
	}

	/* 使用ajax获取当前服务器时间的接口（例如，欢迎页面的时间刷新） */
	@RequestMapping("/reServerTime.ajax")
	public @ResponseBody String reServerTime() {
		return fdu.getFormateDate();
	}

	/* 用户注销 */
	@RequestMapping("/memberCancel.do")
	public String memberCancel(HttpSession session) {
		session.invalidate();
		return "login";
	}

	/* ajax分页功能，根据页数、查询条件，返回分页结果 */
	@RequestMapping(value = "/initMemberPage.ajax", produces = "text/html;charset=utf-8")
	public @ResponseBody String initMemberPage(String pno, String MemberNum, String MemberName) {
		String json = smis.getMemberPager(pno, MemberNum, MemberName);
		System.out.println("生成的json为：" + json);
		return json;
	}

	/* 执行查询操作，更新页面并设定查询条件 */
	@RequestMapping("/sreachMember.do")
	public String sreachMember(String usernumber, String username, HttpServletRequest request) {
		request.setAttribute("usernumber", usernumber);
		request.setAttribute("username", username);
		return "view/member/member-list";
	}

	public SysMemberInfoService getSmis() {
		return smis;
	}

	public void setSmis(SysMemberInfoService smis) {
		this.smis = smis;
	}

	public GetNetMessageUtil getGbriu() {
		return gbriu;
	}

	public void setGbriu(GetNetMessageUtil gbriu) {
		this.gbriu = gbriu;
	}

	public FormateDateUtil getFdu() {
		return fdu;
	}

	public void setFdu(FormateDateUtil fdu) {
		this.fdu = fdu;
	}

	public GetOnlineMemberNumUtil getGomnu() {
		return gomnu;
	}

	public void setGomnu(GetOnlineMemberNumUtil gomnu) {
		this.gomnu = gomnu;
	}

	public SysAuthService getSas() {
		return sas;
	}

	public void setSas(SysAuthService sas) {
		this.sas = sas;
	}

	public MemberCookieService getMcs() {
		return mcs;
	}

	public void setMcs(MemberCookieService mcs) {
		this.mcs = mcs;
	}

}
