package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.Award;
import com.example.wiki.entity.Work;
import com.example.wiki.service.AwardService;
import com.example.wiki.service.WorkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Resource
    private WorkService workService;

    @Resource
    private AwardService awardService;

    @RequestMapping("/allwork")
    public CommenResp<List<Work>> findAll(){
        CommenResp<List<Work>> workCommenResp = new CommenResp<>();

        workCommenResp.setContent(workService.findAllWork());

        return workCommenResp;
    }

    @RequestMapping("/allaward")
    public CommenResp<List<Award>> findAllAward(){
        CommenResp<List<Award>> awardCommenResp = new CommenResp<>();

        awardCommenResp.setContent(awardService.findAllAward());

        return awardCommenResp;
    }
}
