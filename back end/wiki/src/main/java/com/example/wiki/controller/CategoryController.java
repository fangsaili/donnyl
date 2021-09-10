package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.Resp.CategoryResp;
import com.example.wiki.entity.Category;
import com.example.wiki.req.CategoryReq;
import com.example.wiki.req.CategorySave;
import com.example.wiki.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService category;


    @RequestMapping("/findall")
    public CommenResp<List<Category>>  finduserall(){
        CommenResp<List<Category>> res = new CommenResp<>();
        res.setContent(category.findCategoryAll());
        return res;
    }

    @RequestMapping("/find")
    public Category finduser( @RequestParam Long id){
        return category.findCategoryById(id);
    }

    @RequestMapping("/findname")
    @ResponseBody
    public CommenResp<List<CategoryResp>> findname( @Valid CategoryReq categoryReq){
        CommenResp<List<CategoryResp>> commenResp = new CommenResp<>();
        commenResp.setContent(category.findCategoryByName(categoryReq));
        return commenResp;
    }

    @RequestMapping("/findparent")
    @ResponseBody
    public CommenResp<List<CategoryResp>> findparent(    CategoryReq categoryReq){
        CommenResp<List<CategoryResp>> commenResp = new CommenResp<>();
        commenResp.setContent(category.findCategoryByParent(categoryReq));
        return commenResp;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Integer savecategory(@Valid CategorySave categoryReq){


        return category.categorySave(categoryReq);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Boolean deletecategory(@PathVariable Long id){
        if (category.categoryDelete(id)==1){
            return true;
        }else{
            return false;
        }

    }
}
