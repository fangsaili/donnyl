package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.Education;
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
    private EducationService educationService;

    @RequestMapping("/all")
    public CommenResp<List<Education>> findAll(){
        CommenResp<List<Education>> eduactionCommenResp = new CommenResp<>();

        eduactionCommenResp.setContent(educationService.findAllEducation());

        return eduactionCommenResp;
    }

    @RequestMapping("/edit")
    public CommenResp<Education> edit(Education education){
        CommenResp<Education> educationCommenResp = new CommenResp<>();

        educationCommenResp.setMessage(educationService.editEducation(education) + "");
        educationCommenResp.setContent(education);
        return educationCommenResp;
    }

    @RequestMapping("/insert")
    public CommenResp<Education> insertEducation(Education education){
        CommenResp<Education> educationCommenResp = new CommenResp<>();

        educationCommenResp.setMessage(educationService.insertEducation(education) + "");
        educationCommenResp.setContent(education);
        return educationCommenResp;
    }

    @RequestMapping("/delete")
    public CommenResp<Education> deleteEducation(Education education){
        CommenResp<Education> educationCommenResp = new CommenResp<>();

        educationCommenResp.setMessage(educationService.deleteEducation(education) + "");
        educationCommenResp.setContent(education);
        return educationCommenResp;
    }
}
