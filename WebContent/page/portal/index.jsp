<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="java.util.*,java.text.*"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>学校通知公告</title>
<link href="${pageContext.servletContext.contextPath}/css/ncss_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="ncss_banner_wrapper">
  <div id="ncss_banner_image"> <img src="http://localhost:8080/ch06/images/b.gif" alt="image" /> </div>
  <div id="ncss_banner_content">
    <div class="header_01">通知公告发布系统 &nbsp;&nbsp;
        <a href="http://localhost:8080/ch06/login.jsp">登录后台</a>
        <a href="http://localhost:8080/ch06/register.jsp">注册!</a> </div>
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
            <c:if test="${empty requestScope.lists}">
                没有公告类别
            </c:if>
            <%--查询所有类型--%>
            <c:forEach items="${requestScope.lists}" var="list">
                <a href="${pageContext.servletContext.contextPath}/getNoticeByTypeId?tno=${list.tno}" target="showNotice">
                        ${list.ttypeName}
                </a><br/>
            </c:forEach>
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
        String formatDate2(Date d){
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            return formater.format(d);
        }
        %>
<%--        查询  搜索功能(通过标题)--%>
        <form action="${pageContext.servletContext.contextPath}/getNoticeByTitle" method="post" target="showNotice">
            <input type="text" name="search" /><input type="submit" value="搜索"/>
        </form>
<%--        查询 搜索功能(通过时间)--%>
        <form action="${pageContext.servletContext.contextPath}/getNoticeByTime" method="post" target="showNotice">
            <input type="date" name="startTime" value="1900-01-01"/>~<input type="date" name="endTime" value="<%=formatDate2(new Date())%>"/><input type="submit" value="查询"/>
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
