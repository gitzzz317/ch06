<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.zhbit.notice.biz.TypeBiz" %>
<%@ page import="com.zhbit.notice.pojo.Type" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2022/3/31/031
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告类别管理</title>
</head>
<body>

    <form action="${pageContext.servletContext.contextPath}/addType" method="post">
        <table>
            <tr>
                <th>现有公告类别${requestScope.lists.size()}类</th>
            </tr>
                <c:forEach items="${requestScope.lists}" var="list">
                 <tr>
                     <td>
                         ${list.ttypeName}
                     </td>
                     <td>
                         <a href="${pageContext.servletContext.contextPath}/page/system/updateType.jsp?Tno=${list.tno}&TtypeName=${list.ttypeName}">
                             修改
                         </a>
                     </td>
                     <td>
                         <a href="${pageContext.servletContext.contextPath}/deleteType?Tno=${list.tno}">
                             删除
                         </a>
                     </td>
                 </tr>
                </c:forEach>
            <tr>
                <td>
                    <input type="text" name="type"> <input type="submit" value="添加">
                </td>

            </tr>
            <tr>
                <td>
                    <a href="http://localhost:8080/ch06/page/system/backIndex.jsp">
                        返回
                    </a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
