package com.erp.mapper;

import java.util.List;

import com.erp.model.ProductTurnover;

public interface ProductTurnoverMapper {
    int deleteByPrimaryKey(String productTurnoverId);

    int insert(ProductTurnover record);

    int insertSelective(ProductTurnover record);

    ProductTurnover selectByPrimaryKey(String productTurnoverId);

    int updateByPrimaryKeySelective(ProductTurnover record);

    int updateByPrimaryKey(ProductTurnover record);

	List<ProductTurnover> queryProductTurnover();
}