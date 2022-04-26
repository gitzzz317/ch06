<%@ page import="com.zhbit.notice.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2022/3/31/031
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
    欢迎您${requestScope.registerUser.uname},注册成功！
    <a href="login.jsp">请前往登录！</a>
</body>
</html>
