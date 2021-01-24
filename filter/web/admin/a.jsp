<%--
  Created by IntelliJ IDEA.
  User: xfs
  Date: 2021/1/24
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是登录页面。 login.jsp页面<br>
    <form action="http://localhost:8080/filter/loginServlet" method="get">
        用户名：<input type="text" name="username"/>
        密码：<input type="text" name="password"/>
        <input type="submit" />
    </form>
</body>
</html>
