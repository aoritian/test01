<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title> 八识智云- 主页</title>
    <link rel="Shortcut Icon" href="${ctx!}/assets/img/logo.png" />
    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">
</head>
<script type="text/javascript">
    function disptime(){
        var today=new Date();
        var hh=today.getHours();
        var mm=today.getMinutes();
        var ss = today.getSeconds();
        document.getElementById("myclock").innerHTML="当前时间—"+hh+":"+mm+":"+ss+""

    }
    //setInterval（）方法可以按照指定的周期调用函数或计算表达式
    var mytime = setInterval("disptime()",1000);
</script>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0)">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <#--<i class="fa fa-area-chart"></i>-->

                                            <img src="${ctx!}/assets/img/logo.png" height="40" width="40"/>
                                        <strong class="font-bold">&nbsp;&nbsp;八识智云</strong>
                                    </span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">八识智云</div>
                </li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">分类</span>
                </li>
                <li>
                    <a class="J_menuItem" href="${ctx!}/admin/welcome">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                    </a>
                </li>
                <@shiro.hasPermission name="system:user:index">
                <li>
                    <a href="javascript:void(0)">
                        <i class="fa fa fa-cog"></i>

                        <span class="nav-label">系统管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                         <@shiro.hasPermission name="system:user:index">
                            <li>
                                <a class="J_menuItem" href="${ctx!}/admin/user/index">用户管理</a>
                            </li>
                         </@shiro.hasPermission>
                         <@shiro.hasPermission name="system:role:index">
                            <li>
                                <a class="J_menuItem" href="${ctx!}/admin/role/index">角色管理</a>
                            </li>
                         </@shiro.hasPermission>
                         <#--<@shiro.hasPermission name="system:resource:index">-->
                            <#--<li>-->
                                <#--<a class="J_menuItem" href="${ctx!}/admin/resource/index">资源管理</a>-->
                            <#--</li>-->
                         <#--</@shiro.hasPermission>-->
                    </ul>
                </li>
                </@shiro.hasPermission>



                <li>
                    <a href="javascript:void(0)">
                        <i class="fa fa fa-cog"></i>

                        <span class="nav-label">设备管理</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                            <@shiro.hasPermission name="system:user:index">
                            <li>
                                <a class="J_menuItem" href="${ctx!}/admin/device/index">查看所有设备</a>
                            </li>
                            </@shiro.hasPermission>

                            <li>
                                <a class="J_menuItem" href="${ctx!}/admin/device/mylist">我的设备</a>
                            </li>

                    </ul>
                </li>




                <li class="line dk"></li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i
                        class="fa fa-bars"></i> </a>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <span class="label label-primary"></span>【<@shiro.principal type="com.owen.User" property="nickName"/>】
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a onclick="updatePwd()">
                                    <div>
                                        <i class="fa fa-refresh"></i> 修改密码
                                        <span class="pull-right text-muted small"><@shiro.principal type="com.owen.User" property="userName"/></span>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="${ctx!}/admin/logout">
                                    <div>
                                        <i class="fa fa-remove"></i> 注销
                                        <span class="pull-right text-muted small"><@shiro.principal type="com.owen.User" property="userName"/></span>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%" src="${ctx!}/admin/welcome" frameborder="0"
                    data-id="index_v1.html" seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>

<!-- 全局js -->
<script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${ctx!}/assets/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctx!}/assets/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="${ctx!}/assets/js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="${ctx!}/assets/js/index.js"></script>
<script type="text/javascript">
    function updatePwd() {
        layer.open({
            type: 2,
            title: '修改密码',
            shadeClose: true,
            shade: false,
            area: ['893px', '600px'],
            content: '${ctx!}/admin/user/updatePwd',
            end: function (index) {
                window.location.reload();
            }
        });
    }
</script>
</body>

</html>
