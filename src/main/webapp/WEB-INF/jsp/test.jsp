<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2018/4/24
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sfdjfjklsdf</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="../../resources/css/mui.min.css" rel="stylesheet"/>
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../../resources/js/mui.min.js"></script>
</head>
<body>

<div class="mui-card">

    <div class="mui-card-content">
        <ul><h3>采用批量导入</h3><br></ul>
        <ul><h4>第一步：下载并阅读说明</h4></ul>
        <ul><a href="resources/doc/批量导入说明.doc" style="color: red">批量导入说明</a></ul>
        <ul><h4>第二步：下载电子表格模板</h4></ul>
        <ul><a href="resources/doc/菜单模板.csv" style="color: red">菜单模板</a></ul>
        <ul><h4>第三步： 上传电子表格</h4></ul>
        <ul>
            <form method="post" action="/fileUpload.do" enctype="multipart/form-data">
                选择一个文件:
                <br/><br/>
                <input hidden type="text" name="shopId" value=${sessionScope.shop.shopId} >
                <ul>电子表格文件</ul>
                <input type="file" name="uploadFile" style="color: red"/>
                <ul>图片压缩包</ul>
                <input type="file" name="uploadZip" style="color: red"/>
                <br/><br/>
                <button type="submit" class="mui-right mui-btn-danger" style="width: 100px;height: 40px">上传文件</button>
            </form>
        </ul>

    </div>


</div>
</body>
</html>
