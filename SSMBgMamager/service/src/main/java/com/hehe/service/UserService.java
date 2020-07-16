package com.hehe.service;

import com.hehe.domain.Role;
import com.hehe.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<UserInfo> findAll();

    void addUser(UserInfo userInfo);

    UserInfo findById(String id);

    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);

}
