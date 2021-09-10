package com.example.wiki.service;

import com.example.wiki.Resp.CategoryResp;
import com.example.wiki.Utils.CopyUtil;
import com.example.wiki.config.SnowflakeIdWorker;
import com.example.wiki.entity.Category;
import com.example.wiki.entity.CategoryExample;
import com.example.wiki.mapper.CategoryMapper;
import com.example.wiki.req.CategoryReq;
import com.example.wiki.req.CategorySave;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryMapper category;

//    @Resource
//    private IdWorker snowId = new IdWorker(1,1,0);

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<Category> findCategoryAll() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        List<Category> categories = category.selectByExample(categoryExample);



        return categories;
    }

    public Category findCategoryById(Long id) {

        return category.selectByPrimaryKey(id);
    }

    public List<CategoryResp> findCategoryByParent(CategoryReq categoryReq) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria = criteria.andParentEqualTo(categoryReq.getParent());

        List<Category> categorys = category.selectByExample(categoryExample);


        List<CategoryResp> categoryRespList = new ArrayList<>();
//
        categoryRespList = CopyUtil.copyList(categorys, CategoryResp.class);

        return categoryRespList;
    }

    public List<CategoryResp> findCategoryByName(CategoryReq categoryReq) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        if(categoryReq.getId() != null){
            criteria = criteria.andIdEqualTo(categoryReq.getId());
        }else {
            criteria = criteria.andNameLike( "%" + categoryReq.getName() + "%");
        }

        List<Category> categorys = category.selectByExample(categoryExample);


        List<CategoryResp> categoryRespList = new ArrayList<>();
//        for (Category book : categorys) {
//            CategoryResp categoryResp = new CategoryResp();
//            BeanUtils.copyProperties(book, categoryResp);
//            categoryRespList.add(categoryResp);
//        }
        categoryRespList = CopyUtil.copyList(categorys, CategoryResp.class);

        return categoryRespList;
    }

    public Integer categorySave(CategorySave categoryReq){
        Category category1 = CopyUtil.copy(categoryReq,Category.class);
        if(ObjectUtils.isEmpty(categoryReq.getId())){
//            category1.setId(snowId.nextId());
            category1.setId(snowflakeIdWorker.nextId());
           return category.insert(category1);
        }else {
           return category.updateByPrimaryKeySelective(category1);
        }
    }

    public Integer categoryDelete(Long id){
        return category.deleteByPrimaryKey(id);
    }

}
