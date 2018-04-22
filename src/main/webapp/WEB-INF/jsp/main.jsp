<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2018/4/21
  Time: 16:00
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
        .mui-bar{
            background-color: rgba(247,247,247,.35);
        }

    </style>

</head>



<body>
<header class="mui-bar mui-bar-nav">
    <a class= mui-icon ></a>
    <h1 id="title" class="mui-title">首页</h1>
</header>

<nav class="mui-bar mui-bar-tab">
    <a id="defaultTab" class="mui-tab-item mui-active" href="/workdesk">
        <span class="mui-icon mui-icon-gear-filled"></span>
        <span class="mui-tab-label">工作台</span>
    </a>
    <a class="mui-tab-item" href="/order">
        <span class="mui-icon mui-icon-email-filled"></span>
        <span class="mui-tab-label">订单</span>
    </a>
    <a class="mui-tab-item" href="/shop">
        <span class="mui-icon mui-icon-contact-filled"></span>
        <span class="mui-tab-label">商户</span>
    </a>
</nav>

<script type="text/javascript" charset="utf-8">
    //mui初始化
    mui.init();
    var subpages = ['/workdesk', '/order', '/shop'];
    var subpage_style = {
        top: '45px',
        bottom: '51px'
    };
    var aniShow = {};

    //创建子页面，首个选项卡页面显示，其它均隐藏；
    mui.plusReady(function() {
        var self = plus.webview.currentWebview();
        for (var i = 0; i < 3; i++) {
            var temp = {};
            var sub = plus.webview.create(subpages[i], subpages[i], subpage_style);
            if (i > 0) {
                sub.hide(); // 其它均隐藏
            }else{
                sub.show(); // 首个选项卡页面显示
                temp[subpages[i]] = "true";
                mui.extend(aniShow,temp);
            }
            self.append(sub);
        }
    });
    //当前激活选项
    var activeTab = subpages[0];
    var title = document.getElementById("title");
    //选项卡点击事件
    mui('.mui-bar-tab').on('tap', 'a', function(e) {
        var targetTab = this.getAttribute('href');
        if (targetTab == activeTab) {
            return;
        }
        //更换标题
        title.innerHTML = this.querySelector('.mui-tab-label').innerHTML;
        //显示目标选项卡
        //若为iOS平台或非首次显示，则直接显示
        if(mui.os.ios||aniShow[targetTab]){
            plus.webview.show(targetTab);
        }else{ //否则，使用fade-in动画，且保存变量
            var temp = {};
            temp[targetTab] = "true";
            mui.extend(aniShow,temp);
            plus.webview.show(targetTab,"fade-in",300);
        }
        //隐藏当前;
        plus.webview.hide(activeTab);
        //更改当前活跃的选项卡
        activeTab = targetTab;
    });
    //自定义事件，模拟点击“首页选项卡”
    document.addEventListener('gohome', function() {
        var defaultTab = document.getElementById("defaultTab");
        //模拟首页点击
        mui.trigger(defaultTab, 'tap');
        //切换选项卡高亮
        var current = document.querySelector(".mui-bar-tab>.mui-tab-item.mui-active");
        if (defaultTab !== current) {
            current.classList.remove('mui-active');
            defaultTab.classList.add('mui-active');
        }
    });
</script>
</body>
</html>
