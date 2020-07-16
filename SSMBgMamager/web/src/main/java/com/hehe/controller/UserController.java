package com.hehe.controller;

import com.hehe.domain.Role;
import com.hehe.domain.UserInfo;
import com.hehe.service.RoleService;
import com.hehe.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @RequestMapping("findAll.do")
    public ModelAndView fidnAll(){
        List<UserInfo> users = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String addUser(UserInfo userInfo){
        String encode = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);
        userService.addUser(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView showUserDetail(@RequestParam(value = "id")String id){
        UserInfo userInfo = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
    //查询可添加角色
    @RequestMapping("findAddableRole.do")
    public ModelAndView findAddableRole(@RequestParam(value = "id")String userId){
        ModelAndView mv = new ModelAndView();
        //查询用户
        UserInfo userInfo = userService.findById(userId);
        //查询可以添加的权限
        List<Role> roleLeftList = roleService.findLeft(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roleLeftList);
        mv.setViewName("user-role-add");
        return mv;
    }
    //添加角色
    @RequestMapping("addRoleToUser.do")
    public String addRole(@RequestParam(name = "userId")String userId,@RequestParam(name = "ids")String[] ids){
        System.out.println(userId+"...");
        for (String roleId : ids) {
            userService.addRoleToUser(userId,roleId);
        }
        return "redirect:findAll.do";
    }


}
