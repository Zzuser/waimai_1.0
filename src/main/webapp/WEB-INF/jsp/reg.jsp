<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 18-4-21
  Time: 下午1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<<head>
    <title>USER SIGN IN</title>
    <script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
    <script>
        $(document).ready(function () {
            var username, password,phone,address;
            $("#button").click(function () {
                username = $("#username").val();
                password = $("#password").val();
                phone = $("#phone").val();
                address = $("#address").val();
                $.ajax({
                    type: "Post",//这里是http类型
                    // contentType: "application/json",
                    url: "/shopReg.do",//大家都应该很清楚了
                    traditional: true,
                  // @RequestParam("shopName") String shopName,
                  //      @RequestParam("shopPsw") String shopPsw,
                  //      @RequestParam("shopTel") Integer shopTel,
                  //      @RequestParam("shopAdd") String shopAdd
                    data: {
                        "shopName": username
                        , "shopPsw": password
                        ,"shopTel":phone
                        ,"shopAdd":address
                    },//回传一个参数
                    dataType: "json",//传回来的数据类型
                    success: function () {
                        alert("ok")
                    },
                    error: function () {
                        alert("notOk")
                    }
                });
            });
        });
    </script>

</head>
<body>
<div>
    昵称 :<br>
    <input id="username" type="text"> *必填唯一*<br>
    密码 :<br>
    <input id="password" type="text"> *必填*<br>
    电话 :<br>
    <input id="phone" type="text"> *必填*<br>
    地址 :<br>
    <input id="address" type="text"> *必填*<br>
    <input id="button" type="button" value="注册">
</div>
</body>
</html>
