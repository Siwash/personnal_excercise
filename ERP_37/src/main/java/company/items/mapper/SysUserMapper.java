package company.items.mapper;

import company.items.model.SysUser;

public interface SysUserMapper {
    

	int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	SysUser selectByAccount(String userAccount);
}