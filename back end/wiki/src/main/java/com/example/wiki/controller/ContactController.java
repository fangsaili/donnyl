package com.example.wiki.controller;

import com.example.wiki.Resp.CategoryResp;
import com.example.wiki.Resp.CommenResp;
import com.example.wiki.entity.Watchtimes;
import com.example.wiki.mapper.WatchtimesMapper;
import com.example.wiki.req.CategorySave;
import com.example.wiki.req.ContactReq;
import com.example.wiki.service.ContactService;
import org.springframework.data.repository.query.Param;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Resource
    private ContactService contactService;

    @Resource
    private WatchtimesMapper watchtimesMapper;

    @PostMapping("/update")
    @ResponseBody
    public CommenResp saveContact(@RequestBody ContactReq contactReq, HttpServletRequest request){
        CommenResp<ContactReq> commenResp = new CommenResp<>();
        Watchtimes watchtimes =  watchtimesMapper.selectByPrimaryKey(request.getRemoteAddr());
        if(ObjectUtils.isEmpty(watchtimes)){
            watchtimes.setId(request.getRemoteAddr());
            watchtimes.setTimes(0);
            watchtimes.setContacttimes(0);
            watchtimes.setContactalltimes(0);
            watchtimes.setContacttimes(watchtimes.getContacttimes()+1);
            watchtimes.setContactalltimes(watchtimes.getContactalltimes()+1);
            watchtimesMapper.insert(watchtimes);
            commenResp.setContent(contactReq);
            commenResp.setMessage(contactService.contactSave(contactReq).toString());
            return commenResp;


        }else {
            if (watchtimes.getContacttimes() > 10){
                commenResp.setContent(contactReq);
                commenResp.setMessage("timelimit");
                commenResp.setSuccess(false);
                return commenResp;
            }else{
                watchtimes.setContacttimes(watchtimes.getContacttimes()+1);
                watchtimes.setContactalltimes(watchtimes.getContactalltimes()+1);
                watchtimesMapper.updateByPrimaryKey(watchtimes);
                commenResp.setContent(contactReq);
                commenResp.setMessage(contactService.contactSave(contactReq).toString());
                return commenResp;

            }
        }


    }

}
