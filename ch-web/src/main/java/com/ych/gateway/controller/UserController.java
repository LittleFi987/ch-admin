package com.ych.gateway.controller;

import com.ych.admin.dto.UserDTO;
import com.ych.common.enums.StateEnum;
import com.ych.gateway.helper.PasswordHelper;
import com.ych.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by chenhaoye on 2017/9/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;
    @Resource
    private PasswordHelper passwordHelper;

    @GetMapping("/login")
    public String login(@RequestParam("userName") String userName,
                      @RequestParam("pwd") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            return "success";
        }catch (UnknownAccountException e) {
            System.out.println("账号错误");
        }catch (IncorrectCredentialsException e1) {
            System.out.println("错误的凭证");
        }catch (ExpiredCredentialsException e2) {
            System.out.println("过期的凭证");
        }catch (ExcessiveAttemptsException e3) {
            System.out.println("登录失败次数过多");
        }
        return null;


        /**
         * DisabledAccountException（禁用的帐号）、
         LockedAccountException（锁定的帐号）、
         UnknownAccountException（错误的帐号）、
         ExcessiveAttemptsException（登录失败次数过多）、
         IncorrectCredentialsException（错误的凭证）、
         ExpiredCredentialsException（过期的凭证）
         */
    }


    @GetMapping("regist")
    public void regist(@RequestParam("username") String username,
                       @RequestParam("pwd") String password){
        UserDTO userDTO = new UserDTO();
        userDTO.setCreateTime(new Date());
        userDTO.setPwd(password);
        userDTO.setUserName(username);
        userDTO.setNickName("test");
        userDTO.setState(StateEnum.INVALID.getCode());
        userDTO.setUpdateTime(new Date());
        passwordHelper.encryptPassword(userDTO);
        userService.createUser(userDTO);

    }

}
