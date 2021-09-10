package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.Resp.EbookResp;
import com.example.wiki.entity.Ebook;
import com.example.wiki.entity.WikiUser;
import com.example.wiki.req.EbookReq;
import com.example.wiki.req.EbookSave;
import com.example.wiki.service.EbookService;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebook;

    @RequestMapping("/findall")
    public CommenResp<List<Ebook>>  finduserall(){
        CommenResp<List<Ebook>> res = new CommenResp<>();
        res.setContent(ebook.findEbookAll());
        return res;
    }

    @RequestMapping("/find")
    public Ebook finduser( @RequestParam Long id){
        return ebook.findEbookById(id);
    }

    @RequestMapping("/findname")
    @ResponseBody
    public CommenResp<List<EbookResp>> findname( @Valid EbookReq ebookReq){
        CommenResp<List<EbookResp>> commenResp = new CommenResp<>();
        commenResp.setContent(ebook.findEbookByName(ebookReq));
        return commenResp;
    }

    @RequestMapping("/save")
    @ResponseBody
    public Integer saveebook(@Valid EbookSave ebookReq){


        return ebook.ebookSave(ebookReq);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Boolean deleteebook(@PathVariable Long id){
        if (ebook.ebookDelete(id)==1){
            return true;
        }else{
            return false;
        }

    }
}
