package com.zhbit.notice.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhbit.notice.pojo.User;
import com.zhbit.notice.biz.UserBiz;

public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6971717725995508517L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserBiz userBiz = new UserBiz();
		User loginUser = userBiz.login(userName,password);
		if (loginUser!=null){
			request.getSession().setAttribute("LOGINED_USER", loginUser);
	 		response.sendRedirect("http://localhost:8080/ch06/page/system/backIndex.jsp");
	 	}else{
	 		request.setAttribute("message", "????????????????????????");
	 		request.getRequestDispatcher("login.jsp").forward(request, response);
	 } 

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
