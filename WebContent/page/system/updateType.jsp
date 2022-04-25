<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2022/4/1/001
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改公告类型</title>
</head>
<%
    String tno = request.getParameter("Tno");
    String TtypeName = request.getParameter("TtypeName");
%>
<body>
    <form action="${pageContext.servletContext.contextPath}/updateType" method="post">
        <input type="hidden" name="Tno" value="<%=tno%>" />
        <input type="hidden" name="method" value="updateType" />
        <table>
            <tr>
                <td>需要修改的公告类型：</td>
                <td><input type="text" name="TtypeName" value="<%=TtypeName%>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"></td>
                <td><input type="reset" value="重置"></td>
                <td><a href="${pageContext.servletContext.contextPath}/getAllTypeManagement">返回</a></td>
            </tr>
        </table>
    </form>
</body>
</html>
