<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
            background-color: white;
        }

        .mui-table-view.mui-grid-9 .mui-table-view-cell.mui-active{
           /*九宫格点击色*/
        }
    </style>
    <script type="text/JavaScript">
        var evol=0;
        var busesid=${sessionScope.shop.shopId};
        var websocket = null;
        //判断当前浏览器是否支持WebSocket
        if('WebSocket' in window){
            websocket = new WebSocket("ws://43.226.69.220:8080/websocket?client"+busesid);
            //http://43.226.69.220:8080/
        }//deliver.apk
        else{
            alert('Not support websocket');
        }

        //连接发生错误的回调方法
        websocket.onerror = function(){
            // setMessageInnerHTML("error");
        };

        //连接成功建立的回调方法
        websocket.onopen = function(event){
            // setMessageInnerHTML("open");
        };

        //接收到消息的回调方法
        websocket.onmessage = function(event){
            var audio = document.getElementById("audios");
            evol++;
            mui.alert(evol+"订单请注意查收");
            // setMessageInnerHTML(event.data);
            $('#daichuli').html(evol);
            audio.play();

        };


        //连接关闭的回调方法
        websocket.onclose = function(){
            setMessageInnerHTML("close");
        };

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function(){
            websocket.close();
        };

        // //将消息显示在网页上
        // function setMessageInnerHTML(innerHTML){
        //     document.getElementById('message').innerHTML += innerHTML + '<br/>';
        //
        // }

        //关闭连接
        function closeWebSocket(){
            websocket.close();
        }

        //发送消息
        function send(){
            var message = document.getElementById('text').value;
            websocket.send(message);
        }

    </script>
    <script type="text/javascript">
        var bussinessid =${sessionScope.shop.shopId};
        shujuget();
        function shujuget() {
            $.ajax({
                type: 'POST',
                url: "/ordersSelectALLByShopId.do",
                data: {
                    "shopId": bussinessid
                },
                success: function (data) {
                    var peisong=0;
                    var wancheng=0;
                    var jiedan=0;
                    for(var i=0;i<data.length;i++)
                    {
                        if(data[i].order_status=="未配送")
                        {
                            peisong=peisong+1;
                        }
                    }
                    for(var k=0;k<data.length;k++)
                    {
                        if(data[k].order_status=="已完成")
                        {
                            wancheng=wancheng+1;
                        }
                    }
                    for(var k=0;k<data.length;k++)
                    {
                        if(data[k].order_status=="未接单")
                        {
                            jiedan=jiedan+1;
                        }
                    }
                    $('#待配送').html(peisong);
                    $('#已完成').html(wancheng);
                    $('#未接单').html(jiedan);
                }
            });

        }



    </script>
</head>
<body id="wrorkdesk">
<div id="pullrefresh" class="mui-content mui-scroll-wrapper">
<div class="mui-content">

    <ul class="mui-table-view">
        <li class="mui-table-view-cell">店铺状态
            <div id="M_Toggle" class="mui-switch-blue mui-switch mui-active">
                <div class="mui-switch-handle"></div>
            </div>
        </li>
    </ul>

    <audio src="../../resources/audio/message.mp3" id="audios" controls class="mui-hidden"></audio>


    <ul class="mui-table-view mui-grid-view mui-grid-9">
        <li class="mui-table-view-cell mui-media mui-col-xs-6 mui-col-sm-3"><a href="#">
            <span class="mui-icon" style="color:rgba(247,0,0,.5)" id="daichuli">N/A</span>
            <div class="mui-media-body">动态待处理</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-6 mui-col-sm-3"><a href="#">
            <span class="mui-icon" style="color:rgba(0,0,247,.5)" id="待配送">无</span>
            <div class="mui-media-body">待配送</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-6 mui-col-sm-3"><a href="#">
            <span class="mui-icon" style="color:rgba(0,240,0,.5)" id="已完成">无</span>
            <div class="mui-media-body">已完成</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-6 mui-col-sm-3"><a href="#">
            <span class="mui-icon" style="color:rgba(200,200,0,.5)" id="未接单">无</span>
            <div class="mui-media-body">待处理</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-6 mui-col-sm-3"　id="daoru"><a onclick="dianji()">
            <span class="mui-icon mui-icon-gear"></span>
            <div class="mui-media-body">批量导入</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-6 mui-col-sm-3"><a href="#">
            <span class="mui-icon">${sessionScope.shop.deliveryFee}元</span>
            <div class="mui-media-body">配送费</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-12 mui-col-sm-6"><a href="#">
            <span class="mui-icon">${sessionScope.shop.shopAdd}</span>
            <div class="mui-media-body">地址</div></a></li>
        <li class="mui-table-view-cell mui-media mui-col-xs-12 mui-col-sm-6"><a href="#">
            <span class="mui-icon">${sessionScope.shop.shopTel}</span>
            <div class="mui-media-body">电话 </div></a></li>

    </ul>

</div>
</div>
<script type="text/javascript" charset="UTF-8">
    function dianji() {
        window.location.href="/test";
    }
</script>
<!--实现下拉刷新-->
<script>
    mui.init({
        swipeBack: false,
        pullRefresh: {
            container: '#pullrefresh',
            down: {
                callback: pulldownRefresh
            },
            up: {
                contentrefresh: '正在加载...',
                callback: pullupRefresh
            }
        }
    });

    /**
     * 下拉刷新具体业务实现
     */
    function pulldownRefresh() {
        shujuget();
        setTimeout(function () {
            mui('#pullrefresh').pullRefresh().endPulldownToRefresh(); //refresh completed
        }, 1000);
    }

    var count = 0;

    /**
     * 上拉加载具体业务实现
     */
    function pullupRefresh() {
        shujuget();
        setTimeout(function () {
            mui('#pullrefresh').pullRefresh().endPullupToRefresh((++count > 2)); //参数为true代表没有更多数据了。
        }, 1000);
    }
</script>

</body>
</html>
