package com.hehe.dao;

import com.hehe.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from role where id in(select roleId from users_role where userId = #{id})")
    @Results({
            @Result(column = "id",property = "permissions",many = @Many(select = "com.hehe.dao.PermissionDao.findByIds"))
    })
    List<Role> findByIds(String userId);

    @Select("select * from role")
    List<Role> findAll();
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc}) ")
    void addRole(Role role);

    @Select("select * from role where id not in(select roleId from users_role where userId = #{id})")
    List<Role> findLeft(String userId);

    @Select("select * from role where id = #{roleId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "permissions", many = @Many(select = "com.hehe.dao.PermissionDao.findByIds"))
    })
    Role findById(String roleId);

}
