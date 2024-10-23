package org.example.mybatis.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer delete_flag;
    private Date create_time;
    private Date update_time;
}
