package com.example.wiki.service;

import com.example.wiki.Resp.UserLoginResp;
import com.example.wiki.Resp.UserResp;
import com.example.wiki.Utils.CopyUtil;
import com.example.wiki.config.SnowflakeIdWorker;
import com.example.wiki.entity.User;
import com.example.wiki.entity.UserExample;
import com.example.wiki.exception.CommonException;
import com.example.wiki.exception.CommonExceptionCode;
import com.example.wiki.mapper.UserMapper;
import com.example.wiki.req.PasswordResetReq;
import com.example.wiki.req.UserLogin;
import com.example.wiki.req.UserReq;
import com.example.wiki.req.UserSave;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper user;

//    @Resource
//    private IdWorker snowId = new IdWorker(1,1,0);

    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<User> findUserAll() {

        return user.selectByExample(null);
    }

    public User findUserById(Long id) {

        return user.selectByPrimaryKey(id);
    }

    public List<UserResp> findUserByName(UserReq userReq) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(userReq.getLoginName() != null){
            criteria = criteria.andLoginNameEqualTo(userReq.getLoginName());
        }

        List<User> users = user.selectByExample(userExample);
        List<UserResp> userRespList = new ArrayList<>();
        userRespList = CopyUtil.copyList(users, UserResp.class);

        return userRespList;
    }

    public Integer userSave(UserSave userReq){
        User user1 = CopyUtil.copy(userReq,User.class);

        if(ObjectUtils.isEmpty(userReq.getId())){
          if (ObjectUtils.isEmpty(selectByusername(user1.getLoginName()))){
              user1.setId(snowflakeIdWorker.nextId());
              return user.insert(user1);
          }else {
              throw new CommonException(CommonExceptionCode.USER_LOGIN_NAME_EXESIT);
          }

        }else {
            user1.setLoginName(null);//清空loginname使账户不修改用户名
            user1.setPassword(null);
           return user.updateByPrimaryKeySelective(user1);
        }
    }

    public Integer passwordReset(PasswordResetReq passwordResetReq){
        User user1 = CopyUtil.copy(passwordResetReq,User.class);

        if (ObjectUtils.isEmpty(findUserById(passwordResetReq.getId()))){
            throw new CommonException(CommonExceptionCode.USER_ID_NOT_EXESIT);
        }else {
            return user.updateByPrimaryKeySelective(user1);
        }

    }

    public UserLoginResp  userlogin(UserLogin userLogin){
        User userlgn = selectByusername(userLogin.getLoginName());
        if(ObjectUtils.isEmpty(userlgn)){
            throw new CommonException(CommonExceptionCode.USER_LOGIN_ERROR);
        }else {
            if(userlgn.getPassword().equals(userLogin.getPassword())){
                return CopyUtil.copy(userlgn,UserLoginResp.class);
            }else {
                throw new CommonException(CommonExceptionCode.USER_LOGIN_ERROR);

            }
        }


    }

    public Integer userDelete(Long id){
        return user.deleteByPrimaryKey(id);
    }

    public User selectByusername(String username){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria = criteria.andLoginNameEqualTo(username);
        List<User> users = user.selectByExample(userExample);
        if(CollectionUtils.isEmpty(users)){
            return null;
        }else {
            return users.get(0);
        }


    }


}
