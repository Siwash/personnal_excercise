package kohgylw.mapper;

import java.util.List;
import java.util.Map;

import kohgylw.model.SysMembermanageMemberinfo;

public interface SysMembermanageMemberinfoMapper {
    int insert(SysMembermanageMemberinfo record);

    int insertSelective(SysMembermanageMemberinfo record);
    
    SysMembermanageMemberinfo queryByLoginid(String loginid);
    
    int queryMemberNum(Map<String, Object> map);
    
    List<SysMembermanageMemberinfo> queryByPage(Map<String, Object> map);
}