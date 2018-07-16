package kohgylw.pojo;

import java.util.List;

import kohgylw.model.SysAuthAuthinfo;
import kohgylw.model.SysAuthAuthstyle;

public class AuthModule {
	
	//权限类别信息
	private SysAuthAuthstyle saas;
	
	//该类别所包含的权限列表
	private List<SysAuthAuthinfo> authAuthinfos;

	public SysAuthAuthstyle getSaas() {
		return saas;
	}

	public void setSaas(SysAuthAuthstyle saas) {
		this.saas = saas;
	}

	public List<SysAuthAuthinfo> getAuthAuthinfos() {
		return authAuthinfos;
	}

	public void setAuthAuthinfos(List<SysAuthAuthinfo> authAuthinfos) {
		this.authAuthinfos = authAuthinfos;
	}

}
