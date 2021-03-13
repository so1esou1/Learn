<%--
  Created by IntelliJ IDEA.
  User: xfs
  Date: 2021/3/13
  Time: 7:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>登录</h1>
  <div style="text-align: center">
    <%--表单表示的意思:以post方式提交表单，提交到login请求--%>
    <form action="${pageContext.request.contextPath}/login">
      用户：<input type="text" name="username">  <br>
      密码：<input type="password" name="password">  <br>
      爱好:
      <input type="checkbox" name="hobbys" value="抽烟">抽烟
      <input type="checkbox" name="hobbys" value="喝酒">喝酒
      <input type="checkbox" name="hobbys" value="烫头">烫头
      <input type="checkbox" name="hobbys" value="打豆豆">打豆豆

      <br>
      <input type="submit">
    </form>
  </div>

  </body>
</html>
