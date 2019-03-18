package com.mcs.mall.mapper;

import com.mcs.mall.model.PmsProduct;
import com.mcs.mall.model.PmsProductExample;
import com.mcs.mall.model.PmsProductWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductMapper {
    long countByExample(PmsProductExample example);

    int deleteByExample(PmsProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductWithBLOBs record);

    int insertSelective(PmsProductWithBLOBs record);

    List<PmsProductWithBLOBs> selectByExampleWithBLOBs(PmsProductExample example);

    List<PmsProduct> selectByExample(PmsProductExample example);

    PmsProductWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductWithBLOBs record, @Param("example") PmsProductExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProductWithBLOBs record, @Param("example") PmsProductExample example);

    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByPrimaryKeySelective(PmsProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsProductWithBLOBs record);

    int updateByPrimaryKey(PmsProduct record);
}