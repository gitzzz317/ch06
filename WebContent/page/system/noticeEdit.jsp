<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改通知公告</title>
<link rel="stylesheet" href="http://localhost:8080/ch06/css/ncss_style.css" type="text/css" />
<script type="text/javascript" language="javascript">
	function checkNotice(){
		var title = form1.ntitle.value;
		if ((title==null)||(title=="")){
			alert("请填写标题！");
			return false;		
		}
		var editor = form1.neditor.value;
		if ((editor==null)||(editor=="")){
			alert("请填写作者！");
			return false;		
		}
		var content = form1.ncontent.value;
		if ((content==null)||(content=="")){
			alert("请填写内容！");
			return false;		
		}
		return true;
	}
</script>
</head>
<body>
<form method="post" name="form1" action="${pageContext.servletContext.contextPath}/updateNotice" onsubmit="javascript: return checkNotice();">
  <table>
    <tr>
      <td>标题:</td>
      <td><input type="text" name="ntitle" size="35" value="${requestScope.notice.ntitle}"/></td>
    </tr>
    <tr>
      <td>作者:</td>
      <td><input type="text" name="neditor" size="35" value="${requestScope.notice.neditor}"/></td>
    </tr>
    <tr>
      <td>内容:</td>
      <td><textarea name="ncontent" rows="10" cols="30" >${requestScope.notice.ncontent}</textarea></td>
    </tr>
    <tr>
      <td> 类型:</td>
      <td><select name="ntype">
          <c:forEach items="${requestScope.allType}" var="type">
              <c:choose>
                  <c:when test="${type.tno == notice.ntype}">
                      <option value="${type.tno}" selected="selected">${type.ttypeName}</option>
                  </c:when>
                  <c:otherwise>
                      <option value="${type.tno}">${type.ttypeName}</option>
                  </c:otherwise>
              </c:choose>
          </c:forEach>
        </select></td>
    </tr>
    <tr>
          <input type="hidden" name="nno" value="${requestScope.notice.nno}" />
      <td><input type="submit" value="提交" name="submit" /></td>
      <td><input type="reset" value="重置" name="reset"/></td>
    </tr>
  </table>
</form>
</body>
</html>
