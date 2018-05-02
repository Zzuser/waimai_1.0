<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>My WebSocket</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="../../resources/css/mui.min.css">
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../../resources/js/mui.min.js"></script>
    <script type="text/JavaScript">
        var websocket = null;
        //判断当前浏览器是否支持WebSocket
        if('WebSocket' in window){
            websocket = new WebSocket("ws://43.226.69.220:8080/websocket?client"+"123");
        }
        else{
            alert('Not support websocket');
        }

        //连接发生错误的回调方法
        websocket.onerror = function(){
            setMessageInnerHTML("error");
        };

        //连接成功建立的回调方法
        websocket.onopen = function(event){
            setMessageInnerHTML("open");
        };

        //接收到消息的回调方法
        websocket.onmessage = function(event){
            alert(event.data);
            var orderdata=JSON.parse(event.data);
            setMessageInnerHTML(event.data);
            show(orderdata);
        };

        //连接关闭的回调方法
        websocket.onclose = function(){
            setMessageInnerHTML("close");
        };

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function(){
            websocket.close();
        };

        //将消息显示在网页上
        function setMessageInnerHTML(innerHTML){
            document.getElementById('message').innerHTML += innerHTML + '<br/>';

        }

        //关闭连接
        function closeWebSocket(){
            websocket.close();
        }

        //发送消息
        function send(){
            var message = document.getElementById('text').value;
            websocket.send(message);
        }
        function show (data) {
            $('#外部').append(
                '<div class="mui-card">' +
                '<div class="mui-card-header" id="shangbu"></div>' +
                '<div class="mui-card-content" id="zhongbu"></div>' +
                '</div>');
            $('#shangbu').append(
                '<h4>用户：' + data.user_name + '</h4>' +
                '<button  id="' + data.order_number + '" class="mui-btn mui-btn-danger mui-btn-outlined  mui-icon mui-icon-plus mui-right">订单详情</button>'
            );
            try {
                var x;
                for (x = 0; x < 3; x++) {

                    $('#zhongbu').append(
                        '<ul><h5>' + data.food_list[x].food_name + 'x' + data.food_list[x].food_count + '</h5>'
                    );
                }
            } catch (err) {
            }


        }
    </script>
</head>

<body>
Welcome<br/>
<input id="text" type="text" /><button onclick="send()">Send</button>    <button onclick="closeWebSocket()">Close</button>
<div id="message">
</div>
<div id="外部" >

</div>
</body>



</html>