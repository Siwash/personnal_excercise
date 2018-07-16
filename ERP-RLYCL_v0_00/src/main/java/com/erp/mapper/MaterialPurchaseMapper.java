package com.erp.mapper;

import java.util.List;
import java.util.Map;

import com.erp.model.MaterialPurchase;

public interface MaterialPurchaseMapper {
    int deleteByPrimaryKey(String materialPurchaseId);

    int insert(MaterialPurchase record);

    int insertSelective(MaterialPurchase record);

    MaterialPurchase selectByPrimaryKey(String materialPurchaseId);

    int updateByPrimaryKeySelective(MaterialPurchase record);

    int updateByPrimaryKey(MaterialPurchase record);

    List<MaterialPurchase> queryAllMaterials();

	List<MaterialPurchase> queryMPLByTnumAndEmeId(Map map);

	List<MaterialPurchase> getPageByTen(int j);
}