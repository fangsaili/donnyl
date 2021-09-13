package com.example.wiki.service;

import com.example.wiki.entity.AboutContent;
import com.example.wiki.entity.Skill;
import com.example.wiki.mapper.AboutContentMapper;
import com.example.wiki.mapper.SkillMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkillService {
    @Resource
    private SkillMapper skillMapper;

    public List<Skill> findAllSkill() {
        return skillMapper.selectByExample(null);
    }
}
