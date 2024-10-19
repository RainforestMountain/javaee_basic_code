package org.example.springboot_demo2;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/calc")
@Controller
public class Calc {
    @RequestMapping("")
    public String init() {
        return "/calc.html";
    }

    @ResponseBody
    @RequestMapping("/sum")

    public String add(int num1, int num2, HttpSession session) {
        int sum = num1 + num2;
        session.setAttribute("sum", sum);
        return sum + "";
    }

    @ResponseBody
    @RequestMapping("/getsum")
    public String getSum(HttpSession session) {
        return session.getAttribute("sum") + " ";
    }

//    public static void main(String[] args) {
//        System.out.println("nihao");
//    }
}
