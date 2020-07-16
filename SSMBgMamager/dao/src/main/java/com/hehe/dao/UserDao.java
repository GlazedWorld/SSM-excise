package com.hehe.dao;

import com.hehe.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from users where username=#{username} ")
    @Results({
     @Result(column = "id",property = "roles",many = @Many(select = "com.hehe.dao.RoleDao.findByIds"))
    })
    UserInfo findByUserName(String username);


    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void addUser(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.hehe.dao.RoleDao.findByIds"))
    })
    UserInfo findById(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

}
