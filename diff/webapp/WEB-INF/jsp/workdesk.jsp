
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
        .mui-table-view.mui-grid-9{
            /*九宫格背景色*/
        }

        .mui-table-view.mui-grid-9 .mui-table-view-cell.mui-active{
           /*九宫格点击色*/
        }
    </style>
</head>
<body>

<div class="mui-input-row mui-search" >
    <input type="search" class="mui-input-clear" placeholder="">
</div>
    <ul class="mui-table-view mui-grid-view mui-grid-9">
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon red" style="color:rgba(247,0,0,.5)">100</span>
            <div class="mui-media-body">待处理</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon" style="color:rgba(0,0,247,.5)">200</span>
            <div class="mui-media-body">待配送</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon" style="color:rgba(0,0,0,.5)">300</span>
            <div class="mui-media-body">已完成</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon">${sessionScope.shop.shopAdd}</span>
            <div class="mui-media-body">地址</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon">${sessionScope.shop.shopPsw}</span>
            <div class="mui-media-body">密码</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon">${sessionScope.shop.shopTel}</span>
            <div class="mui-media-body">电话</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon mui-icon-gear"></span>
            <div class="mui-media-body">Setting</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon mui-icon-info"></span>
            <div class="mui-media-body">about</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
            <span class="mui-icon mui-icon-more"></span>
            <div class="mui-media-body">more</div></a></li>
    </ul>
<div class="mui-text-center">${sessionScope}</div>


</body>
</html>
