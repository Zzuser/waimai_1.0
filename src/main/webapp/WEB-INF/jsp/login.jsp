<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 17-12-5
  Time: 下午12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>USER SIGN IN</title>
    <script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
    <script>
        $(document).ready(function () {
            var shopId, shopPsw;
            $("#button").click(function () {
                shopId = $("#shopId").val();
                shopPsw = $("#shopPsw").val();
                $.ajax({
                    type: "Post",//这里是http类型
                    // contentType: "application/json",
                    url: "/shopLogin.do",//大家都应该很清楚了
                    traditional: true,
 // @RequestParam("shopId") Integer shopId,
 //                         @RequestParam("shopPsw") String psw,
                    data: {
                        "shopId": shopId
                        , "shopPsw": shopPsw
                    },//回传一个参数
                    dataType: "json",//传回来的数据类型
                    success: function (msg) {
                        if (msg.valueOf() == 1) {
                            alert(msg.valueOf() + "登录成功")
                            window.location.href='/show';
                        }
                        else {
                            alert(msg.valueOf() + "登录失败")
                        }
                    },
                    error: function (msg) {
                        alert(msg.valueOf() + "未知错误")
                    }
                });
            });
        });
    </script>

</head>
<body>
${sessionScope.uuid}
<div>
    昵称 :<br>
    <input id="shopId" type="text"> *必填唯一*<br>
    密码 :<br>
    <input id="shopPsw" type="text"> *必填*<br>
    <input id="button" type="button" value="登录">
</div>
</body>
</html>
