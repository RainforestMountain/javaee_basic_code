package org.example.springboot_demo2;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("/messagewall")
@Controller
public class MessageWall {
    private List<MessageInfo> mList = new ArrayList<>();

    @RequestMapping("")
    public String wall() {
        return "/messagewall.html";
    }

    @ResponseBody
    @RequestMapping("/getList")
    public List<MessageInfo> getMessageInfo() {
        return mList;
    }

    @ResponseBody
    @RequestMapping("/publish")
    public boolean publish( MessageInfo messageInfo) {
        System.out.println(messageInfo);
        if (StringUtils.hasLength(messageInfo.getTo()) && StringUtils.hasLength(messageInfo.getFrom()
        ) && StringUtils.hasLength(messageInfo.getMessage())) {
            mList.add(messageInfo);
            return true;
        }
        return false;
    }
}
