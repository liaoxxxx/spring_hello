package com.liaoxx.spring_hello.service.user;

import com.liaoxx.spring_hello.component.Audience;
import com.liaoxx.spring_hello.constants.LoginType;
import com.liaoxx.spring_hello.constants.MainState;
import com.liaoxx.spring_hello.entity.user.UserDto;
import com.liaoxx.spring_hello.export.api.user.LoginExport;
import com.liaoxx.spring_hello.entity.user.User;
import com.liaoxx.spring_hello.param.api.user.LoginParam;
import com.liaoxx.spring_hello.repository.UserRepository;
import com.liaoxx.spring_hello.exception.ServiceException;
import com.liaoxx.spring_hello.util.JwtTokenUtil;
import com.liaoxx.spring_hello.util.Md5Tool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService  {
    @Resource
    UserRepository userRepository;

    @Resource
    Audience audience;


    public LoginExport loginMain(LoginParam param) throws Exception {
        LoginExport loginDto = new LoginExport();
        if (Objects.equals(param.mms, LoginType.PHONE)) {
            loginDto.token = this.loginByPhone(param.phone, param.password);
        }else {
            throw new ServiceException("未知的登陆方式");
        }
        return loginDto;
    }

    public String loginByPhone(String phone, String password) throws Exception {
        User user = userRepository.findFirstByPhoneOrderByIdDesc(phone);
        if (user.getId()<=0){
            throw new ServiceException("用户不存在");
        }
        if (user.getState()!= MainState.StateOK){
            throw new ServiceException("用户已禁用");
        }
        if (!user.getPassword().equals(Md5Tool.get(password + user.getSalt()))) {
            throw new ServiceException("密码错误");
        }
        return JwtTokenUtil.createJWT(user,audience);
    }

    public UserDto find(int userId) {
        Optional<User> user= userRepository.findById(userId);
        return new UserDto( ).fromEntity(user.get());
    }


    public UserDto findFull(int userId) {
        Optional<User> user= userRepository.findById(userId);
        return new UserDto( ).fromEntity(user.get());
    }




}
