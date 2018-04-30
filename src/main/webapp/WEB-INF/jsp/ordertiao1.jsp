<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2018/4/26
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $("#zhuce").click(function(){
            var shopName=document.getElementById("shopName").value;
            $.ajax({
    type: "Post",//这里是http类型
    url: "/ordertiao2",//大家都应该很清楚了
    data: {"hhhhh":shopName},//回传一个参

    success:function(data){
        window.location.href="/ordertiao2"

    },
                error:function (x) {
        alert(x);

                }
            });})

    </script>
</head>
<body>

<%--< id='shopName' type="text"  placeholder="请输入账号">--%>
<%--<button id='zhuce' type="button" >--%>
    <%--注册商户--%>
<%--</button>--%>
<form method="post" action="/ordertiao2">
    <input name="hhhhh" value="1">
    <input type="submit" value="hqwer">
</form>
</body>
</html>
