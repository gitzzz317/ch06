<%@ page import="com.zhbit.notice.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2022/3/31/031
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息管理</title>
</head>
<body>
    <%
        User logined_user = (User) request.getSession().getAttribute("LOGINED_USER");
    %>
    <form action="personalManagementServlet" method="post">
        <input type="text" value="<%=logined_user.getUno()%>" hidden="hidden" name="Uno">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" value="<%=logined_user.getUname()%>" name="userName"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" value="<%=logined_user.getUpassword()%>" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
        <a href="page/system/backIndex.jsp">返回</a>
    </table>
    </form>
</body>
</html>
