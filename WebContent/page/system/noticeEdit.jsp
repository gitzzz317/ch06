<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  errorPage="error.jsp"%>
<%@ page import="com.zhbit.notice.pojo.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改通知公告</title>
<link rel="stylesheet" href="http://localhost:8080/ch06/css/ncss_style.css" type="text/css" />
<script type="text/javascript" language="javascript">
	function checkNotice(){
		var title = form1.title.value;
		if ((title==null)||(title=="")){
			alert("请填写标题！");
			return false;		
		}
		var editor = form1.editor.value;
		if ((editor==null)||(editor=="")){
			alert("请填写作者！");
			return false;		
		}
		var content = form1.content.value;
		if ((content==null)||(content=="")){
			alert("请填写内容！");
			return false;		
		}
		return true;
	}
</script>
</head>
<body>
<%
	Notice notice = (Notice)request.getAttribute("notice");
 %>
<form method="post" name="form1" action="http://localhost:8080/ch06/noticeServlet" onsubmit="javascript: return checkNotice();">
  <table>
    <tr>
      <td>标题:</td>
      <td><input type="text" name="title" size="35" value="<%=notice.getNtitle()%>"/></td>
    </tr>
    <tr>
      <td>作者:</td>
      <td><input type="text" name="editor" size="35" value="<%=notice.getNeditor()%>"/></td>
    </tr>
    <tr>
      <td>内容:</td>
      <td><textarea name="content" rows="10" cols="30" ><%=notice.getNcontent()%></textarea></td>
    </tr>
    <tr>
      <td> 类型:</td>
      <td><select name="type">
      <%
      	List<Type> list = (List<Type>)request.getAttribute("list");
      	if (list!=null){
      		for (Type type: list){
      			if (type.getTno()==notice.getNtype()){
      %>
          			<option  value="<%=type.getTno()%>" selected="selected"><%=type.getTtypeName() %></option>
      <%		}else{
      %>    
          			<option value="<%=type.getTno()%>"><%=type.getTtypeName() %></option>
      <%        } 			
      		}
      	}
       %>
        </select></td>
    </tr>
    <tr>
          <input type="hidden" name="method" value="updateNotice" />
          <input type="hidden" name="noticeId" value="<%=notice.getNno() %>" />
      <td><input type="submit" value="提交" name="submit" /></td>
      <td><input type="reset" value="重置" name="reset"/></td>
    </tr>
  </table>
</form>
</body>
</html>
