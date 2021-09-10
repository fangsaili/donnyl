package com.example.wiki.interceptor;



import com.example.wiki.config.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


@Component
public class TokenInterceptor implements HandlerInterceptor {
//    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtils redisUtils;

    private static final Logger LOG = LoggerFactory.getLogger(TokenInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOG.info("----------------- LoginInterceptor -----------------");
        request.setAttribute("startTime", System.currentTimeMillis());
        if (request.getMethod().toUpperCase().equals("OPTIONS")){
            return true;
        }
        LOG.info("requst http is {} {}", request.getRequestURL().toString(),request.getMethod());

        String token = request.getHeader("token");
        LOG.info("登入校验开始， token: {}", token);
        if(token == null || token.isEmpty()){
            LOG.info("token为空，请求被拦截");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            printEnd(request);
            return false;
        }
        Object object = redisUtils.get(token);
        if(object == null){
            LOG.info("token无效，请求被拦截");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            printEnd(request);
            return false;
        } else {
            LOG.info("以登入，{}",object);
            return true;
        }
    }

    public void printEnd(HttpServletRequest request){
        long startTime = (long) request.getAttribute("startTime");
        LOG.info("time consume is {}", System.currentTimeMillis() - startTime);
        LOG.info("----------------- LoginInterceptor -----------------");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后），如果异常发生，则该方法不会被调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        printEnd(request);

    }
}