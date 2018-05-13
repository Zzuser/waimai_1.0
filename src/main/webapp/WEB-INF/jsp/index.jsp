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
    <link href="../../resources/css/mui.min.css" rel="stylesheet" />
    <script src="../../resources/js/mui.min.js"></script>
    <title>API测试</title>
    <style>
        #web_bg{
            opacity: 0.7;
            position:fixed;
            top: 0;
            left: 0;
            width:100%;
            height:100%;
            min-width: 1000px;
            z-index:-10;
            zoom: 1;
            background-color: #fff;
            background-repeat: no-repeat;
            background-size: cover;
            -webkit-background-size: cover;
            -o-background-size: cover;
            background-position: center 0;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <!--背景图片-->
    <div id="web_bg"  style="background-image:url(../../resources/img/b649c5d4b6be560e382b805b7f253db3.jpeg);"></div>
    <!--其他代码 ... -->
</div>
<header class="mui-bar mui-bar-nav" style="background-color:rgba(247,0,0,0.6);">
    <a class="mui-icon"></a>
    <h2 id="title" class="mui-title" style="color: white"><b>外 卖 系 统</b></h2>
</header>

<div class="mui-content">
    <div class="mui-row mui-table-view">
    <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/shopLogin" style="color: green">订单管理系统</a></div>
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/shopReg">商户注册</a></div>
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/session">session</a></div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/main">订单消息主页面</a></div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/order">order</a></div>
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/orderdetail">orderdetail</a></div>
        <div class="mui-col-xs-4 mui-table-view-cell mui-col-sm-6"><a href="/shop">shop</a></div>
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/workdesk">workdesk</a></div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/webtest">webtest</a></div>
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/webtest2">webtest2</a></div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/userordertest">orderPlace</a></div>
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/ordertiao1">跳转</a></div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/userLogin">userLogin</a></div>
        <div class="mui-table-view-cell mui-col-xs-12 mui-col-sm-6"><a href="/userLogin">userReg</a></div>
        <div class="mui-col-xs-12 mui-table-view-cell mui-col-sm-6"><a href="/test">test</a></div>
    </div>







</div>
</body>
</html>
