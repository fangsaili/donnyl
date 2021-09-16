package com.example.wiki.service;

import com.example.wiki.entity.Award;
import com.example.wiki.entity.Award;
import com.example.wiki.mapper.AwardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AwardService {
    @Resource
    private AwardMapper awardMapper;

    public List<Award> findAllAward() {
        return awardMapper.selectByExample(null);
    }

    public int editAward(Award award) {
        int res =  awardMapper.updateByPrimaryKeySelective(award);
        return res;
    }

    public int insertAward(Award award) {
        int res =  awardMapper.insertSelective(award);
        return res;
    }

    public int deleteAward(Award award) {
        int res =  awardMapper.deleteByPrimaryKey(award.getId());
        return res;
    }
}
