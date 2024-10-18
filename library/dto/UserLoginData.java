package org.example.library.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Setter
@Getter
public class UserLoginData {
    private HashMap<String, String> userManage;

    public UserLoginData() {
        userManage = new HashMap<>();
        userManage.put("zhangsan", "123456");
        userManage.put("lisi", "123456");
    }

}