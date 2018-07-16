package kohgylw.service;

import java.util.List;

import kohgylw.model.SysMembermanageMemberinfo;
import kohgylw.pojo.AuthModule;

public interface SysAuthService {
	
	public List<AuthModule> getAllAuthByMember(SysMembermanageMemberinfo member);

}
