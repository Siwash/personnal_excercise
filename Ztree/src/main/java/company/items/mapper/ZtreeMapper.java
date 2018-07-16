package company.items.mapper;

import java.util.List;
import java.util.Map;

import company.items.model.Ztree;

public interface ZtreeMapper {
    int deleteByPrimaryKey(Integer id);

	int insert(Ztree record);

	int insertSelective(Ztree record);

	Ztree selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Ztree record);

	int updateByPrimaryKey(Ztree record); 

	List<Ztree> queryAllZtree();

	int updatePidById(Map<String, Integer> tMap);

}