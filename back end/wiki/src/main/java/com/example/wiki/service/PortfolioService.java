package com.example.wiki.service;

import com.example.wiki.entity.Portfolio;
import com.example.wiki.entity.Portfolio;
import com.example.wiki.mapper.PortfolioMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PortfolioService {
    @Resource
    private PortfolioMapper portfolioMapper;

    public List<Portfolio> findAllPortfolio() {
        return portfolioMapper.selectByExample(null);
    }

    public int editPortfolio(Portfolio portfolio) {
        int res =  portfolioMapper.updateByPrimaryKeySelective(portfolio);
        return res;
    }

    public int insertPortfolio(Portfolio portfolio) {
        int res =  portfolioMapper.insertSelective(portfolio);
        return res;
    }

    public int deletePortfolio(Portfolio portfolio) {
        int res =  portfolioMapper.deleteByPrimaryKey(portfolio.getId());
        return res;
    }
}
