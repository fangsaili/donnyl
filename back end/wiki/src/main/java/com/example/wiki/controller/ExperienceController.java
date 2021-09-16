package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.Award;
import com.example.wiki.entity.Award;
import com.example.wiki.entity.Work;
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

    @RequestMapping("/work/edit")
    public CommenResp<Work> edit(Work work){
        CommenResp<Work> workCommenResp = new CommenResp<>();

        workCommenResp.setMessage(workService.editWork(work) + "");
        workCommenResp.setContent(work);
        return workCommenResp;
    }

    @RequestMapping("/work/insert")
    public CommenResp<Work> insertWork(Work work){
        CommenResp<Work> workCommenResp = new CommenResp<>();

        workCommenResp.setMessage(workService.insertWork(work) + "");
        workCommenResp.setContent(work);
        return workCommenResp;
    }

    @RequestMapping("/work/delete")
    public CommenResp<Work> deleteWork(Work work){
        CommenResp<Work> workCommenResp = new CommenResp<>();

        workCommenResp.setMessage(workService.deleteWork(work) + "");
        workCommenResp.setContent(work);
        return workCommenResp;
    }

    @RequestMapping("/award/edit")
    public CommenResp<Award> edit(Award award){
        CommenResp<Award> awardCommenResp = new CommenResp<>();

        awardCommenResp.setMessage(awardService.editAward(award) + "");
        awardCommenResp.setContent(award);
        return awardCommenResp;
    }

    @RequestMapping("/award/insert")
    public CommenResp<Award> insertAward(Award award){
        CommenResp<Award> awardCommenResp = new CommenResp<>();

        awardCommenResp.setMessage(awardService.insertAward(award) + "");
        awardCommenResp.setContent(award);
        return awardCommenResp;
    }

    @RequestMapping("/award/delete")
    public CommenResp<Award> deleteAward(Award award){
        CommenResp<Award> awardCommenResp = new CommenResp<>();

        awardCommenResp.setMessage(awardService.deleteAward(award) + "");
        awardCommenResp.setContent(award);
        return awardCommenResp;
    }
    
    
}
