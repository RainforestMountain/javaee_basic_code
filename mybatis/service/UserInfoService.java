package org.example.mybatis.service;

import org.example.mybatis.Dao.UserInfoMapper;
import org.example.mybatis.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper mapper;

    public List<UserInfo> queryAllUser() {
        return mapper.queryAllUser();
    }

    public UserInfo queryById(Integer id) {
        return mapper.queryById(id);
    }
}
