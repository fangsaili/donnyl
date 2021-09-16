package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.AboutContent;
import com.example.wiki.service.About_detailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/about")
public class AboutContentController {
    @Resource
    private About_detailsService about_detailsService;

    @RequestMapping("/all")
    public CommenResp<List<AboutContent>> findAll(){
        CommenResp<List<AboutContent>> aboutContentCommenResp = new CommenResp<>();

        aboutContentCommenResp.setContent(about_detailsService.findAllAboutContent());

        return aboutContentCommenResp;
    }

    @RequestMapping("/edit")
    public CommenResp<AboutContent> editcontent(AboutContent aboutContent){
        CommenResp<AboutContent> aboutContentCommenResp = new CommenResp<>();

        aboutContentCommenResp.setMessage(about_detailsService.editContent(aboutContent) + "");
        aboutContentCommenResp.setContent(aboutContent);
        return aboutContentCommenResp;
    }
}
