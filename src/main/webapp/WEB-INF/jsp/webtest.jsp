<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>tttt</head>
<form action="/shopSelectByShopId.do" method="post">
    <input name="shopId" type="text">
    <input type="submit" value="sdfsa">
</form>
</html>