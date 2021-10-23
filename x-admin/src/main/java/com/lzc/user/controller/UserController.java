package com.lzc.user.controller;


import com.lzc.user.pojo.User;
import com.lzc.user.service.UserService;
import com.lzc.common.vo.Result;
import com.wf.captcha.utils.CaptchaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequestMapping("/user")
class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(User user, HttpSession session, String verCode, HttpServletRequest request){

        if (!CaptchaUtil.ver(verCode, request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            return Result.fail("验证码错误");
        }

        User loginUser = userService.login(user);
        if(loginUser!=null){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            //加密判断
            boolean matches = bCryptPasswordEncoder.matches(user.getPassword(), loginUser.getPassword());
            System.out.println(matches);
            if (matches) { //密码相同成功
                loginUser.setPassword(null);
                session.setAttribute("user", loginUser);
                return Result.success();
            }
        }
        return Result.fail("账号不存在或密码不正确");
    }
}
