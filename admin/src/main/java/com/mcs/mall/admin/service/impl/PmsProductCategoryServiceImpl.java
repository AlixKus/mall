package com.mcs.mall.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mcs.mall.admin.dto.PmsProductCategoryParam;
import com.mcs.mall.admin.service.PmsProductCategoryService;
import com.mcs.mall.mapper.PmsProductCategoryMapper;
import com.mcs.mall.model.PmsProductCategory;
import com.mcs.mall.model.PmsProductCategoryExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

    @Autowired
    PmsProductCategoryMapper productCategoryMapper;

    @Override
    public PmsProductCategory save(PmsProductCategoryParam param) {
        PmsProductCategory productCategory = new PmsProductCategory();
        BeanUtils.copyProperties(param, productCategory);
        // 总量为0
        productCategory.setProductCount(0);
        productCategoryMapper.insertSelective(productCategory);
        return productCategory;
    }

    @Override
    public int update(Long id, PmsProductCategoryParam param) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public PmsProductCategory getItem(Long id) {
        return null;
    }

    @Override
    public List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductCategory> getParentList() {
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(0L);
        return productCategoryMapper.selectByExample(example);
    }
}
