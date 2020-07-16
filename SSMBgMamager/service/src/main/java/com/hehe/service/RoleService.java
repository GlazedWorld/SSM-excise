package com.hehe.service;

import com.hehe.domain.Role;

import java.util.List;
public interface RoleService {
    List<Role> findAll();

    void addRole(Role role);
    //查询给定id以外的角色
    List<Role> findLeft(String userId);

    Role findById(String roleId);
}
