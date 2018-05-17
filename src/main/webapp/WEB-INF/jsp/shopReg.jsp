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
  <meta charset="UTF-8">
  <title></title>
  <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
  <link href="../../resources/css/mui.min.css" rel="stylesheet" />
  <script src="../../resources/js/mui.min.js"></script>
  <script src="../../resources/js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" charset="utf-8">
      mui.init();
      mui.plusReady();
      $(document).ready(function(){

          $("#zhuce").click(function(){
              var shopName=document.getElementById("shopName").value;
              var shopPsd1=document.getElementById("shopPsd1").value;
              var shopPsd2=document.getElementById("shopPsd2").value;
              var shopAdd=document.getElementById("shopAdd").value;
              var shopTel=document.getElementById("shopTel").value;

              if(shopName==""||shopPsd1==""||shopPsd2==""||shopAdd==""||shopTel=="")
              {
                  mui.alert("不能为空，请重新输入");

              }
              else if(shopPsd1!=shopPsd2)
              {
                  mui.alert("密码不能不同");
              }
              else
              {
                  $.ajax({
                      type: "Post",//这里是http类型
                      // contentType: "application/json",
                      url: "/shopReg.do",//大家都应该很清楚了
                      traditional: true,
                      // @RequestParam("shopName") String shopName,
                      //      @RequestParam("shopPsw") String shopPsw,
                      //      @RequestParam("shopTel") Integer shopTel,
                      //      @RequestParam("shopAdd") String shopAdd
                      data: {
                          "shopName": shopName
                          , "shopPsw": shopPsd1
                          ,"shopTel":shopTel
                          ,"shopAdd":shopAdd
                      },//回传一个参数
                      dataType: "json",//传回来的数据类型
                          success:function(data){
                              if(data.valueOf()==1)
                              {
                                  mui.alert("你已注册成功","登陆提醒","确认",function(){
                                      window.location.href="/shopLogin";
                                  })
                              }
                              else
                              {
                                  mui.alert("注册失败");
                              }
                          },
                          error:function(){
                              mui.alert("服务器错误");

                          }

                      });
              }


          });
      });
  </script>
  <style>
    .mui-card{
      margin-top: 130px ;
      background-color: rgba(247,247,247,.50);
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
    .mui-input-group label {
      width: 35%;
    }

    .mui-input-row label~input,
    .mui-input-row label~select,
    .mui-input-row label~textarea {
      width: 65%;
    }
    .mui-btn{
      width: 50%;
      left: 25%;
      padding: 8px;

    }
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
      top: 28%;
      transform: translateX(33%);

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
  </style>
</head>

<body>
<div class="wrapper">
  <!--背景图片-->
  <div id="web_bg" style="background-image:url(../../resources/img/GettyImages-545286388n.jpg"></div>
  <!--其他代码 ... -->
</div>
<header id="web_bar">
  <h2 id="title" style="color: white"><b>C U C 外 卖 商 户 端</b></h2>
  <img id="waimailogo" src="../../resources/img/waimailogo.png">
</header>
<div class="mui-card">
  <div class="mui-card-header">
    <div class="mui-input-row">
      <label>商户名</label>
      <input id='shopName' type="text" class="mui-input-clear mui-input" placeholder="请输入账号">
    </div>
  </div>
  <div class="mui-card-header">
    <div class="mui-input-row">
      <label>密码</label>
      <input id='shopPsd1' type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
    </div>
  </div>
  <div class="mui-card-header">
    <div class="mui-input-row">
      <label>确认密码</label>
      <input id='shopPsd2' type="password" class="mui-input-clear mui-input" placeholder="请确认密码">
    </div>
  </div>
  <div class="mui-card-header">
    <div class="mui-input-row">
      <label>地址</label>
      <input id='shopAdd' type="text" class="mui-input-clear mui-input" placeholder="请输入地址">
    </div>
  </div>
  <div class="mui-card-header">
    <div class="mui-input-row">
      <label>电话</label>
      <input id='shopTel' type="tel" class="mui-input-clear mui-input" placeholder="请输入电话">
    </div>
  </div>
  <div class="mui-card-header">
    <button id='zhuce' type="button" class="mui-btn mui-btn-block mui-btn-danger">
      注册商户
    </button>
  </div>
</div>
</body>

</html>
