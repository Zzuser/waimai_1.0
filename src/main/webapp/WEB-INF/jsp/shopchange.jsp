<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 18-5-14
  Time: 下午4:15
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
</head>
<body>
<div class="mui-card">
    <form method="post" action="/shopChange.do" enctype="multipart/form-data" accept-charset="UTF-8">

        <input hidden name='shopId' value=${sessionScope.shop.shopId} type="text" >

    <div hidden class="mui-card-header">
        <div class="mui-input-row">
            <label>商户名</label>
            <input name='shopName' type="text" class="mui-input-clear mui-input" placeholder="请输入商户名">
        </div>
    </div>
    <div class="mui-card-header">
        <div class="mui-input-row">
            <label>密码</label>
            <input name='shopPsw' type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
        </div>
    </div>
    <div class="mui-card-header">
        <div class="mui-input-row">
            <label>更改图片</label>
            <input type="file" name="uploadImg" style="color: red" id="shopImg"/>
        </div>
    </div>
    <div class="mui-card-header">
        <div class="mui-input-row">
            <label>地址</label>
            <input name='shopAdd' type="text" class="mui-input-clear mui-input" placeholder="请输入地址">
        </div>
    </div>
    <div class="mui-card-header">
        <div class="mui-input-row">
            <label>电话</label>
            <input name='shopTel' type="tel" class="mui-input-clear mui-input" placeholder="请输入电话">
        </div>
    </div>
        <div class="mui-card-header">
            <div class="mui-input-row">
                <label>配送费</label>
                <input name='deliveryFee' type="number" class="mui-input-clear mui-input" placeholder="请输入配送费">
            </div>
        </div>
    <div class="mui-card-header">
        <button id='zhuce' type="submit" class="mui-btn mui-btn-block mui-btn-danger">
            修改信息
        </button>
    </div>
    </form>
</div>

    <%--选择一个文件:--%>
    <%--<br/><br/>--%>
    <%--<input hidden type="text" name="shopId" value=${sessionScope.shop.shopId}>--%>
    <%--<ul>电子表格文件</ul>--%>
    <%--<input type="file" name="uploadFile" style="color: red"/>--%>
    <%--<ul>图片压缩包</ul>--%>
    <%--<input type="file" name="uploadZip" style="color: red"/>--%>
    <%--<br/><br/>--%>
    <%--<button id="upload" type="submit" class="mui-right mui-btn-danger" style="width: 100px;height: 40px">--%>
        <%--上传文件--%>
    <%--</button>--%>


</body>
</html>
