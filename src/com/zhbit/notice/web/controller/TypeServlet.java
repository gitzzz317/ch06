package com.zhbit.notice.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhbit.notice.pojo.Type;
import com.zhbit.notice.biz.TypeBiz;

public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 3874739343783059139L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TypeBiz typeBiz = new TypeBiz();
		List<Type> typeList = typeBiz.getAllType();
		request.setAttribute("list", typeList);
		request.getRequestDispatcher("/page/portal/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
