package com.example.wiki.controller;

import com.example.wiki.Resp.CommenResp;
import com.example.wiki.Resp.UserLoginResp;
import com.example.wiki.Resp.UserResp;
import com.example.wiki.config.RedisUtils;
import com.example.wiki.config.SnowflakeIdWorker;
import com.example.wiki.entity.User;
import com.example.wiki.mapper.UserMapper;
import com.example.wiki.req.PasswordResetReq;
import com.example.wiki.req.UserLogin;
import com.example.wiki.req.UserReq;
import com.example.wiki.req.UserSave;
import com.example.wiki.service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @Resource
    private UserService user;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    @RequestMapping("/findall")
    public CommenResp<List<User>>  finduserall(){
        CommenResp<List<User>> res = new CommenResp<>();
        res.setContent(user.findUserAll());
        return res;
    }

    @RequestMapping("/finda")
    public CommenResp<List<User>>  findall(){
        CommenResp<List<User>> res = new CommenResp<>();
        res.setContent(userMapper.findAll());
        return res;
    }

    @RequestMapping("/find")
    public User finduser( @RequestParam Long id){
        return user.findUserById(id);
    }

    @RequestMapping("/findname")
    @ResponseBody
    public CommenResp<List<UserResp>> findname( @Valid UserReq userReq){
        CommenResp<List<UserResp>> commenResp = new CommenResp<>();
        commenResp.setContent(user.findUserByName(userReq));
        return commenResp;
    }

    @RequestMapping("/save")
    @ResponseBody
    public String saveuser(@Valid UserSave userReq){
        userReq.setPassword(DigestUtils.md5DigestAsHex(userReq.getPassword().getBytes(StandardCharsets.UTF_8)));
        if (user.userSave(userReq)==1){
            return "保存成功";
        }else{
            return "用户名重复";
        }

    }

    @RequestMapping("/resetPassword")
    @ResponseBody
    public String resetuser(@Valid PasswordResetReq userReset){
        userReset.setPassword(DigestUtils.md5DigestAsHex(userReset.getPassword().getBytes(StandardCharsets.UTF_8)));
        if (user.passwordReset(userReset)==1){
            return "保存成功";
        }else{
            return "异常";
        }

    }

    @RequestMapping("/getredis")
    @ResponseBody
    public UserLoginResp loginuser(String key){
        UserLoginResp user =(UserLoginResp) redisUtils.get(key);
        user.setRestTime(redisUtils.getExpire(key));
        return user;
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommenResp loginuser(@Valid UserLogin userLogin){
        userLogin.setPassword(DigestUtils.md5DigestAsHex(userLogin.getPassword().getBytes(StandardCharsets.UTF_8)));
        CommenResp resp = new CommenResp();

        UserLoginResp userLoginResp = user.userlogin(userLogin);

        Long token = snowflakeIdWorker.nextId();
        userLoginResp.setToken(token);
        userLoginResp.setDate("3600 * 1");
        redisUtils.set(token + "",userLoginResp,3600 * 1);
//        redisTemplate.opsForValue().set(token,userLoginResp,3600 * 24, TimeUnit.SECONDS);
        LOG.info("生成token存入redis:{}",token);

        resp.setContent(userLoginResp);
        return resp;

    }

    @RequestMapping("/logout/{token}")
    @ResponseBody
    public CommenResp logoutuser(@PathVariable String token){
        CommenResp resp = new CommenResp();
        redisUtils.del(token);
        resp.setContent("logout");

        return resp;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Boolean deleteuser(@PathVariable Long id){
        if (user.userDelete(id)==1){
            return true;
        }else{
            return false;
        }

    }
}
