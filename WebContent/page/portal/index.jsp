<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.text.*,com.zhbit.notice.pojo.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>学校通知公告</title>
<link href="http://localhost:8080/ch06/css/ncss_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="ncss_banner_wrapper">
  <div id="ncss_banner_image"> <img src="http://localhost:8080/ch06/images/b.gif" alt="image" /> </div>
  <div id="ncss_banner_content">
    <div class="header_01">通知公告发布系统 &nbsp;&nbsp; <a href="http://localhost:8080/ch06/login.jsp">登录后台</a> <a href="http://localhost:8080/ch06/register.jsp">注册!</a> </div>
  </div>
</div>
<!-- end of banner -->

<div id="ncss_content_wrapper">
  <div id="ncss_content">
    <div id="column_w300">
      <div class="header_03">通知公告类别</div>
      <div class="column_w300_section_01">
        <div class="notice_image_wrapper"> <img src="http://localhost:8080/ch06/images/ncss_image_03.jpg" alt="image" /> </div>
        <div class="notice_content">
        <%
        	List<Type> list = (List<Type>)request.getAttribute("list");
        	if (list!=null && list.size()!=0){
        		for (Type type: list){
		%>
    			   <a href="http://localhost:8080/ch06/noticeServlet?method=showNotice&typeId=<%=type.getTno()%>" target="showNotice"><%=type.getTtypeName() %></a>;
       			   <br />		
		<%	
        	}}else{
        		out.print("没有公告类别");
        	} 
         %> 
        </div>
        <div class="cleaner"></div>
      </div>
      <div class="cleaner"></div>
    </div>
    <!-- end of column_w300 -->
    
    <div id="column_w530">
      <%!
      	String formatDate(Date d){
      		SimpleDateFormat formater = new SimpleDateFormat("yyyy年MM月dd日");
      		return formater.format(d);
      	}
       %>
        <form action="http://localhost:8080/ch06/noticeServlet" method="post" target="showNotice">
            <input type="hidden" name="method" value="showNoticeByTitle" />
            <input type="text" name="search" /><input type="submit" value="搜索"/>
        </form>
      <div class="header_02">欢迎访问通知公告发布系统&nbsp;现在是<%=formatDate(new Date()) %></div>
      <div class="content_section_01">
        <div>
          <iframe name="showNotice" frameborder=0 width=400 height=300 marginheight=0 marginwidth=0 scrolling=no src="http://localhost:8080/ch06/page/portal/nullList.html"  ></iframe>
        </div>
      </div>
      <div class="cleaner"></div>
    </div>
    <!-- end of column_w530 -->
    <div class="cleaner"></div>
  </div>
  <!-- end of ncss_content --> 
</div>
<!-- end of content wrapper -->
<div id="ncss_footer_wrapper">
  <div class="margin_bottom_15"></div>
  <%
  	Integer count = (Integer)application.getAttribute("count");
  	if (count!=null){
  		count++;
  	}else{
  		count = 1;
  	}
  	application.setAttribute("count", count);
   %>
  Copyright ? 2013 <a href="#">ccec</a> | Designed by <a href="#" target="_parent">JSP WEB</a>|该网站的访问量为：<%=count %>
  <div class="cleaner"></div>
</div>
<!-- end of footer -->
</body>
</html>
