package kohgylw.mapper;

import java.util.Map;

import kohgylw.model.SysAuthMemberauthtable;

public interface SysAuthMemberauthtableMapper {
    int insert(SysAuthMemberauthtable record);

    int insertSelective(SysAuthMemberauthtable record);
    
    SysAuthMemberauthtable queryByMemberAndAuth(Map<String, Object> map);
}