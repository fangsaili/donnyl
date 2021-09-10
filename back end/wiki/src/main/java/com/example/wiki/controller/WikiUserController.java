package com.example.wiki.controller;


import com.example.wiki.entity.WikiUser;
import com.example.wiki.service.WikiUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/wiki")
public class WikiUserController {
    @Resource
    private WikiUserService wikiuser;

    @RequestMapping("/adduser")
    public WikiUser adduser(@RequestParam String name, Integer age){
        WikiUser user = new WikiUser();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @RequestMapping("/finduserall")
    public List<WikiUser> finduserall(){
        return wikiuser.findWikiuserAll();
    }
    @RequestMapping("/finduser")
    public WikiUser finduser(@RequestParam Integer id){
        return wikiuser.findWikiuseById(id);
    }
}

