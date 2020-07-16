package com.hehe.controller;

import com.hehe.dao.RoleDao;
import com.hehe.domain.Permission;
import com.hehe.domain.Role;
import com.hehe.service.PermissionService;
import com.hehe.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("findAll.do")
    public ModelAndView showAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String addRole(Role role){
        roleService.addRole(role);
        return "redirect:findAll.do";
    }
    //查找当前角色可添加权限
    @RequestMapping("findAddablePermission.do")
    public ModelAndView findAddablePermission(@RequestParam(name = "id") String roleId){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(roleId);
        List<Permission> permissionList = permissionService.findLeft(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("grantToRole.do")
    public String grantToRole(@RequestParam(name = "roleId") String roleId,@RequestParam(name = "pids") String[] pids){
        for (String pid : pids) {
            permissionService.grant(roleId,pid);
        }
        return "redirect:findAll.do";
    }
}
