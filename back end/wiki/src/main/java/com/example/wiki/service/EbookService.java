package com.example.wiki.service;

import com.example.wiki.Resp.EbookResp;
import com.example.wiki.Utils.CopyUtil;
import com.example.wiki.config.IdWorker;
import com.example.wiki.config.SnowflakeIdWorker;
import com.example.wiki.entity.Ebook;
import com.example.wiki.entity.EbookExample;
import com.example.wiki.mapper.EbookMapper;
import com.example.wiki.req.EbookReq;
import com.example.wiki.req.EbookSave;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
//import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebook;

//    @Resource
//    private IdWorker snowId = new IdWorker(1,1,0);

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<Ebook> findEbookAll() {

        return ebook.selectByExample(null);
    }

    public Ebook findEbookById(Long id) {

        return ebook.selectByPrimaryKey(id);
    }

    public List<EbookResp> findEbookByName(EbookReq ebookReq) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if(ebookReq.getId() != null){
            criteria = criteria.andIdEqualTo(ebookReq.getId());
        }else {
            criteria = criteria.andNameLike( "%" + ebookReq.getName() + "%");
        }

        List<Ebook> ebooks = ebook.selectByExample(ebookExample);


        List<EbookResp> ebookRespList = new ArrayList<>();
//        for (Ebook book : ebooks) {
//            EbookResp ebookResp = new EbookResp();
//            BeanUtils.copyProperties(book, ebookResp);
//            ebookRespList.add(ebookResp);
//        }
        ebookRespList = CopyUtil.copyList(ebooks, EbookResp.class);

        return ebookRespList;
    }

    public Integer ebookSave(EbookSave ebookReq){
        Ebook ebook1 = CopyUtil.copy(ebookReq,Ebook.class);
        if(ObjectUtils.isEmpty(ebookReq.getId())){
//            ebook1.setId(snowId.nextId());
            ebook1.setId(snowflakeIdWorker.nextId());
           return ebook.insert(ebook1);
        }else {
           return ebook.updateByPrimaryKeySelective(ebook1);
        }
    }

    public Integer ebookDelete(Long id){
        return ebook.deleteByPrimaryKey(id);
    }

}
