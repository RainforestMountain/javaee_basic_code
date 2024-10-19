package org.example.springboot_demo2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sum")
@RestController
public class Example1_2 {
    @RequestMapping("/getAnswer")
    public String sum(int num1, int num2) {
        return "num1 + " + "num2 = " + (num1 + num2) + " \n";
    }


}
