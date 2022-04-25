<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.zhbit.notice.pojo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
<c:if test="${not empty requestScope.LOGINED_USER}">
	<c:set scope="session" var="LOGINED_USER" value=""></c:set>
	<c:remove var="LOGINED_USER" scope="session"></c:remove>
</c:if>

<%
	
	User loginUser = (User)session.getAttribute("LOGINED_USER");
	if (loginUser!=null){
		session.setAttribute("LOGINED_USER",null);
		session.removeAttribute("LOGINED_USER");
	}
	session.invalidate();
	response.sendRedirect("http://localhost:8080/ch06/index.jsp");
 %>

</body>
</html>