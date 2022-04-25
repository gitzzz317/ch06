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
    <form action="${pageContext.servletContext.contextPath}/updateUser" method="post">
        <input type="text" value="${sessionScope.LOGINED_USER.uno}" hidden="hidden" name="uno">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" value="${sessionScope.LOGINED_USER.uname}" name="uname"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" value="${sessionScope.LOGINED_USER.upassword}" name="upassword"></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
        <a href="http://localhost:8080/ch06/page/system/backIndex.jsp">返回</a>
    </table>
    </form>
</body>
</html>
