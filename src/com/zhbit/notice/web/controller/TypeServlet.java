package com.zhbit.notice.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhbit.notice.biz.TypeBiz;
import com.zhbit.notice.pojo.Type;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 3874739343783059139L;
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	Type type = context.getBean("type" , Type.class);
	TypeBiz typeBiz =  context.getBean("typeBiz", TypeBiz.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		switch (method)
		{
			case "addType":
				doAddType(request,response);break;
			case "deleteType":
				doDeleteType(request,response);break;
			case "updateType":
				doUpdateType(request,response);break;
			case "getAllType":
			default:
				doGetAllType(request,response);break;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void doGetAllType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		TypeBiz typeBiz = new TypeBiz();
		List<Type> typeList = typeBiz.getAllType();
		request.setAttribute("list", typeList);
		request.getRequestDispatcher("/page/portal/index.jsp").forward(request, response);
	}

	private void doAddType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
//		TypeBiz typeBiz = new TypeBiz();
		typeBiz.addType(type);
		response.sendRedirect("http://localhost:8080/ch06/page/system/typeManagement.jsp");
	}
	private void doUpdateType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("Tno"));
		String ttypeName = request.getParameter("TtypeName");
//		Type type = new Type(tno, ttypeName);
//		TypeBiz typeBiz = new TypeBiz();
		type.setTno(tno);
		type.setTtypeName(ttypeName);
		typeBiz.updateType(type);
		response.sendRedirect("http://localhost:8080/ch06/page/system/typeManagement.jsp");
	}
	private void doDeleteType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("Tno"));
//		TypeBiz typeBiz = new TypeBiz();
		typeBiz.deleteType(tno);
		response.sendRedirect("http://localhost:8080/ch06/page/system/typeManagement.jsp");
	}
}
