package com.erp.mapper;

import com.erp.model.MaterialPurchase;

public interface MaterialPurchaseMapper {
    int deleteByPrimaryKey(String materialPurchaseId);

    int insert(MaterialPurchase record);

    int insertSelective(MaterialPurchase record);

    MaterialPurchase selectByPrimaryKey(String materialPurchaseId);

    int updateByPrimaryKeySelective(MaterialPurchase record);

    int updateByPrimaryKey(MaterialPurchase record);
}