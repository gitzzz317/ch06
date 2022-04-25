<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:if test="${empty requestScope.lists}">
    没有记录
</c:if>
<c:forEach items="${requestScope.lists}" var="list">
    <a href="${pageContext.servletContext.contextPath}/getNoticeById?nno=${list.nno}">
        ${list.ntitle}
    </a><br />
</c:forEach>
</body>
</html>