package org.example.mybatis.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.mybatis.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from userinfo")
    public List<UserInfo> queryAllUser();

    @Select("select username, `password`, age, gender, phone from userinfo where id= #{id}")
    public UserInfo queryById(Integer id);

    @Select("select * from userinfo where id = #{id1} and age = #{age1}")
    public List<UserInfo> query(@Param("id1") Integer id, @Param("age1") Integer age);
}
