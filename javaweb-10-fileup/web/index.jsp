
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%--通过表单上传
      get:上传文件大小有限制
      post:上传文件大小没有限制
    --%>
  <%--HTML页面input必须含有name：<input type="file" name="xxx">--%>
  <%--表单如果包含一个文件上传输入项的话，表单的enctype 属性必须设置为"multipart/form-data"--%>

  <%--${pageContext.request.contextPath}是固定写法，代表获取服务器的当前路径--%>
  <form action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data" method="post">
    上传用户:<input type="text" name="useranme"> <br/>
    上传文件1:<p/><input type="file" name="file1">  <p/>
    上传文件2<p/><input type="file" name="file2">  <p/>

    <p/><input type="submit"> | <input type="reset"><p/>

  </form>
  </body>
</html>
