<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  errorPage="error.jsp" %>
<%@ page import="java.util.*,com.zhbit.notice.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知公告列表</title>
<link href="css/ncss_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	List<Notice> list = (List<Notice>)request.getAttribute("list");
	if (list!=null&&list.size()!=0){
 %>
	<table border="0">
	<tr>
		<td>通知标题	</td><td>操作</td>
	</tr> 
	<%
		for (Notice notice: list){
	%>
	<tr>
	<td>
 		<a href="noticeServlet?method=showNoticeDetail&noticeId=<%=notice.getNno()%>" target="showNotice"><%=notice.getNtitle()%></a>
	</td> 		
	<td>
		<a href="noticeServlet?method=showNoticeDetailForModify&noticeId=<%=notice.getNno()%>"  target="showNotice">修改</a>
		<a href="noticeServlet?method=deleteNotice&noticeId=<%=notice.getNno()%>"  target="showNotice">删除</a>
	</td>
 	</tr>
 	<%
 		}
 	}else{
 		out.print("没有记录");
 	}	
 	 %>
	</table>
</body>
</html>
