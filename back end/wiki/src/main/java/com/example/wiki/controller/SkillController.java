package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.AboutContent;
import com.example.wiki.entity.Skill;
import com.example.wiki.service.SkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Resource
    private SkillService skillService;

    @RequestMapping("/all")
    public CommenResp<List<Skill>> findAll(){
        CommenResp<List<Skill>> skillCommenResp = new CommenResp<>();

        skillCommenResp.setContent(skillService.findAllSkill());

        return skillCommenResp;
    }
}
