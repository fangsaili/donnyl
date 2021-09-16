package com.example.wiki.service;

import com.example.wiki.entity.AboutContent;
import com.example.wiki.entity.Category;
import com.example.wiki.mapper.AboutContentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class About_detailsService {
    @Resource
    private AboutContentMapper aboutContentMapper;

    public List<AboutContent> findAllAboutContent() {
        return aboutContentMapper.selectByExample(null);
    }

    public int editContent(AboutContent aboutContent) {
        int res =  aboutContentMapper.updateByPrimaryKeySelective(aboutContent);
        return res;
    }
}
