package kohgylw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kohgylw.mapper.SysAuthAuthinfoMapper;
import kohgylw.mapper.SysAuthAuthstyleMapper;
import kohgylw.model.SysAuthAuthinfo;
import kohgylw.model.SysAuthAuthstyle;
import kohgylw.model.SysMembermanageMemberinfo;
import kohgylw.pojo.AuthModule;
import kohgylw.service.SysAuthService;

@Service
public class SysAuthServiceImpl implements SysAuthService{
	
	@Resource
	private SysAuthAuthstyleMapper saam;
	@Resource
	private SysAuthAuthinfoMapper saaim;
	
	/*
	 * 根据用户查询该用户具备那些权限
	 * */
	@Override
	public List<AuthModule> getAllAuthByMember(SysMembermanageMemberinfo member) {
		// TODO 自动生成的方法存根
		List<SysAuthAuthstyle> authAuthstyles=saam.queryAll();//查询所有权限大类
		List<AuthModule> authModules=new ArrayList<>();
		for(SysAuthAuthstyle aa: authAuthstyles) {
			AuthModule am=new AuthModule();
			am.setSaas(aa);//设置该大类的标题信息
			Map<String, Object> map=new HashMap<>();
			map.put("memberinfoId", member.getMemberinfoId());
			map.put("authstyleId", aa.getAuthstyleId());
			List<SysAuthAuthinfo> anAuthAuthinfos=saaim.queryByMemberAndStyle(map);//查询该用户具备该大类下那些具体权限
			am.setAuthAuthinfos(anAuthAuthinfos);//将两部分信息封装进一个对象中
			authModules.add(am);
		}
		return authModules;
	}

	public SysAuthAuthstyleMapper getSaam() {
		return saam;
	}

	public void setSaam(SysAuthAuthstyleMapper saam) {
		this.saam = saam;
	}

	public SysAuthAuthinfoMapper getSaaim() {
		return saaim;
	}

	public void setSaaim(SysAuthAuthinfoMapper saaim) {
		this.saaim = saaim;
	}

}
