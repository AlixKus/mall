package com.mcs.mall.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mcs.mall.admin.dto.PmsProductParam;
import com.mcs.mall.admin.dto.PmsProductQueryParam;
import com.mcs.mall.admin.service.PmsProductService;
import com.mcs.mall.mapper.PmsProductCategoryMapper;
import com.mcs.mall.mapper.PmsProductMapper;
import com.mcs.mall.model.PmsProduct;
import com.mcs.mall.model.PmsProductCategory;
import com.mcs.mall.model.PmsProductExample;
import com.mcs.mall.model.PmsProductWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductServiceImpl implements PmsProductService {
    @Autowired
    PmsProductMapper productMapper;

    @Autowired
    PmsProductCategoryMapper categoryMapper;

    @Override
    public int create(PmsProductParam productParam) {
        productParam.setId(null);
        productParam.setDeleteStatus(0);
        PmsProductCategory category = categoryMapper.selectByPrimaryKey(productParam.getProductCategoryId());
        productParam.setProductCategoryName(category.getName());
        productMapper.insert(productParam);
        return 0;
    }

    @Override
    public int update(Long id, PmsProductParam productParam) {
        productParam.setId(id);
        productMapper.updateByPrimaryKeySelective(productParam);
        return 0;
    }

    @Override
    public List<PmsProductWithBLOBs> list(PmsProductQueryParam productQueryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample productExample = new PmsProductExample();
        PmsProductExample.Criteria criteria = productExample.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        return productMapper.selectByExampleWithBLOBs(productExample);

    }

    @Override
    public List<PmsProductWithBLOBs> list(Integer pageNum, Integer pageSize) {
        return list(null, pageNum, pageSize);
    }

    @Override
    public int remove(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsProduct> list(String keyword) {
        return null;
    }
}
