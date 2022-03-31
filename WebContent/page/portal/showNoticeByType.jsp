<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.zhbit.notice.pojo.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>通知公告列表</title>
<link href="http://localhost:8080/ch06/css/ncss_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	List<Notice> list = (List<Notice>)request.getAttribute("list");
	if (list==null || list.size()==0){
 %>
 <div>没有记录</div>
 <% } else { 
	for (Notice notice: list){
 %>
 	<a href="http://localhost:8080/ch06/noticeServlet?method=showNoticeDetail&noticeId=<%=notice.getNno()%>"><%=notice.getNtitle()%></a><br />
 <%		
	}
  }	 
 %>
</body>
</html>