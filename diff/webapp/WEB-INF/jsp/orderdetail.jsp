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
    <script src="../../resources/js/plus.js"></script>
    <script type="text/javascript">
        mui.init();
    </script>
    <style>
        a{
            color: red;
        }
    </style>
</head>
<body>
<div id="pullrefresh" class="mui-content mui-scroll-wrapper">
    <div class="mui-card-content">
        <div class="mui-card">
    <div class="mui-card-header">
        <b>订单未配送</b>
    </div>
    <div class="mui-card-content">
        <ul class="mui-table-view">
        <li class="mui-table-view-cell mui-media">
            <div class="mui-media-body">
                <img class="mui-media-object mui-pull-left" src="../../resources/img/cbd.jpg">
                佛跳墙
                <p class='mui-ellipsis'>X1</p>
                <b class='mui-ellipsis mui-pull-right'>￥100</b>
            </div>
        </li>
        </ul>
    </div>
    <div class="mui-card-content">
        <ul class="mui-table-view">
            <li class="mui-table-view-cell mui-media">
                <div class="mui-media-body">
                    <img class="mui-media-object mui-pull-left" src="../../resources/img/cbd.jpg">
                    佛跳墙
                    <p class='mui-ellipsis'>X1</p>
                    <b class='mui-ellipsis mui-pull-right'>￥100</b>
                </div>
            </li>
        </ul>
    </div>
    <div class="mui-card-footer">
        配送费
        <b class='mui-pull-right' id="配送费">￥100</b>
    </div>
    <div class="mui-card-footer">
        <a>满减优惠</a>
        <b class='mui-pull-right' id="满减优惠">￥100</b>
    </div>
    <div class="mui-card-footer">
        <a>合计:</a>
        <b class='mui-pull-right' id="总价">￥300</b>
    </div>
</div>
        <div class="mui-card">
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
        <div class="mui-card">
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
        <div class="mui-card">
    <ui class="mui-table-view">
        <li class="mui-table-view-cell">
            订单号
            <b class="mui-pull-right">123456899</b>
        </li>
        <li class="mui-table-view-cell">
            下单时间
            <b class="mui-pull-right">2088.8.8</b>
        </li>
        <li class="mui-table-view-cell">
            预计送达时间
            <b class="mui-pull-right">2099.9.9</b>
        </li>
    </ui>
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

<script>
    var bussinessid=${sessionScope.shop.shopId};
    $.ajax({
        type:'POST',
        url:"/ordersSelectALLByShopId.do",
        data:{
            "shopId":bussinessid
        },
        success:function(data) {


        }
        }
    )
</script>
</body>
</html>
