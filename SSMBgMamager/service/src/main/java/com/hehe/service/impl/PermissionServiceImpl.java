package com.hehe.service.impl;

import com.hehe.dao.PermissionDao;
import com.hehe.domain.Permission;
import com.hehe.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    @Transactional
    public void addPermission(Permission permission) {
        permissionDao.addPermission(permission);
    }

    @Override
    public List<Permission> findLeft(String roleId) {
        return permissionDao.findLeft(roleId);
    }

    @Override
    @Transactional
    public void grant(String roleId, String pid) {
        permissionDao.grant(roleId,pid);
    }
}
