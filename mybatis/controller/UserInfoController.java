package org.example.mybatis.controller;

import org.example.mybatis.model.UserInfo;
import org.example.mybatis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sqltest")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    @ResponseBody
    @RequestMapping("/queryAllUser")
    public List<UserInfo> queryAllUser() {
        return service.queryAllUser();
    }

    @ResponseBody
    @RequestMapping("/queryById")
    public UserInfo queryById(Integer id) {
        return service.queryById(id);
    }
}
