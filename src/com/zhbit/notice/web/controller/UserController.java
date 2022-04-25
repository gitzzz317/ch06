package com.zhbit.notice.web.controller;

import com.zhbit.notice.biz.UserBiz;
import com.zhbit.notice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserBiz userBiz;
    //登录功能  查询用户（通过用户名和密码）
    @RequestMapping("/login")
    public String login(String userName, String password, Model model , HttpSession session) {
        User loginUser = userBiz.login(userName, password);
        if (loginUser != null) {
            session.setAttribute("LOGINED_USER", loginUser);
            return "page/system/backIndex";
        } else {
            model.addAttribute("message", "账号或密码错误请重新登录！");
            return "login";
        }
    }
    //注册功能  添加用户
    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    public String addUser(String userName,String password,Model model){
        userBiz.register(userName,password);
        User registerUser = userBiz.login(userName,password);
        if (registerUser!=null){
            model.addAttribute("registerUser", registerUser);
            return "registerSuccess";
        }else{
            model.addAttribute("message", "注册失败！请重试");
            return "register";
        }
    }
    //个人信息管理功能 修改用户个人信息
    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpSession session){
        userBiz.updateUser(user.getUno() , user.getUname(),user.getUpassword());
        User updateUser = userBiz.getUserById(user.getUno());
        session.setAttribute("LOGINED_USER", updateUser);
        return "page/system/backIndex";
    }
}
