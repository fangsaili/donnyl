package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.config.SnowflakeIdWorker;
import com.example.wiki.entity.Portfolio;
import com.example.wiki.entity.Portfolio;
import com.example.wiki.service.PortfolioService;
import io.netty.util.internal.ObjectUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @Resource
    private PortfolioService portfolioService;

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    @RequestMapping("/all")
    public CommenResp<List<Portfolio>> findAll(){
        CommenResp<List<Portfolio>> eduactionCommenResp = new CommenResp<>();

        eduactionCommenResp.setContent(portfolioService.findAllPortfolio());

        return eduactionCommenResp;
    }

    @RequestMapping("/edit")
    public CommenResp<Portfolio> edit(Portfolio portfolio,MultipartFile file){
        String filename = "";
        if(!ObjectUtils.isEmpty(file)){
            try {
                filename = fileUpload(file);
                portfolio.setLinkimg("/file/download?fileName=" + filename);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        CommenResp<Portfolio> portfolioCommenResp = new CommenResp<>();

        portfolioCommenResp.setMessage(portfolioService.editPortfolio(portfolio) + "");
        portfolioCommenResp.setContent(portfolio);
        return portfolioCommenResp;
    }

    @PostMapping("/insert")
    public CommenResp<Portfolio> insertPortfolio(Portfolio portfolio, MultipartFile file){
        String filename = "";
        if(!ObjectUtils.isEmpty(file)){
            try {
                filename = fileUpload(file);
                portfolio.setLinkimg("/file/download?fileName=" + filename);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        CommenResp<Portfolio> portfolioCommenResp = new CommenResp<>();

        portfolioCommenResp.setMessage(portfolioService.insertPortfolio(portfolio) + "");
        portfolioCommenResp.setContent(portfolio);
        return portfolioCommenResp;
    }

    @RequestMapping("/delete")
    public CommenResp<Portfolio> deletePortfolio(Portfolio portfolio){
        CommenResp<Portfolio> portfolioCommenResp = new CommenResp<>();

        portfolioCommenResp.setMessage(portfolioService.deletePortfolio(portfolio) + "");
        portfolioCommenResp.setContent(portfolio);
        return portfolioCommenResp;
    }

    /**
     * 实现文件上传
     * */

    public String fileUpload(MultipartFile file) throws FileNotFoundException {
        if(file.isEmpty()){
            return "false";
        }

        String fileName = file.getOriginalFilename();
        String[] s = fileName.split("\\.");
        String filetype = s[s.length-1];
        String newname =  snowflakeIdWorker.nextId() + "." + filetype;


        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
//        String path = "/root/www/wwwroot/aliserver/upload-images/" ;
        //获取跟目录
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());

        File upload = new File(path.getAbsolutePath()+ "/static",newname);
        if(!upload.exists()) upload.mkdirs();
        System.out.println("upload url:"+upload.getAbsolutePath());

        try {
            file.transferTo(upload); //保存文件
            return newname;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "IllegalStateException";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "IOException";
        }
    }
}
