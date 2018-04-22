<%--
  Created by IntelliJ IDEA.
  User: hongchen
  Date: 2018/4/19
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
  <title></title>
  <script src="../../resources/js/mui.min.js"></script>
  <script src="../../resources/js/jquery-3.3.1.min.js"></script>
  <link href="../../resources/css/mui.min.css" rel="stylesheet"/>
  <script type="text/javascript" charset="utf-8">
      mui.init();
  </script>
  <style>
    .mui-card{
      margin-top: 50% ;
      background-color: rgba(247,247,247,.75);
    }
    .mui-input-clear{
      width: 60%;
    }
    .mui-btn{
      width: 50%;
      left: 25%;
      padding: 8px;

    }
    .link-area {
      display: block;
      text-align: center;
    }
    #web_bg{
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
  <div id="web_bg" style="background-image:url(../../resources/img/sign_bg.db29b0fbd2f78dd8c1b7.png);"></div>
  <!--其他代码 ... -->
</div>
<div class="mui-card">
  <div class="mui-card-header">
    <div class="mui-input-row">
      <label>商户号</label>
      <input id='shopId' type="text" class="mui-input-clear mui-input" placeholder="请输入账号">
    </div>
  </div>
  <div class="mui-card-header">
    <div class="mui-input-row">
      <label>密码</label>
      <input id='shopPsd' type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
    </div>
  </div>
  <div class="mui-card-header">
    <button id='login' class="mui-btn mui-btn-block mui-btn-danger" onclick="check()">登录</button>
  </div>
  <div class="mui-content-padded">
    <div class="link-area">
      <a id='reg' onclick="regbutton()">注册账号</a>
    </div>
  </div>
</div>
<script type="text/javascript" charset="utf-8">
    mui.init();
    function regbutton(){
        var btnArray = ['确认', '取消'];
        mui.confirm("您确定要注册账号吗？","注册提醒",btnArray,function(e){
            if (e.index == 1) {
                mui.toast("已取消");
            } else {
                mui.innerText="进入注册界面";
                window.location.href="reg.html";
            }
        })
    }
    function check(){
        var shopId  = document.getElementById("shopId").value;
        var shopPsd = document.getElementById("shopPsd").value;
        var info = document.getElementById("info");
        if(shopId==""||shopPsd==""){
            mui.alert("用户名和密码不能为空，请重新输入");
        }
        else{
            $.ajax({
                type:'POST',
                url:"/shopLogin.do",
                data:{
                    "shopId":shopId
                    ,"shopPsw":shopPsd
                },
                success:function(data) {
                    if (data.valueOf()==1)
                    {
                        mui.alert("你已登录成功","登陆提醒","确认",function(){
                            window.location.href="/session";
                        })
                        //window.location.href="/reg";
                    }
                    else if(data.valueOf()==0){
                        mui.alert("帐号或密码错误！","登陆提醒","确认",function(){
                        })
                    }
                    else {
                        mui.alert("没有此账户");
                    }

                }

            })
        }
    }
</script>
</body>
</html>
