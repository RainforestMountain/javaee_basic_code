package org.example.springboot_demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/response")
public class HttpResponse {


    @RequestMapping("/index")
    public String getHtml() {
        return "/index.html";
    }

    @RequestMapping("/json")
    public String getJson() {
        return "/package.json";
    }

    @RequestMapping("/setAttr")
    public String getAttr() {
        return "/setAttr.html";
    }

    @RequestMapping("/getJsCode")

    public String getJsCode() {
        return "/test1.js";
    }
}
