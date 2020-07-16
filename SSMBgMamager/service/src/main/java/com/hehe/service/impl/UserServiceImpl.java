package com.hehe.service.impl;

import com.hehe.dao.UserDao;
import com.hehe.domain.Role;
import com.hehe.domain.UserInfo;
import com.hehe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            UserInfo user = userDao.findByUserName(username);
            userInfo = user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public List<UserInfo> findAll(){
        return userDao.findAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userDao.addUser(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void addRoleToUser(String userId, String roleId) {
        userDao.addRoleToUser(userId,roleId);
    }


}
