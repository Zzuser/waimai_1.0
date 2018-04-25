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
        html,
        body {
            background-color: #efeff4;
        }

        .mui-ios .mui-page-left {
            -webkit-transform: translate3d(-20%, 0, 0);
            transform: translate3d(-20%, 0, 0);
        }

        .mui-navbar .mui-bar {
            position: absolute;
            background: transparent;
            text-align: center;
        }

        .mui-ios .mui-navbar-left .mui-left,
        .mui-ios .mui-navbar-left .mui-center,
        .mui-ios .mui-navbar-left .mui-right {
            opacity: 0;
        }
        .mui-navbar .mui-btn-nav {
            -webkit-transition: none;
            transition: none;
            -webkit-transition-duration: .0s;
            transition-duration: .0s;
        }
        .mui-navbar .mui-bar {
            display: inline-block;
            width: auto;
        }

        .mui-pages {
            display: block;
        }
        .mui-page .mui-table-view:first-child {
            margin-top: 15px;
        }
        .mui-page .mui-table-view:last-child {
            margin-bottom: 30px;
        }
        .mui-table-view {
            margin-top: 20px;
        }

        .mui-table-view span.mui-pull-right {
            color: #999;
        }

        .head-img {
            width: 80px;
            height: 80px;
        }

        .update {
            font-style: normal;
            color: #999999;
            margin-right: -25px;
            font-size: 15px
        }

        .mui-ios .mui-navbar .mui-bar .mui-title {
            position: static;
        }
        /*问题反馈在setting页面单独的css*/
        #feedback .mui-popover{
            position: fixed;
        }
        #feedback .mui-table-view:last-child {
            margin-bottom: 0px;
        }
        #feedback .mui-table-view:first-child {
            margin-top: 0px;
        }

        .mui-plus.mui-plus-stream .mui-stream-hidden{
            display: none !important;
        }

        /*问题反馈在setting页面单独的css==end*/

    </style>

    <script type="text/javascript" charset="UTF-8">
        function tuichu() {
            var btnArray = ['确认', '取消'];
            mui.confirm("确认要退出吗？","提示",btnArray,function(e){
                if (e.index == 1) {

                } else {
                    mui.back("/shopLogin");
                }
            });
        }
    </script>
</head>
<body>
<ul class="mui-table-view mui-table-view-chevron">
    <li class="mui-table-view-cell mui-media">
        <a class="mui-navigate-right">
            <img class="mui-media-object mui-pull-left head-img" id="head-img" src="../../resources/img/cbd.jpg">
            <div class="mui-media-body">
                <b>您好 ${sessionScope.shop.shopId}</b>
                <p class='mui-ellipsis'>账号:${sessionScope.shop.shopName}</p>
            </div>
        </a>
    </li>
</ul>
<ul class="mui-table-view mui-table-view-chevron">
    <li class="mui-table-view-cell">
        <a class="mui-navigate-right">修改商户信息</a>

    </li>
</ul >
<ul class="mui-table-view mui-table-view-chevron">
    <li class="mui-table-view-cell">
        <label  class="mui-navigate-right">总销售额<b class="mui-pull-right" style="color: red">17K</b></label>

    </li>
    <li class="mui-table-view-cell">
        <a  class="mui-navigate-right">总销量<b class="mui-pull-right" style="color: red">700</b></a>
    </li>
    <li class="mui-table-view-cell">
        <a class="mui-navigate-right">月销售额<b class="mui-pull-right" style="color: red">3K</b></a>
    </li>
    <li class="mui-table-view-cell">
        <a class="mui-navigate-right">月销量<b class="mui-pull-right" style="color: red">50</b></a>
    </li>
</ul>
<ul class="mui-table-view mui-table-view-chevron">
    <li class="mui-table-view-cell">
        <a  class="mui-navigate-right">关于我们<i class="mui-pull-right update">V1.0</i></a>
    </li>
</ul>
<ul class="mui-table-view">
    <li class="mui-table-view-cell" style="text-align: center;" onclick="tuichu()">
        <a>退出登录</a>
    </li>
</ul>
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
