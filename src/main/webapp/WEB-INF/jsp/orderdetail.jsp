<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2018/4/21
  Time: 16:56
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
    <script src="../../resources/js/plus.js"></script>
    <script type="text/javascript">
        mui.init();
        var q=${local};
        function qwqw(){
            var busid=${sessionScope.shop.shopId};
            $.ajax({
                type: 'POST',
                url: "/ordersSelectALLByShopId.do",
                data: {
                    "shopId": busid
                },
                success: function (data) {
                    $('#订单状态').html(data[q].order_status);

                    $('#合计').html("￥"+data[q].order_money);
                    if (data[q].order_status==="未接单"){
                        $('#配送员').html("暂无");
                        $('#配送员电话').html("暂无");}
                    else{
                        $('#配送员').html(data[q].horseman_id);
                        $('#配送员电话').html(data[q].horseman_tel);}
                    $('#客户').html(data[q].user_name);
                    $('#配送地点').html(data[q].user_add);
                    $('#用户电话').html(data[q].user_tel);
                    $('#订单号').html(data[q].order_id);
                    var d = new Date(data[q].order_time);
                    var e = new Date(data[q].order_time+1800000);
                    function datenow(now) {
                        var year = now.getFullYear();
                        var month = now.getMonth() + 1;
                        var date = now.getDate();
                        var hour = now.getHours();
                        var minute = now.getMinutes();
                        var second = now.getSeconds();
                        return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
                    }
                    $('#下单时间').html(datenow(d));
                    $('#送达时间').html(datenow(e));
                    var food;
                    var foodmoney=0;
                    for (food=0;food<data[q].food_list.length;food++) {
                    $('#菜品').append(
                        '<ul class="mui-table-view">'+
                        '<li class="mui-table-view-cell mui-media">'+
                        '<div class="mui-media-body">'+
                        '<img class="mui-media-object mui-pull-left" src="../../'+data[q].food_list[food].foodShop.foodPic+'">' +
                        '<p>'+data[q].food_list[food].food_name+'</p>'+
                        '<b class="mui-ellipsis mui-pull-right">￥'+data[q].food_list[food].foodShop.foodPrice+'x'+data[q].food_list[food].food_count+'</b>'+
                        '</div>'+
                        '</li>'+
                        '</ul>');
                    foodmoney=foodmoney+(data[q].food_list[food].foodShop.foodPrice*data[q].food_list[food].food_count);
                    }
                    $('#配送费').html("￥"+(data[q].order_money-foodmoney));
                }});
        }
    </script>
    <style>
        a{
            color: red;
        }
    </style>
</head>
<body onload="qwqw()">
<div id="pullrefresh" class="mui-content mui-scroll-wrapper">
    <div class=" mui-row">
     <div class="mui-col-xs-12 mui-col-sm-7">
        <div class="mui-card ">
    <div class="mui-card-header">
        <b id="订单状态"></b>
    </div>
    <div class="mui-card-content" id="菜品">


    </div>
    <div class="mui-card-footer">
        配送费
        <b class='mui-pull-right' id="配送费">￥0</b>
    </div>
    <div class="mui-card-footer">
        <a>满减优惠</a>
        <b class='mui-pull-right' id="满减优惠">￥0</b>
    </div>
    <div class="mui-card-footer">
        <a >合计:</a>
        <b class='mui-pull-right' id="合计" ></b>
    </div>
</div>
     </div>
        <div class="mui-col-xs-12 mui-col-sm-5">
        <div class="mui-card ">
            <ui class="mui-table-view">
                <li class="mui-table-view-cell">
                    配送员
                    <b class="mui-pull-right" id="配送员">安倍晋三</b>
                </li>
                <li class="mui-table-view-cell">
                    配送员电话
                    <b class="mui-pull-right" id="配送员电话">18888888888</b>
                </li>
            </ui>
        </div>
        <div class="mui-card ">
    <ui class="mui-table-view">
        <li class="mui-table-view-cell">
            客户
            <b class="mui-pull-right" id="客户">特朗普</b>
        </li>
        <li class="mui-table-view-cell">
            配送地点
            <b class="mui-pull-right" id="配送地点">俄克拉荷马</b>
        </li>
        <li class="mui-table-view-cell">
            客户电话
            <b class="mui-pull-right" id="用户电话">18888888888</b>
        </li>
    </ui>
</div>
<div class="mui-card ">
    <ui class="mui-table-view">
        <li class="mui-table-view-cell">
            订单号
            <b class="mui-pull-right" id="订单号">123456899</b>
        </li>
        <li class="mui-table-view-cell" >
            下单时间
            <b class="mui-pull-right" id="下单时间">2088.8.8</b>
        </li>
        <li class="mui-table-view-cell">
            预计送达时间
            <b class="mui-pull-right" id="送达时间">送不到</b>
        </li>
    </ui>
</div>
            </div>
</div>
</div>
<%--下拉刷新--%>
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
        setTimeout(function() {
            mui('#pullrefresh').pullRefresh().endPulldownToRefresh(); //refresh completed
        }, 1000);
    }
    var count = 0;
    /**
     * 上拉加载具体业务实现
     */
    function pullupRefresh() {
        setTimeout(function() {
            mui('#pullrefresh').pullRefresh().endPullupToRefresh((++count > 2)); //参数为true代表没有更多数据了。
        }, 1000);
    }
</script>

</body>
</html>
