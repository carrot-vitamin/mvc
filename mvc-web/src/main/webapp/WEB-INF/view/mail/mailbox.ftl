<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<#include "../static.datatables.ftl"/>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
    <#include "left.ftl"/>
        <div class="col-sm-9">
            <div class="mail-box-header">
                <form method="get" action="http://www.zi-han.net/theme/hplus/index.html" class="pull-right mail-search">
                    <div class="input-group">
                        <input type="text" class="form-control input-sm" name="search" placeholder="搜索邮件标题，正文等">
                        <div class="input-group-btn">
                            <button type="submit" class="btn btn-sm btn-primary">
                                搜索
                            </button>
                        </div>
                    </div>
                </form>
                <h2>
                    收件箱 (${allcount!""})
                </h2>
                <div class="mail-tools tooltip-demo m-t-md">
                    <div class="btn-group pull-right">
                        <button class="btn btn-white btn-sm"><i class="fa fa-arrow-left"></i></button>
                        <button class="btn btn-white btn-sm"><i class="fa fa-arrow-right"></i></button>
                    </div>
                    <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="left" title="刷新邮件列表"><i
                            class="fa fa-refresh"></i> 刷新
                    </button>
                    <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为已读"><i
                            class="fa fa-eye"></i>
                    </button>
                    <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为重要"><i
                            class="fa fa-exclamation"></i>
                    </button>
                    <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="标为垃圾邮件"><i
                            class="fa fa-trash-o"></i>
                    </button>

                </div>
            </div>
            <div class="mail-box">
                <table class="table table-hover table-mail" id="reciveMailTable">
                    <thead>
                    <tr>
                        <th></th>
                        <th>发件人</th>
                        <th>主题</th>
                        <th class="text-right mail-date">发送时间</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    /*var reciveMailTable = $('#reciveMailTable').DataTable({
        ajax: '/mail/getAllReceive',
        dom: 'tipr',
        language: {url : "/language/db_zh_CN.json"},
        columns: [
            { className: "check-mail", render: function ( data, type, row, meta ) {return '<input type="checkbox" class="i-checks">'}},
            { data: 'fromUser', className: "mail-contact"},
            { data: 'subject', className: "mail-subject"},
            { data: 'sendDate', className: "text-right mail-date"}
        ],
        rowCallback: function (row, data, index) {
            if (data.needToRead) {
                $(row).attr("class", "unread");
            }
        }
    })*/
</script>
</body>
</html>
