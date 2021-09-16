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

    public int editSkill(Skill skill) {
        int res =  skillMapper.updateByPrimaryKeySelective(skill);
        return res;
    }

    public int insertSkill(Skill skill) {
        int res =  skillMapper.insertSelective(skill);
        return res;
    }

    public int deleteSkill(Skill skill) {
        int res =  skillMapper.deleteByPrimaryKey(skill.getId());
        return res;
    }
}
