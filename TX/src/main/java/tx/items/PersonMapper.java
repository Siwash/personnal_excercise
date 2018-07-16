package tx.items;

import tx.items.Person;

public interface PersonMapper {
    int deleteByPrimaryKey(String name);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);
}