<%--
  Created by IntelliJ IDEA.
  User: zz
  Date: 18-4-21
  Time: 下午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session测试</title>
    //以下是写在html
    <head>标签中的tmpl模板：
        <script>
            // 给多个按钮添加ID
            var cartList = [
                {classification: "饮料", name: "可口可乐", price: "3", unit: "瓶", id: "1"},
                {classification: "饮料", name: "雪碧", price: "3", unit: "瓶", id: "2"},
                {classification: "水果", name: "苹果", price: "5.5", unit: "斤", id: "3"},
                {classification: "水果", name: "荔枝", price: "15", unit: "斤", id: "4"},
                {classification: "生活用品", name: "电池", price: "2", unit: "个", id: "5"},
                {classification: "食品", name: "方便面", price: "4.5", unit: "袋", id: "6"}
            ]
        </script>
        <script>
             function loadAll() {
                var list = document.getElementById("list");
                var result = "<table>",z;
                result += "<tr><td>商品</td><td>价格</td><td>操作</td></tr>";
                for (z = 0; z < 10; z++) {
                    result += "<tr><td>" + cartList[z].id + "</td>" +
                        "<td>" +  cartList[z].name + "" + "</td>" +
                        "<td><button id = 'btn3' onclick='alal(this)'>删除</button></td></tr>";
                }
                    list.innerHTML = result;
//每次加载商品信息同时刷新总价格
            }
            function alal() {
                alert("ddddd")
            }
        </script>
    </head>
<body>
${sessionScope}<br>
<button id="add" onclick="addClickEvent()">add</button>
<br>
********************************************<br>


</body>
</html>
