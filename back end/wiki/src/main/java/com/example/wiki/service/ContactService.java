package com.example.wiki.service;

import com.example.wiki.Utils.CopyUtil;
import com.example.wiki.config.SnowflakeIdWorker;
import com.example.wiki.entity.Contact;
import com.example.wiki.entity.Ebook;
import com.example.wiki.entity.WikiUser;
import com.example.wiki.mapper.ContactMapper;
import com.example.wiki.mapper.WikiUserMapper;
import com.example.wiki.req.ContactReq;
import com.example.wiki.req.EbookSave;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactService {
    @Resource
    private ContactMapper contactMapper;

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    public Integer contactSave(ContactReq contactReq){
        Contact contact1 = CopyUtil.copy(contactReq, Contact.class);
        if(ObjectUtils.isEmpty(contactReq.getId())){
//            contact1.setId(snowId.nextId());
            contact1.setId(snowflakeIdWorker.nextId());
            return contactMapper.insert(contact1);
        }else {
            return contactMapper.updateByPrimaryKeySelective(contact1);
        }
    }


}
