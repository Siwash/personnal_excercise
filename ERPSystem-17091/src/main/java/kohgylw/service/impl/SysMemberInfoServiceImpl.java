package kohgylw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kohgylw.mapper.SysMembermanageMemberinfoMapper;
import kohgylw.model.SysMembermanageMemberinfo;
import kohgylw.pojo.MemberPager;
import kohgylw.service.SysMemberInfoService;
import kohgylw.util.FormateDateUtil;

@Service
public class SysMemberInfoServiceImpl implements SysMemberInfoService {

	@Resource
	private SysMembermanageMemberinfoMapper smmm;

	@Resource
	private FormateDateUtil fdu;

	/*
	 * 根据用户信息判定其是否存在及能否登录
	 */
	@Override
	public String determineLoginMember(String loginid, String pwd, HttpSession session, String ip) {
		if (loginid != null && loginid.length() > 0) {
			SysMembermanageMemberinfo member = smmm.queryByLoginid(loginid);
			if (member != null) {
				if (member.getMemberinfoPwd().equals(pwd)) {
					if(member.getMemberinfoState().equals("enable")) {
						session.setAttribute("MEMBERINFO", member);
						session.setAttribute("LOGINTIME", fdu.getFormateDate());
						return "permitLogin";
					}else if(member.getMemberinfoState().equals("disable")){
						return "memberDisable";
					}else {
						return "loginError";
					}
				} else {
					return "pwdError";
				}
			} else {
				return "loginidInvalid";
			}
		} else {
			return "loginError";
		}
	}

	public SysMembermanageMemberinfoMapper getSmmm() {
		return smmm;
	}

	public void setSmmm(SysMembermanageMemberinfoMapper smmm) {
		this.smmm = smmm;
	}

	public FormateDateUtil getFdu() {
		return fdu;
	}

	public void setFdu(FormateDateUtil fdu) {
		this.fdu = fdu;
	}

	@Override
	public String getMemberPager(String pno,String MemberNum,String MemberName) {
		// TODO 自动生成的方法存根
		// 每页显示的数量
		int pageSize = 6;
		// 总条数
		Map<String, Object> totalmap=new HashMap<>();
		totalmap.put("MemberName", "%"+MemberName+"%");
		totalmap.put("MemberNum", MemberNum);
		int totalRecords = smmm.queryMemberNum(totalmap);
		// 总页码
		int total;
		Gson g = new Gson();
		MemberPager mp = new MemberPager();
		mp.setTotalRecords(totalRecords);
		// 计算总页码数，使得所有数据均可以显示出来
		if (totalRecords % pageSize > 0) {
			total = totalRecords / pageSize + 1;
		} else {
			total = totalRecords / pageSize;
		}
		mp.setTotal(total);
		Map<String, Object> Membersmap = new HashMap<>();
		int n = 1;
		if (pno != null && pno.length() > 0) {
			n = Integer.parseInt(pno);
		}
		//计算过程待验证
		Membersmap.put("pno", (n - 1) * pageSize);
		Membersmap.put("num", pageSize);
		Membersmap.put("MemberName", "%"+MemberName+"%");
		Membersmap.put("MemberNum", MemberNum);
		List<SysMembermanageMemberinfo> memberinfos=smmm.queryByPage(Membersmap);
		//设置分页结果集
		mp.setMemberinfos(memberinfos);	
		return g.toJson(mp);
	}
}
