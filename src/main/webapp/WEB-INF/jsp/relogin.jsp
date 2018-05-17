<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 18-5-14
  Time: 下午6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello MUI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="../../resources/css/mui.min.css">
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../../resources/js/mui.min.js"></script>
    <script type="text/javascript" charset="UTF-8">
        function tuichu() {
            var btnArray = ['确认', '取消'];
            mui.confirm("确认要退出吗？","提示",btnArray,function(e){
                if (e.index == 1) {

                } else {
                    window.open("/shopLogin")
                }
            });
        }
    </script>
</head>
<body>
<button onclick="tuichu()">修改成功，请重新登录。</button>


</body>
</html>
