package org.example.library.service;

import org.example.library.dto.UserLoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class Login {
    @Autowired
    private UserLoginData userLoginData;

    public String check(String userName, String password) {
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return "用户名或者密码不能为空";
        }
        if (!userLoginData.getUserManage().containsKey(userName)) {
            return "不存在用户";
        }
        if (!userLoginData.getUserManage().get(userName).equals(password)) {
            return "密码错误";
        }
        return "登录成功";
    }
}
