<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 18-4-25
  Time: 上午11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>    <meta charset="utf-8">
    <title>下单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="../../resources/css/mui.min.css">
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../../resources/js/mui.min.js"></script>
    <style>
        html, body {
            background-color: #efeff4;
        }


    </style>
</head>
<script src="../../resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" charset="utf-8">
    var foodCount1;
    var foodCount2;
    var foodList=[];
    function foodInput() {
        $('#foodInput').append(
            '<div class="mui-card">' +
            '<div class="mui-card-content">foodId :<br>\n' +
            '<input id="'+foodCount1+'" type="text"></div>' +
            '<div class="mui-card-content">foodNum :<br>\n' +
            '<input id="'+foodCount2+'" type="text"></div>' +
            '</div>');

    }

    $(document).ready(function () {
        $("#foodAdd").click(function () {
            var food={}
            food.foodId=($('#'+foodCount1).val());
            food.foodNum=($('#'+foodCount2).val());
            foodList.push(food);
            foodCount1++;
            foodCount2++;
            foodInput();
        });
        $("#zhuce").click(function () {

            $("#foodInput").empty();
            var shopId = document.getElementById("shopId").value;
            var msg = {};
            msg['userId'] = ${sessionScope.user.userId};
            msg['shopId'] = shopId;
            msg['foodInOrderList'] = foodList;

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
                        foodCount1=0;
                        foodCount2=0;
                        foodList=[];
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
<body onload="foodInput()">
shopId：<br>
<input id="shopId" name="shopId" type="text"><br></form>
<div id="foodInput"></div>
<button class="mui-btn-danger mui-pull-right" type="button" id="foodAdd">添加</button>
<button id="zhuce" >下单</button>
</body>
</html>
