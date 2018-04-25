<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 18-4-25
  Time: 上午11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" charset="utf-8">
    $(document).ready(function () {

        $("#zhuce").click(function () {
            var shopId = document.getElementById("shopId").value;
            var foodId = document.getElementById("foodId").value;
            var foodNum = document.getElementById("foodNum").value;
            var msg = {};
            msg['userId'] = ${sessionScope.user.userId};
            msg['shopId'] = shopId;
            msg['foodId'] = foodId;
            msg['foodNum'] = foodNum;
var data=JSON.stringify(msg);

            $.ajax({
                type: "Post",//这里是http类型
                // contentType: "application/json",
                url: "/orderPlace.do",//大家都应该很清楚了
                traditional: true,
                data: {
                    "orderJson": data
                },//回传一个参数
                dataType: "json",//传回来的数据类型
                success: function (data) {
                    if (data.valueOf() == 1) {
                        alert("下单成功");
                    }
                    else {
                        alert("下单失败");
                    }
                },
                error: function () {
                    alert("服务器错误");

                }

            });


        });
    });
</script>
<body>
shopId：<br>
<input id="shopId" name="shopId" type="text"><br></form>
foodId :<br>
<input id="foodId" name="foodId" type="text"><br>
foodNum :<br>
<input id="foodNum" name="foodNum" type="text"><br>
<button id="zhuce" >下单</button>
</body>
</html>
