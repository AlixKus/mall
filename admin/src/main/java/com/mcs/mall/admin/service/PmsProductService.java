package com.mcs.mall.admin.service;

import com.mcs.mall.admin.dto.PmsProductParam;
import com.mcs.mall.admin.dto.PmsProductQueryParam;
import com.mcs.mall.model.PmsProduct;
import com.mcs.mall.model.PmsProductWithBLOBs;

import java.util.List;

public interface PmsProductService {
    int create(PmsProductParam productParam);

    int update(Long id, PmsProductParam productParam);

    List<PmsProductWithBLOBs> list(Integer pageNum, Integer pageSize);

    /**
     * 分页查询商品
     */
    List<PmsProductWithBLOBs> list(PmsProductQueryParam productQueryParam, Integer pageNum, Integer pageSize);


    /*
     * 删除商品
     */
    int remove(Long id);

    /**
     * 根据商品名称或者货号模糊查询
     */
    List<PmsProduct> list(String keyword);
}
