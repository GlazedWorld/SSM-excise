package com.hehe.dao;

import com.hehe.domain.Permission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<Permission> findByIds(String roleId);

    @Select("select * from permission")
    List<Permission> findAll();


    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void addPermission(Permission permission);

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId = #{id})")
    List<Permission> findLeft(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{pid})")
    void grant(@Param("roleId") String roleId, @Param("pid") String pid);
}
