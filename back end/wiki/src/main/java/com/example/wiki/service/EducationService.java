package com.example.wiki.service;


import com.example.wiki.entity.Education;
import com.example.wiki.entity.Skill;
import com.example.wiki.mapper.EducationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EducationService {
    @Resource
    private EducationMapper educationMapper;

    public List<Education> findAllEducation() {
        return educationMapper.selectByExample(null);
    }

    public int editEducation(Education education) {
        int res =  educationMapper.updateByPrimaryKeySelective(education);
        return res;
    }

    public int insertEducation(Education education) {
        int res =  educationMapper.insertSelective(education);
        return res;
    }

    public int deleteEducation(Education education) {
        int res =  educationMapper.deleteByPrimaryKey(education.getId());
        return res;
    }
}
