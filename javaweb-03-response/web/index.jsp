<%--
  Created by IntelliJ IDEA.
  User: xfs
  Date: 2021/3/12
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--这里提交的路径需要寻找项目的路径--%>
  <%--jsp里可以写java的代码,pageContext.request.contextPath代表当前项目--%>
  <form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"> <br>
    密码：<input type="password" name="password"> <br>
    <input type="submit">
  </form>

  </body>
</html>
