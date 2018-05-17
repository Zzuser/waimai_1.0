<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 17-12-5
  Time: 下午12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="../../resources/css/mui.min.css" rel="stylesheet"/>
    <script src="../../resources/js/mui.min.js"></script>
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <title>CUC外卖</title>
    <style>
        #web_bar {
            height: 10%;
            width: 100%;
            background-color: #dc322f;
            opacity: 0.9;
            position: relative;
        }

        #title {
            font-family: Consolas;
            vertical-align: middle;
            font-size: 35px;
            position: absolute;
            top: 25%;
            transform: translateX(60%);

        }

        #login {
            font-family: Consolas;
            vertical-align: middle;
            font-size: 15px;
            position: absolute;
            top: 45%;

            transform: translateX(1450%);

        }

        #All {
            /*width: 1400px;*/
            /*height: 700px;*/
            background-size: 140% 200%;
            background-image: url("../../resources/img/GettyImages-545286388n.jpg");

            position: relative;
        }

        #start {
            font-size: 120px;
            color: white;
            vertical-align: middle;
            position: absolute;
            top: 40%;
            text-align: center;
        }

        #two {
            width: 50%;
            height: 45%;
            background-size: 100% 100%;
            background-image: url("../../resources/img/myqr.png");
            vertical-align: middle;
            position: absolute;
            top: 70%;
            transform: translateX(50%);
        }

        #iRight {
            vertical-align: middle;
            position: absolute;
            top: 140%;
            font-size: 14px;
            color: white;
            transform: translateX(140%);
        }

        #waimailogo {
            background-size: 100% 100%;
            height: 50px;
            width: 50px;
            vertical-align: middle;
            position: absolute;
            top: 13%;
            transform: translateX(110%);
        }
        #wingL{
            vertical-align: middle;
            position: absolute;
            top: 75%;
            transform: translateX(160%);
        }
        #wingR{
            vertical-align: middle;
            position: absolute;
            top: 75%;
            transform: translateX(430%);
        }
    </style>
    <script type="text/javascript" charset="UTF-8">
        function showMore() {
            $("#API").show();
            $("#start").hide();
        }
    </script>
</head>
<body id="All">
<div>
<header id="web_bar">
    <h2 id="title" style="color: white"><b>C U C 外 卖</b></h2>
    <img id="waimailogo" src="../../resources/img/waimailogo.png">
    <span id="login" class="mui-pull-left">
        <a href="/shopLogin" style="color: white"><b>登录</b></a>
        <b style="color: white">|</b>
        <a href="/shopReg" style="color: white"><b>注册</b></a>
    </span>
</header>
<div id="start" onclick="showMore()" align="center" class="mui-title">开始探索</div>
<div class="mui-content">
    <div hidden id="API" class="mui-row mui-table-view">
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/shopLogin" style="color: white">订单管理系统</a>
        </div>
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/shopReg" style="color: white">商户注册</a>
        </div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/main" style="color: white">订单消息主页面</a>
        </div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/resources/apk/CucTakeOut1.0.apk" style="color: white">下载外卖app</a>
        </div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/resources/apk/deliver.apk" style="color: white">下载骑手app</a>
        </div>
    </div>
    <div id="two">
    </div>

    <div id="iRight">
        <ul style="color:beige"><h3>cuc外卖1.0@copyright2018</h3> </ul>
        <ul>Power By JAVA SSM</ul>
    </div>
    <%--<BUTTON type="button" onclick="showMore()">API测试</BUTTON>--%>


</div>
</div>
</body>
</html>
