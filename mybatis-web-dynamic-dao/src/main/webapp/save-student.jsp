<%--
  Created by IntelliJ IDEA.
  User: xfs
  Date: 2021/1/28
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mybatis web save student</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/student/save.do" method="post">
        name<input type="text" name="name">
        <br>
        birth<input type="text" name="birth">
        <br>
        <input type="submit" value="save">
    </form>

    <form action="${pageContext.request.contextPath}/student/save2.do" method="post">
        name<input type="text" name="name">
        <br>
        birth<input type="text" name="birth">
        <br>
        <input type="submit" value="save">
    </form>

</body>
</html>
