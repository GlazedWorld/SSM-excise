package com.hehe.service.impl;

import com.hehe.dao.RoleDao;
import com.hehe.domain.Role;
import com.hehe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public List<Role> findLeft(String userId) {
        return roleDao.findLeft(userId);
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }
}
