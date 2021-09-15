package com.example.wiki.config;

import com.example.wiki.interceptor.TimeInterceptor;
import com.example.wiki.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// java配置类
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**").excludePathPatterns("/user/login","/file/download",
                "/contact/update","/watch/time","/watch/ip",
                "/about/all","/skill/all",
                "/education/all","/experience/allwork","/experience/allaward",
                "/portfolio/all");
    }
//    @Autowired
//    private TimeInterceptor timeInterceptor;
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(timeInterceptor)
//                .addPathPatterns("/**").excludePathPatterns("/ebook/findall","/ebook/find");
//    }
}