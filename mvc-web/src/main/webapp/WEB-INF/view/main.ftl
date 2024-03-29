<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <title>主页</title>

<#include "static.core.ftl"/>

    <!--Toast-->
    <link href="${base}/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <script src="${base}/js/plugins/toastr/toastr.min.js"></script>

    <!--DWR-->
    <script type="text/javascript" src="dwr/engine.js"></script>
    <script type="text/javascript" src="dwr/interface/MessagePush.js"></script>
    <script type="text/javascript" src="dwr/util.js"></script>
</head>

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
                        <span><img alt="image" class="img-circle" src="img/profile_small.jpg"/></span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">Beaut-zihan</strong></span>
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                        </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
                            </li>
                            <li><a class="J_menuItem" href="profile.html">个人资料</a>
                            </li>
                            <li><a class="J_menuItem" href="contacts.html">联系我们</a>
                            </li>
                            <li><a class="J_menuItem" href="mailbox.html">信箱</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="logout">安全退出</a>
                            </li>
                        </ul>
                    </div>
                    <div class="logo-element">H+
                    </div>
                </li>
            <#--定义遍历单个菜单的宏开始-->
            <#macro treeMenu menu>
                <li>
                    <a href="#">
                        <i class="${menu.icon}"></i>
                        <span class="nav-label">${menu.title}</span>
                        <#if menu.children?? && (menu.children?size gt 0)>
                            <span class="fa arrow"></span>
                        </#if>
                    </a>
                    <#if menu.children?? && (menu.children?size gt 0)>
                        <ul class="nav nav-second-level">
                            <#list menu.children as child>
                                <#if child?? && (child?size gt 0)>
                                    <@treeMenu child/>
                                <#else>
                                    <li>
                                        <a class="J_menuItem" href="${child.path}">${child.title}</a>
                                    </li>
                                </#if>
                            </#list>
                        </ul>
                    </#if>
                </li>
            </#macro>
            <#--定义遍历单个菜单的宏结束-->
                <!--遍历菜单开始-->
            <#if menuList?? && (menuList?size gt 0)>
                <#list menuList as menu>
                    <li>
                        <a href="#">
                            <i class="${menu.icon}"></i>
                            <span class="nav-label">${menu.title}</span>
                            <span class="fa arrow"></span>
                        </a>
                        <#if menu.children?? && (menu.children?size gt 0)>
                            <ul class="nav nav-second-level">
                                <#list menu.children as child>
                                    <#if child.children?size gt 0>
                                        <@treeMenu child/>
                                    <#else>
                                        <li>
                                            <a class="J_menuItem" href="${base}${child.path}">${child.title}</a>
                                        </li>
                                    </#if>
                                </#list>
                            </ul>
                        </#if>
                    </li>
                </#list>
            </#if>
                <!--遍历菜单结束-->
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i></a>
                    <strong class="navbar-text"
                            style="margin-top: 18px">欢迎，${user.username}！这是您第${user.loginTimes}次登陆<#if user.lastLoginDate??>
                        ，上次登录时间：${user.lastLoginDate?string('yyyy-MM-dd HH:mm:ss')}</#if></strong>
                </div>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab" data-id="main">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="" frameborder="0" data-id=""
                    seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">&copy; 2016-2018 <a href="https://www.baidu.com" target="_blank">www.baidu.com</a>
            </div>
        </div>
    </div>
    <!--右侧部分结束-->
</div>
<script src="${base}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${base}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${base}/js/plugins/layer/layer.min.js"></script>
<script src="${base}/js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="${base}/js/contabs.min.js"></script>
<script src="${base}/js/plugins/pace/pace.min.js"></script>

<script type="text/javascript">
    function showMessage(data) {
        console.log(data);
        $(".navbar-text").html(data);
        toastr.success(data, "成功");
    }

    function onPageLoad() {
        var userId = '${user.id}';
        MessagePush.onPageLoad(userId);
    }

    $(document).ready(function () {
        dwr.engine.setActiveReverseAjax(true);
        dwr.engine.setNotifyServerOnPageUnload(true);
        onPageLoad();
    })
</script>
</body>
</html>