<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.zhbit.notice.pojo.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>通知公告内容</title>
<link href="http://localhost:8080/ch06/css/ncss_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	Notice notice = (Notice)request.getAttribute("notice");  
	if (notice==null){
 %>
 <div>对应通知公告没有找到或已删除！</div>
 <% } else { 
 %>
 	标题：<%= notice.getNtitle() %><br />
 	作者：<%= notice.getNeditor() %><br />
 	时间：<%= notice.getNcreateTime() %><br />
 	内容：<%= notice.getNcontent() %>
 <%		
  }	 
 %>
</body>
</html>