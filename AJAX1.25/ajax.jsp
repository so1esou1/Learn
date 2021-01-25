<%--
  Created by IntelliJ IDEA.
  User: xfs
  Date: 2021/1/24
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>使用AJAX发送get请求，验证用户名是否可用</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${pageContext.request.contextPath}/">
  </head>

  <!--需求：注册时，提示该用户名是否已被注册
      用户名失去焦点的时候，发送AJAX请求，验证该用户名是否可用，可用的话，提供恭喜信息，不可用的话，提示错误信息
  -->

  <body>
  <script type="text/javascript">
      function checkUsername(username){
        //发送ajax请求，验证用户名是否可用
        //发送ajax请求的代码一共四步，这四步是固定的
        //比传统请求要麻烦一些
        //AJAX发送请求全靠浏览器内置的对象:XMLHttpRequest对象
        //使用这个XMLHttpRequest对象可以在浏览器当中单独启动一个新的浏览器线程。通过浏览器线程发送该请求
        //达到异步效果
        //1、创建AJAX核心对象XMLHttpRequest(浏览器内置的，可以直接使用)
        var xhr;
        if (window.XMLHttpRequest){
          xhr = new XMLHttpRequest();
        }else{
          //不支持XMLHttpRequest对象的浏览器。IE5、IE6是不支持的，指支持ActiveXObject对象
          //IE5、IE6版本使用的是ActiveXObject这个内置对象发送AJAX请求
          xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        alert(xhr);
        //2、注册回调函数
        //程序执行到这里的时候，后面的回调函数还不会执行，只是将回调函数注册给xhr对象
        //等xhr对象的readystatechange值发送改变的时候，后面的回调函数会执行
        /*
        XMLHtttpRequest对象在请求和响应的过程中，该对象的readyState状态从0变到4：
        0 ： 请求初始化
        1 ： 服务器连接已建立
        2 ： 请求已接收
        3 ： 请求处理中
        4 ： 请求已完成，且响应已就绪
         */
        xhr.onreadystatechange = function () {   //当xhr对象的readyState的值发送改变的时候，回调一次
          //最重要的就是写这个回调函数
          if (xhr.readyState == 4){   //服务器端响应结束
            //如果响应结果有404、500错误时
            //xhr.status属性可以获取到HTTP的响应状态码
            if (xhr.status == 200){    //200表示服务器正常响应结束
              //在浏览器中使用xhr对象接收服务器端响应回来的文本
              //var s = xhr.responseText;
              //alert(s);
              var nameTipMsg = document.getElementById("nameTipMsg");
              nameTipMsg.innerHTML = xhr.responseText;
            }else {
              //弹出错误代码
              alert(xhr.status);
            }
          }
        }

        //3、开启浏览器和服务器之间的通道
        /*三个参数：
        method:指定请求方式为get还是post
        url:请求路径
        async:true/false  (true表示支持异步，false表示支持同步)，目前先统一写成true
         */
        xhr.open("GET","/ajax-get/checkusername.do?username=" + username,true)   //这里还是只开启通道，不发送请求

        //AJAX post请求的乱码需要在这里进行处理，注意：字符集需要和浏览器字符集相同，需要和服务器当中的字符集相同
        //这个需求是GET，这里只是演示以下post情况下更改代码：
        //xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");

        //4、发送AJAX请求
        xhr.send();     //这里才会发送请求
      }
  </script>

    用户名：<input type="text" name="username" onblur="checkUsername(this.value)"/><span id="nameTipMsg"></span>  <br>
    密码：<input type="password" name="password"> <br>
  </body>
</html>
