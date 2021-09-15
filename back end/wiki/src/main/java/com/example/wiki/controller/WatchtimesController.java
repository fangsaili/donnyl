package com.example.wiki.controller;


import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.Watchtimes;
import com.example.wiki.entity.WatchtimesExample;
import com.example.wiki.mapper.WatchtimesMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.http.HttpRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/watch")
public class WatchtimesController {

    @Resource
    private WatchtimesMapper watchtimesMapper;

    @RequestMapping("/ip")
    public String findip(HttpServletRequest httpRequest){
        return httpRequest.getRemoteAddr();
    }

    @PostMapping("/time")
    public CommenResp insertTimes(@RequestBody String description, HttpServletRequest httpRequest){
        Watchtimes watchtimes = new Watchtimes();
        CommenResp<Watchtimes> objectCommenResp = new CommenResp<>();
        Watchtimes watchtimes1 = watchtimesMapper.selectByPrimaryKey(httpRequest.getRemoteAddr());
        if(ObjectUtils.isEmpty(watchtimes1)){
            watchtimes.setId(httpRequest.getRemoteAddr());
            watchtimes.setTimes(0);
            watchtimes.setContacttimes(0);
            watchtimes.setContactalltimes(0);
            watchtimes.setDescription(description);
            watchtimesMapper.insert(watchtimes);
            watchtimes.setTimes(watchtimes.getTimes()+1);
            watchtimesMapper.updateByPrimaryKeySelective(watchtimes);
            objectCommenResp.setContent(watchtimes);
            return objectCommenResp;

        }else{
            watchtimes1.setTimes(watchtimes1.getTimes()+1);
            watchtimes1.setDescription(description);
            watchtimesMapper.updateByPrimaryKeySelective(watchtimes1);
            objectCommenResp.setContent(watchtimes1);
            return objectCommenResp;
        }
    }
}
