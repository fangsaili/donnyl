package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.exception.CommonException;
import com.example.wiki.exception.CommonExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger Log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommenResp validExceptionHandler(BindException e){
        CommenResp commenResp = new CommenResp();
        Log.warn("参数校验失败：{}",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        commenResp.setSuccess(false);
        commenResp.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return commenResp;
    }

    @ExceptionHandler(value = CommonException.class)
    @ResponseBody
    public CommenResp validExceptionHandler(CommonException e){
        CommenResp commenResp = new CommenResp();
        Log.warn("业务异常：{}",e.getCode().getDesc());
        commenResp.setSuccess(false);
        commenResp.setMessage(e.getCode().getDesc());
        return commenResp;
    }




    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommenResp validExceptionHandler(Exception e){
        CommenResp commenResp = new CommenResp();
        Log.error("系统异常:",e);
        commenResp.setSuccess(false);
        commenResp.setMessage("系统异常 ");
        return commenResp;
    }

}
