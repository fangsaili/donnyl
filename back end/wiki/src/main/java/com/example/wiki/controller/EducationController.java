package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.Education;
import com.example.wiki.service.EducationService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {
    @Resource
    private EducationService eduactionService;

    @RequestMapping("/all")
    public CommenResp<List<Education>> findAll(){
        CommenResp<List<Education>> eduactionCommenResp = new CommenResp<>();

        eduactionCommenResp.setContent(eduactionService.findAllEducation());

        return eduactionCommenResp;
    }
}
