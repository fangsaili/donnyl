package com.example.wiki.service;

import com.example.wiki.entity.Work;
import com.example.wiki.entity.Work;
import com.example.wiki.mapper.WorkMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkService {
    @Resource
    private WorkMapper workMapper;

    public List<Work> findAllWork() {
        return workMapper.selectByExample(null);
    }

    public int editWork(Work work) {
        int res =  workMapper.updateByPrimaryKeySelective(work);
        return res;
    }

    public int insertWork(Work work) {
        int res =  workMapper.insertSelective(work);
        return res;
    }

    public int deleteWork(Work work) {
        int res =  workMapper.deleteByPrimaryKey(work.getId());
        return res;
    }
}
