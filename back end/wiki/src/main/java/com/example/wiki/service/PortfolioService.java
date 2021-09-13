package com.example.wiki.service;

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
}
