package com.hehe.controller;

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
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RoleService roleService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissions = permissionService.findAll();
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String add(Permission permission){
        permissionService.addPermission(permission);
        return "redirect:findAll.do";
    }

}
