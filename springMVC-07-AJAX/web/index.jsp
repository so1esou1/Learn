
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <!--导入jQuery-->
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.js"></script>

    <script>
      function a(){
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{"name":$("username").val()},
          success:function (data,status){
            console.log("data=" + data);
            console.log("status=" + status);   //200   300   400   500
          },
          error:function (){

          }
        })
      }

    </script>
  </head>
  <body>

  <!--失去焦点的时候发起一个请求（携带信息）到后台-->

  用户名:<input type="text" id="username" onblur="a()">

  </body>
</html>
