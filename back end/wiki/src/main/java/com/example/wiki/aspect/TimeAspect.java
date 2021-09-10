package com.example.wiki.aspect;

import com.fasterxml.jackson.databind.util.JSONPObject;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Aspect
@Component
public class TimeAspect {
//    private static final Logger LOG = LoggerFactory.getLogger(TimeAspect.class);
//
//    @Around("execution(* com.example.*.controller..*Controller.*(..))")
//    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        LOG.info("切片开始。。。");
//        long startTime = System.currentTimeMillis();
//
//        // 获取请求入参
//        Object[] args = proceedingJoinPoint.getArgs();
//        Arrays.stream(args).forEach(arg -> LOG.info("arg is {}", arg));
//
//        // 获取相应
//        Object response = proceedingJoinPoint.proceed();
//        LOG.info("response。。。", response);
//
//        long endTime = System.currentTimeMillis();
//        LOG.info("请求:{}, 耗时{}ms", proceedingJoinPoint.getSignature(), (endTime - startTime));
//        LOG.info("切片结束。。。");
//        return response;
//    }
}