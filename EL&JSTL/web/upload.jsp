<%--
  Created by IntelliJ IDEA.
  User: xfs
  Date: 2021/1/23
  Time: 7:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://192.168.31.74:8080/EL&JSTL/uploadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username" /> <br>
        头像：<input type="file" name="photo" /> <br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
