<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2018/4/21
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Hello MUI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="../../resources/css/mui.min.css">
    <script src="../../resources/js/jquery-3.3.1.min.js"></script>
    <script src="../../resources/js/mui.min.js"></script>
    <script src="../../resources/js/template-web.js"></script>
    <style>
        html,body {
            background-color: #efeff4;
        }
        .title {
            padding: 20px 15px 10px;
            color: #6d6d72;
            font-size: 15px;
            background-color: #fff;
        }
    </style>

    <%--<script type="text/javascript" charset="UTF-8">--%>

    <%--var bussinessid=${sessionScope.shop.shopId};--%>
    <%--$.ajax({--%>
    <%--type:'POST',--%>
    <%--url:"/ordersSelectALLByShopId.do",--%>
    <%--data:{--%>
    <%--"shopId":bussinessid--%>
    <%--},--%>
    <%--success:function(data) {--%>

    <%--}--%>
    <%--});--%>

    <%--</script>--%>
</head>
<body>


<div id="pullrefresh" class="mui-content mui-scroll-wrapper">
    <div class="mui-scroll">
        <div id="slider" class="mui-slider">
            <!--三个状态选项卡-->
            <div id="sliderSegmentedControl" class="mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
                <a class="mui-control-item" href="#item1mobile">
                    未接单
                </a>
                <a class="mui-control-item" href="#item2mobile">
                    未配送
                </a>
                <a class="mui-control-item" href="#item3mobile">
                    已完成
                </a>
            </div>
            <!--横线或许？？-->
            <div id="sliderProgressBar" class="mui-slider-progress-bar mui-col-xs-4"></div>
            <div class="mui-slider-group">
                <div id="item1mobile" class="mui-slider-item mui-control-content mui-active">
                    <!--遍历订单结果-->
                    <script type="text/javascript" charset="UTF-8">
                        var bussinessid=${sessionScope.shop.shopId};
                        $.ajax({
                                type:'POST',
                                url:"/ordersSelectALLByShopId.do",
                                data:{
                                    "shopId":bussinessid
                                },
                                success:function(data) {
                                    var z;var x;var c;
                                    var str;

                                    for(z=0;z<data.length;z++) {
                                        $('#外部').append(
                                            '<div class="mui-card">'+
                                            '<div class="mui-card-header" id="'+z+'shangbu"></div>'+
                                            '<div class="mui-card-header" id="'+z+'zhongbu"></div>'+
                                            '<div class="mui-card-header mui-pull-right" id="'+z+'xiabu"></div>'+
                                            '</div>');
                                        $('#'+z+'shangbu').append(
                                            '<h4>用户：'+data[z].user_name+'</h4>' +
                                            '<button  id="'+data[z].order_number+'" class="mui-btn-blue">订单详情</button>'
                                        );
                                        for (x=0;x<data[z].food_list.length;x++) {
                                            $('#'+z+'zhongbu').append(
                                                '<div class="mui-card-content">'+
                                                '<div class="mui-pull-left">' + data[z].food_list[x].food_name+'</div>' +
                                                '<div class="mui-pull-right">x'+data[z].food_list[x].foodShop.foodNum+'</div></div>'

                                            );
                                        }
                                        $('#'+z+'xiabu').append(
                                            '<button class="mui-btn-blue mui-pull-right" type="button">接单'+data[z].user_tel+'</button>'
                                        );
                                        document.getElementById(data[z].order_number).addEventListener('click', function(){
                                            window.location.href="/orderdetail";
                                        }, false);
                                    }

                                },

                            }
                        )
                    </script>
                    <div id="外部">

                    </div>
                </div>
                <div id="item2mobile" class="mui-slider-item mui-control-content">
                    <!--遍历订单结果-->
                    <div id="result2">
                        <%--<script type="text/javascript">--%>
                        <%--var url = '/ordersSelectALLByShopId.do';--%>
                        <%--$.getJSON(url,function(data){--%>
                        <%--var z;--%>
                        <%--for(z=0;z<10;z++){--%>
                        <%--$('#result2').append('<div class="mui-card" style="margin-bottom: 35px">'+--%>
                        <%--'<div class="mui-card-header">'+--%>
                        <%--'<h4>用户：</h4>'+--%>
                        <%--'</div>'+--%>
                        <%--'<div class="mui-card-header">'+--%>


                        <%--'<div class="mui-pull-left">'+--%>
                        <%--'菜品</div>'+--%>
                        <%--'<div class="mui-pull-right">数量</div>'+--%>



                        <%--'</div>'+--%>
                        <%--'<div class="mui-card-header mui-pull-right">'+--%>
                        <%--'<button class="mui-badge-success">接单</button>'+--%>
                        <%--'</div>'+--%>
                        <%--'</div>');--%>
                        <%--//后面的也都一样--%>
                        <%--}--%>
                        <%--});--%>
                        <%--</script>--%>
                    </div>
                </div>
                <div id="item3mobile" class="mui-slider-item mui-control-content">
                    <!--遍历订单结果-->
                    <div class="mui-card">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>




<!--实现下拉刷新-->
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

<!--实现订单滑动-->
<script>
    mui.init({
        swipeBack: false
    });
    (function($) {
        $('.mui-scroll-wrapper').scroll({
            indicators: true //是否显示滚动条
        });
        var html2 = '<ul class="mui-table-view"><li class="mui-table-view-cell">第二个选项卡子项-1</li><li class="mui-table-view-cell">第二个选项卡子项-2</li><li class="mui-table-view-cell">第二个选项卡子项-3</li><li class="mui-table-view-cell">第二个选项卡子项-4</li><li class="mui-table-view-cell">第二个选项卡子项-5</li></ul>';
        var html3 = '<ul class="mui-table-view"><li class="mui-table-view-cell">第三个选项卡子项-1</li><li class="mui-table-view-cell">第三个选项卡子项-2</li><li class="mui-table-view-cell">第三个选项卡子项-3</li><li class="mui-table-view-cell">第三个选项卡子项-4</li><li class="mui-table-view-cell">第三个选项卡子项-5</li></ul>';
        var item2 = document.getElementById('item2mobile');
        var item3 = document.getElementById('item3mobile');
        document.getElementById('slider').addEventListener('slide', function(e) {
            if (e.detail.slideNumber === 1) {
                if (item2.querySelector('.mui-loading')) {
                    setTimeout(function() {
                        item2.querySelector('.mui-scroll').innerHTML = html2;
                    }, 500);
                }
            } else if (e.detail.slideNumber === 2) {
                if (item3.querySelector('.mui-loading')) {
                    setTimeout(function() {
                        item3.querySelector('.mui-scroll').innerHTML = html3;
                    }, 500);
                }
            }
        });
        var sliderSegmentedControl = document.getElementById('sliderSegmentedControl');
        $('.mui-input-group').on('change', 'input', function() {
            if (this.checked) {
                sliderSegmentedControl.className = 'mui-slider-indicator mui-segmented-control mui-segmented-control-inverted mui-segmented-control-' + this.value;
                //force repaint
                sliderProgressBar.setAttribute('style', sliderProgressBar.getAttribute('style'));
            }
        });
    })(mui);
</script>


</body>
</html>
