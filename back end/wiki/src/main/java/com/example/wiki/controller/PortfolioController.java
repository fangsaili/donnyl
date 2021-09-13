package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.Portfolio;
import com.example.wiki.service.PortfolioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @Resource
    private PortfolioService eduactionService;

    @RequestMapping("/all")
    public CommenResp<List<Portfolio>> findAll(){
        CommenResp<List<Portfolio>> eduactionCommenResp = new CommenResp<>();

        eduactionCommenResp.setContent(eduactionService.findAllPortfolio());

        return eduactionCommenResp;
    }
}
