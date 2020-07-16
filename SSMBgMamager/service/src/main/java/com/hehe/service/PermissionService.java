package com.hehe.service;

import com.hehe.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void addPermission(Permission permission);

    List<Permission> findLeft(String roleId);

    void grant(String roleId, String pid);
}
