package com.zhbit.notice.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhbit.notice.pojo.Notice;
import com.zhbit.notice.pojo.Type;
import com.zhbit.notice.biz.NoticeBiz;
import com.zhbit.notice.biz.TypeBiz;
import com.zhbit.notice.pojo.User;

public class NoticeServlet extends HttpServlet {

	private static final long serialVersionUID = 2884006783308811985L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		if ("showNotice".equals(method))
			doShowNotice(request, response);
		else if ("showNoticeDetail".equals(method))
			doShowNoticeDetail(request, response);
		else if ("showAllNotice".equals(method))
			doShowAllNotice(request, response);
		else if ("showAddNotice".equals(method))
			doShowAddNotice(request, response);
		else if ("addNotice".equals(method))
			doAddNotice(request, response);
		else if ("deleteNotice".equals(method))
			doDeleteNotice(request, response);
		else if ("showNoticeDetailForModify".equals(method))
			doShowNoticeDetailForModify(request, response);
		else if ("updateNotice".equals(method))
			doUpdateNotice(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	private void doShowNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		NoticeBiz noticeBiz = new NoticeBiz();
		List<Notice> list = noticeBiz.getNoticeByTypeId(typeId);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/page/portal/showNoticeByType.jsp").forward(request, response);
	}
	
	private void doShowNoticeDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		NoticeBiz noticeBiz = new NoticeBiz();
		Notice notice = noticeBiz.getNoticeById(noticeId);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/page/portal/showNoticeDetailByID.jsp").forward(request, response);
	}
	

	private void doShowNoticeDetailForModify(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException   {
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		TypeBiz typeBiz = new TypeBiz();
		List<Type> typeList = typeBiz.getAllType();
		request.setAttribute("list", typeList);
		NoticeBiz noticeBiz = new NoticeBiz(); 
		Notice notice = noticeBiz.getNoticeById(noticeId); 
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("page/system/noticeEdit.jsp").forward(request, response);
	}

	private void doUpdateNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		String title = request.getParameter("title");
		String editor=request.getParameter("editor");
		String content=request.getParameter("content");
		int type=Integer.parseInt(request.getParameter("type"));
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		Notice notice =new Notice();
		notice.setNno(noticeId);
		notice.setNcontent(content);
		notice.setNeditor(editor);
		notice.setNtitle(title);
		notice.setNtype(type);
		notice.setNcreateTime(new java.sql.Date(new Date().getTime()));
		NoticeBiz noticeBiz = new NoticeBiz();
		if (noticeBiz.updateNotice(notice)){
			List<Notice> list = noticeBiz.getAllNotice();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/page/system/showAllNoticeList.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/page/system/error.jsp").forward(request, response);
		}
	}

	private void doDeleteNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		int noticeId = Integer.parseInt(request.getParameter("noticeId"));
		NoticeBiz noticeBiz = new NoticeBiz();
		if (noticeBiz.deleteNotice(noticeId)){
			List<Notice> list = noticeBiz.getAllNotice();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/page/system/showAllNoticeList.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/page/system/error.jsp").forward(request, response);
		}
	}

	private void doShowAddNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		TypeBiz typeBiz = new TypeBiz();
		List<Type> typeList = typeBiz.getAllType();
		request.setAttribute("list", typeList);
		request.getRequestDispatcher("page/system/noticeAdd.jsp").forward(request, response);
	}

	private void doAddNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		String title = request.getParameter("title");
		String editor=request.getParameter("editor");
		String content=request.getParameter("content");
		int type=Integer.parseInt(request.getParameter("type"));
		Notice notice =new Notice();
		notice.setNcontent(content);
		notice.setNeditor(editor);
		notice.setNtitle(title);
		notice.setNtype(type);
		notice.setUser((User) request.getSession().getAttribute("LOGINED_USER"));
		notice.setNcreateTime(new java.sql.Date(new Date().getTime()));
		NoticeBiz noticeBiz = new NoticeBiz();
		if (noticeBiz.addNotice(notice)){
			List<Notice> list = noticeBiz.getAllNotice();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/page/system/showAllNoticeList.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/page/system/error.jsp").forward(request, response);
		}
	}

	private void doShowAllNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException  {
		NoticeBiz noticeBiz = new NoticeBiz();
		List<Notice> list = noticeBiz.getAllNotice();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/page/system/showAllNoticeList.jsp").forward(request, response);
	}	
}
