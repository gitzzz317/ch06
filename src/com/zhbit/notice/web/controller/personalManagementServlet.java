package com.zhbit.notice.web.controller;

import com.zhbit.notice.biz.UserBiz;
import com.zhbit.notice.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class personalManagementServlet extends HttpServlet {

    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserBiz userBiz = context.getBean("userBiz",UserBiz.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Uno = Integer.parseInt(request.getParameter("Uno"));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
//        UserBiz userBiz = new UserBiz();
        userBiz.updateUser(Uno , userName,password);
        User user = userBiz.getUserById(Uno);
        request.getSession().setAttribute("LOGINED_USER", user);
        response.sendRedirect("http://localhost:8080/ch06/page/system/backIndex.jsp");

    }
}
