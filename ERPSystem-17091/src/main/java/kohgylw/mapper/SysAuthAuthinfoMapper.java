package kohgylw.mapper;

import java.util.List;
import java.util.Map;

import kohgylw.model.SysAuthAuthinfo;

public interface SysAuthAuthinfoMapper {
    int insert(SysAuthAuthinfo record);

    int insertSelective(SysAuthAuthinfo record);
    
    List<SysAuthAuthinfo> queryByMemberAndStyle(Map<String, Object> map);
    
    List<SysAuthAuthinfo> queryAll();
}