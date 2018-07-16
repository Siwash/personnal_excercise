package company.items.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import company.items.model.People;

public interface PeopleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(People record);

    int insertSelective(People record);

    People selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(People record);

    int updateByPrimaryKey(People record);

	List<People> queryPeopleByPager(@Param(value="m")int m,@Param(value="n")int n);

	int queryAllData();
}