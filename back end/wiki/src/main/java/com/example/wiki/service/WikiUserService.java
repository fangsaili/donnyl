package com.example.wiki.service;


import com.example.wiki.entity.WikiUser;
import com.example.wiki.mapper.WikiUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class WikiUserService  {

    @Resource
    private WikiUserMapper wikiuser;

    public List<WikiUser> findWikiuserAll() {

        return wikiuser.selectByExample(null);
    }

    public WikiUser findWikiuseById(Integer id) {

        return wikiuser.selectByPrimaryKey(id);
    }
}
