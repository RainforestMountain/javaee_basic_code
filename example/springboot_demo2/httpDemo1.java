package org.example.springboot_demo2;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/test")
@RestController
public class httpDemo1 {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/param1")
    public Integer fun1(Integer age) {
        System.out.println(age);
        return age;
    }

    @PostMapping("/param2")
    public String fun2(String userName, String password, Integer age) {
        return "userName :" + userName + " passWord : " + password + " age :" + age;
    }

    @RequestMapping("/param3")
    public String fun3(int[] array) {
        return "array: " + Arrays.toString(array);
    }

    @RequestMapping("/param4")
    public String fun4(@RequestParam List<Integer> lists) {
        return "list : " + lists;
    }

    @RequestMapping("/param5")
    public String fun5(@RequestBody org.example.springboot_demo2.Person person) {
        return person.toString();
    }

    @RequestMapping("/param6/{userName}/{password}")//空格都要有要求
    public String fun6(@PathVariable String userName, @PathVariable String password) {
        return "获取Url参数: " + "userName : " + userName + " password : " + password;
    }

    @RequestMapping("/param7")
    public String getfile(@RequestPart("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();//getName()是参数名
        file.transferTo(new File("D:/temp/" + file.getOriginalFilename()));
        return "接收到文件名称为: " + fileName;
    }

    @RequestMapping("/param8")
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " = " + cookie.getValue());
            }
        }
        return "获取到cookie";
    }

    @RequestMapping("/param9")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        session.setAttribute("zhangsan", "12");
        session.setAttribute("java", "111");

        return "设置成功";

    }

    @RequestMapping("/param10")
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session!= null) {
            System.out.println(session.getAttribute("zhangsan"));
            System.out.println(session.getAttribute("java"));
        }
        return "获取成功";

    }



}
