<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通知公告列表</title>
<link href="http://localhost:8080/ch06/css/ncss_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table border="0">
		<tr>
			<td>通知标题	</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.list}" var="list">
			<tr>
				<td>
					<a href="${pageContext.servletContext.contextPath}/getNoticeById?nno=${list.nno}">${list.ntitle}</a>
				</td>
				<td>
					<a href="${pageContext.servletContext.contextPath}/getNoticeByTypeIdUpdate?nno=${list.nno}"  target="showNotice">
						修改
					</a>
					<a href="${pageContext.servletContext.contextPath}/deleteNotice?nno=${list.nno}"  target="showNotice">
						删除
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
