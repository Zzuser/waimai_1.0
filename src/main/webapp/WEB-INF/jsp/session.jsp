<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 18-4-21
  Time: 下午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session测试</title>
</head>
<head lang="en">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <script src="../resources/js/sockjs-0.3.min.js"></script>
    <!-- 新 Bootstrap 核心 CSS 文件 -->

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <!--<script type="text/javascript" src="js/jquery-1.7.2.js"></script>-->
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../resources/js/bootstrap.min.js"></script>
    <title>webSocket测试</title>
    <script type="text/javascript">
        $(function(){
            var websocket;
            if ('WebSocket' in window) {
                websocket = new WebSocket("ws://localhost:8080/echo");
            } else if ('MozWebSocket' in window) {
                websocket = new MozWebSocket("ws://echo");
            } else {
                websocket = new SockJS("/sockjs/echo");
            }
            websocket.onopen = function (evnt) {
                $("#tou").html("链接服务器成功!")
            };
            websocket.onmessage = function (evnt) {
                $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
            };
            websocket.onerror = function (evnt) {
            };
            websocket.onclose = function (evnt) {
                $("#tou").html("与服务器断开了链接!")
            }
            $('#send').bind('click', function() {
                send();
            });
            function send(){
                if (websocket != null) {
                    var message = document.getElementById('message').value;
                    var toId = document.getElementById('toId').value;


                    var data = {};//新建data对象，并规定属性名与相应的值

                    data['toId'] = toId;
                    data['messageText'] = message;
                    websocket.send(JSON.stringify(data));


                    websocket.send(message);
                } else {
                    alert('未与服务器链接.');
                }
            }
            function disconnect() {
                if (ws != null) {
                    ws.close();
                    ws = null;
                }
            }
        });
    </script>

</head>
<body>
${sessionScope}<br>
<button id="logout">注销</button>
<div class="page-header" id="tou">
    webSocket chatroom
</div>
<div class="well" id="msg">
</div>
<div class="col-lg">
    <div class="mui-input-group">
        <input type="text" class="form-control" placeholder="发送信息..." id="message">
        <input type="text" class="form-control" placeholder="发给谁的"  id="toId">
        <span class="input-group-btn">
        <button class="btn btn-default" type="button" id="send" >发送</button>
      </span>
    </div><!-- /input-group -->
</div><!-- /.col-lg-6 -->
</div>
</body>
</html>
