<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2022/3/31/031
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" language="javascript">
        function checkRegister(){
            var userName = document.getElementById("userName").value;
            var password = document.getElementById("password").value;
            if (userName==null || userName==""){
                alert("用户名不能为空！");
                return false;
            }else if (password==null || password==""){
                alert("密码不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<div style="font-color:red"></div>
<form id="register" name="register" action="http://localhost:8080/ch06/registerServlet" onsubmit="javascript: return checkRegister();" method="post" >
    <%
        String errorMsg = (String)request.getAttribute("message");
        if (errorMsg!=null){
            out.print("<div style='color:red'>" +errorMsg + "</div>");
        }
    %>
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
