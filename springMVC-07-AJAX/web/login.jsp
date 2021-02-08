<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.js"></script>

    <script>
        function a1(){
            $.post({
                url:"${pageContext.request.contextPath}/a3",
                data:{"name":$("#name").val()},
                success:function (data) {
                    if (data.toString()==='ok'){
                        $("#userInfo").css("color","green");
                    }else {
                        $("#userInfor").css("color","red");
                    }
                    $("#userInfo").html(data);
                }
            })
        }
    </script>

    <script>
        function a2(){
            $.post({
                url:"${pageContext.request.contextPath}/a3",
                data:{"pwd":$("#pwd").val()},
                success:function (data) {
                    if (data.toString()==='ok'){
                        $("#pwdInfo").css("color","green");
                    }else {
                        $("#pwdInfor").css("color","red");
                    }
                    $("#pwdrInfo").html(data);
                }
            })
        }
    </script>
</head>
<body>


    <p>
        用户名:<input type="text" id="name" onblur="a1()">
        <span id="userInfo"></span>
    </p>

    <p>
        密码:<input type="text" id="pwd" onblur="a2()">
        <span id="pwdInfo"></span>
    </p>

</body>
</html>
