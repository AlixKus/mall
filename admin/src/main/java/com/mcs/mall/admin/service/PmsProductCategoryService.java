package com.mcs.mall.admin.service;

import com.mcs.mall.admin.dto.PmsProductCategoryParam;
import com.mcs.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductCategoryService {
    @Transactional
    PmsProductCategory save(PmsProductCategoryParam param);

    @Transactional
    int update(Long id, PmsProductCategoryParam param);

    int delete(Long id);

    PmsProductCategory getItem(Long id);


    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    List<PmsProductCategory> getParentList();

    List<PmsProductCategory> getAllSubList();
}
