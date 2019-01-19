<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<#include "../static.core.ftl"/>
    <script src="${base}/js/plugins/suggest/bootstrap-suggest.min.js"></script>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
    <#include "left.ftl"/>
        <div class="col-sm-9">
            <div class="mail-box-header">
                <div class="pull-right tooltip-demo">
                    <a href="mailbox.html" class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top"
                       title="存为草稿"><i class="fa fa-pencil"></i> 存为草稿</a>
                    <a href="mailbox.html" class="btn btn-danger btn-sm" data-toggle="tooltip" data-placement="top"
                       title="放弃"><i class="fa fa-times"></i> 放弃</a>
                </div>
                <h2>
                    写信
                </h2>
            </div>
            <div class="mail-box">
                <div class="mail-body">
                    <form class="form-horizontal" method="get">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">发送到：</label>
                            <div class="col-sm-10">
                                <div class="input-group">
                                    <input type="text" class="form-control" id="toUsers">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-white dropdown-toggle"
                                                data-toggle="dropdown">
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">主题：</label>
                            <div class="col-sm-10">
                                <input id="subject" type="text" class="form-control" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <label class="col-sm-1 control-label">&nbsp;</label>
                                <div class="col-sm-11" style="padding-right: 0px;">
                                    <textarea class="form-control" rows="3" placeholder="说输入内容... ..."></textarea>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="mail-body text-right tooltip-demo">
                    <a href="#" class="btn btn-sm btn-primary" data-toggle="tooltip" data-placement="top"
                       title="Send"><i class="fa fa-reply"></i> 发送</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<script>
    $("[title='Send']").click(function () {
        alert($("#toUsers").val() + ";" + $("#subject").val() + ";" + $("#content").val())
    });
    var userSuggest = $("#toUsers").bsSuggest({
        indexId: 2,
        indexKey: 1,
        allowNoKeyword: false,
        multiWord: true,
        separator: ",",
        getDataMethod: "url",
        effectiveFieldsAlias: {
            Id: "序号",
            Keyword: "关键字",
            Count: "数量"
        },
        showHeader: true,
        url: "http://suggest.taobao.com/sug?code=utf-8&extras=1&q=",
        jsonp: "callback",
        processData: function (json) {
            var i, len, data = {
                value: []
            };
            if (!json || !json.result || json.result.length == 0) {
                return false
            }
            console.log(json);
            len = json.result.length;
            for (i = 0; i < len; i++) {
                data.value.push({
                    "Id": (i + 1),
                    "Keyword": json.result[i][0],
                    "Count": json.result[i][1]
                })
            }
            console.log(data);
            return data
        }
    });
</script>
</body>
</html>