<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2018/4/21
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <script src="../../resources/js/mui.min.js"></script>
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>

    <link href="../../resources/css/mui.min.css" rel="stylesheet"/>
    <style>
        .mui-badge-success{
        }
    </style>


</head>
<body>
<div class="mui-card">
    <div class="mui-card-header">
        <h1 id="Json大王"></h1>
    </div>
    <div class="mui-card-content">

    </div>
    <div class="mui-card-footer">

    </div>
</div>





<script type="text/javascript" charset="UTF-8">
    var bussinessid=${sessionScope.shop.shopId};
    $.ajax({
            type:'POST',
            url:"/ordersSelectALLByShopId.do",
            data:{
                "shopId":bussinessid
            },
            success:function(data) {
                $('#Json大王').html(data[0].user_name);
            },
            error:function () {
            }
        }
    )
</script>


</body>
</html>
