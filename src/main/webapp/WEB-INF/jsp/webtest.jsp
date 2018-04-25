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
    <link rel="stylesheet" href="../../resources/css/mui.min.css">
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../../resources/js/mui.min.js"></script>
</head>

<body>
Welcome<br/>
<input id="text" type="text" /><button onclick="send()">Send</button>    <button onclick="closeWebSocket()">Close</button>
<div id="message">
</div>
</body>

<script type="text/JavaScript">
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
        websocket = new WebSocket("ws://localhost:8080/websocket?client123");
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
        setMessageInnerHTML(event.data);
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
        var data= document.getElementById('message');
        show(data);
        alert("ddddd")
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
        var z;
        var x;
        var str;

        for (z = 0; z < data.length; z++) {
            if(data[z].order_status=="未接单"){
                var c = 1;
                $('#外部').append(
                    '<div class="mui-card">' +
                    '<div class="mui-card-header" id="' + z + 'shangbu"></div>' +
                    '<div class="mui-card-content" id="' + z + 'zhongbu"></div>' +

                    '<div class="mui-card-footer mui-pull-right" id="' + z + 'xiabu"></div>' +
                    '</div>');
                $('#' + z + 'shangbu').append(
                    '<h4>用户：' + data[z].user_name + '</h4>' +
                    '<button  id="' + data[z].order_number + '" class="mui-btn mui-btn-danger mui-btn-outlined  mui-icon mui-icon-plus mui-right">订单详情</button>'
                );
                try {
                    for (x = 0; x < 3; x++) {

                        $('#' + z + 'zhongbu').append(
                            '<ul><h5>' + data[z].food_list[x].food_name + 'x' + data[z].food_list[x].food_count + '</h5>'
                        );
                    }
                } catch (err) {
                    continue;
                } finally {
                    $('#' + z + 'xiabu').append(
                        '<button class="mui-btn-danger mui-pull-right" type="button" id="'+z+'">接单</button>'
                    );
                    document.getElementById(data[z].order_number).addEventListener('click', function () {
                        window.location.href = "/orderdetail";
                    }, false);
                    var p=data[z].order_id;
                    document.getElementById(z).addEventListener('click', function () {
                        $.ajax(
                            {
                                type:"post",
                                url:"/receiveOrder",
                                data:
                                    {
                                        "orderId":p
                                    },
                                success:(function(msg) {
                                    if(msg.valueOf()==1)
                                    {
                                        mui.alert("接单成功！");
                                        init();
                                        init1();
                                    }
                                    else
                                    {
                                        mui.alert("接单失败！");
                                    }}),
                                error:(function () {
                                        mui.alert("服务器错误");
                                    }

                                )


                            }
                        )
                    }, false);

                }
            }
        }

    }
</script>
<div id="外部" >

</div>
</html>