package com.zhbit.notice.web.controller;

import com.zhbit.notice.biz.UserBiz;
import com.zhbit.notice.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerServlet extends HttpServlet {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserBiz userBiz = context.getBean("userBiz",UserBiz.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
//        UserBiz userBiz = new UserBiz();
        userBiz.register(userName,password);
        User registerUser = userBiz.login(userName,password);
        if (registerUser!=null){
            request.setAttribute("registerUser", registerUser);
            request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
        }else{
            request.setAttribute("message", "注册失败！请重试");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
