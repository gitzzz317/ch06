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
<%
    TypeBiz typeBiz = new TypeBiz();
    List<Type> allType = typeBiz.getAllType();
%>
<body>
    <form action="http://localhost:8080/ch06/typeServlet" method="post">
        <input type="hidden" name="method" value="addType" />
        <table>
            <tr>
                <th>现有公告类别<%=allType.size()%>类</th>
            </tr>
            <%
                for (int i = 0; i < allType.size(); i++) {
            %>
            <tr>
                <td><%=allType.get(i).getTtypeName()%></td>
                <td><a href="http://localhost:8080/ch06/page/system/updateType.jsp?Tno=<%=allType.get(i).getTno()%>&TtypeName=<%=allType.get(i).getTtypeName()%>">修改</a></td>
                <td><a href="http://localhost:8080/ch06/typeServlet?method=deleteType&Tno=<%=allType.get(i).getTno()%>">删除</a></td>
            </tr>
            <%
                }
            %>
            <tr>
                <td><input type="text" name="type">  <input type="submit" value="添加"></td>
                <td><a href="http://localhost:8080/ch06/page/system/backIndex.jsp">返回</a></td>
            </tr>
        </table>

    </form>

</body>
</html>
