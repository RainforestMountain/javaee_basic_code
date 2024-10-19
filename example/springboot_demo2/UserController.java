package org.example.springboot_demo2;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        //校验账号和密码   假设 账号为: zhangsan, 密码为123456
        if ("zhangsan".equals(userName) && "123456".equals(password)) {
            //存储Session
            session.setAttribute("userName", userName);//key, val
            System.out.println(true);
            return true;
        }

        return false;
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo(HttpSession session){
        String userName = (String) session.getAttribute("userName");
        System.out.println("登录用户:"+ userName);
        return userName==null?"":userName;
    }
}
