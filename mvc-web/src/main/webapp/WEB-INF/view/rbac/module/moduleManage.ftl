<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

<#include "../../static.datatables.ftl"/>
</head>
<body class="gray-bg">
<!--新增，修改模态框-->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="row">
                    <form role="form" method="post">
                        <h3 class="m-t-none m-b" id="modalTitle"></h3>
                        <input id="moduleId" type="text" style="display: none" name="id">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label>模块代码：</label>
                                <input type="text" id="codeId" name="code" placeholder="请输入模块代码" class="form-control"
                                       required>
                            </div>
                            <div class="form-group">
                                <label>模块路径：</label>
                                <input type="text" id="pathId" name="path" placeholder="请输入模块路径" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <div class="form-group">
                                <label>模块名称：</label>
                                <input type="text" id="titleId" name="title" placeholder="请输入模块名称" class="form-control"
                                       required>
                            </div>
                            <div class="form-group">
                                <label>模块图标：</label>
                                <input type="text" id="iconId" name="icon" placeholder="请输入模块图标" class="form-control">
                            </div>
                        </div>

                        <div class="col-sm-12">
                            <label>父模块：</label>
                            <select class="form-control" id="select_id" name="parent">
                                <option></option>
                            </select>
                        </div>
                        <div class="col-sm-12" style="margin-top: 20px">
                            <div>
                                <button class="btn btn-sm btn-primary pull-right m-t-n-xs" id="saveId" type="submit">
                                    <strong>保存</strong></button>
                                <button type="button" class="btn btn-sm btn-default pull-right m-t-n-xs"
                                        data-dismiss="modal">关闭
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    //模态框开启时初始化模块列表下拉框
    $('.bs-example-modal-sm').on('show.bs.modal', function (e) {
        $.get("${base}/rbacModule/all", function (result) {
            if (result.responseCode == '200') {
                var modules = result.data;
                for (var i = 0; i < modules.length; i++) {
                    var module = modules[i];
                    $("#select_id").append("<option value=" + module.id + ">" + module.title + "</option>");
                }
            }
        });
    })
</script>

<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>模块管理</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-md-3 col-md-offset-2">
                            <div class="input-group">
                                <span class="input-group-addon">模块ID</span>
                                <input type="text" class="form-control" placeholder="根据模块ID查询"
                                       aria-describedby="basic-addon1">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="input-group">
                                <span class="input-group-addon">模块名称</span>
                                <input type="text" class="form-control" placeholder="根据模块名称查询"
                                       aria-describedby="basic-addon1">
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="input-group">
                                <span class="input-group-addon">模块说明</span>
                                <input type="text" class="form-control" placeholder="根据模块说明查询"
                                       aria-describedby="basic-addon1">
                            </div>
                        </div>
                        <div class="col-md-1">
                            <button class="btn btn-primary" type="button">查询</button>
                        </div>
                    </div>
                    <div class="row" style="margin-top: 5px;margin-bottom: 5px">
                        <div class="col-md-4">
                            <button type="button" class="btn btn-default btn-xs addModule" onclick="showModuleModal()">
                                新增模块
                            </button>
                            <button type="button" class="btn btn-default btn-xs delete">删除模块</button>
                            <button type="button" class="btn btn-default btn-xs relatePermission">关联权限</button>
                        </div>
                    </div>

                    <table id="moduleTable" class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>
                                <div class="checkbox"><input type="checkbox" class="chooseAll" style="margin-left: 1px">
                                </div>
                            </th>
                            <th>模块ID</th>
                            <th>模块代码</th>
                            <th>模块名称</th>
                            <th>模块路径</th>
                            <th>模块图标</th>
                            <th>父模块</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var moduleTable = $('#moduleTable').DataTable({
        serverSide: true,
        ajax: '${base}/rbacModule/pageData',
        ordering: false,
        language: {url: "${base}/language/db_zh_CN.json"},
        dom: 'rtip',
        columns: [
            {
                width: "8%", render: function (data, type, row, meta) {
                return '<input class="cbItem" type="checkbox" style="margin-left: 7px;">';
            }
            },
            {data: 'id'},
            {data: 'code'},
            {data: 'title'},
            {data: 'path'},
            {data: 'icon'},
            {data: 'parent'},
            {
                render: function (data, type, row, meta) {
                    return '<button type="button" onclick="showModuleModal(\'' + row.id + '\');" class="btn btn-primary btn-xs" style="margin-right: 1px"><span class="glyphicon glyphicon-pencil">编辑</span></button>' +
                            '<button type="button" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-th-list">添加子模块</span></button>';
                }
            }
        ],
        drawCallback: function (settings) {
            $(".chooseAll").prop('checked', false);
        }
    });
    $(".chooseAll").change(function () {
        if ($(".chooseAll").is(':checked')) {
            $(".cbItem").prop('checked', true);
        } else {
            $(".cbItem").prop('checked', false);
        }
    });
    $('.relatePermission').on('click', function () {
        var nameArray = new Array();
        $(".cbItem").each(function () {
            if ($(this).is(':checked')) {
                nameArray.push($(this).parent("td").next().text());
            }
        });
        if (nameArray.length == 0) {
            alert("请先选择数据");
        } else {
            alert(JSON.stringify(nameArray));
        }
    });
    $('.delete').on('click', function () {
        var idArray = new Array();
        $(".cbItem").each(function () {
            if ($(this).is(':checked')) {
                idArray.push($(this).parent("td").next().text());
            }
        });
        if (idArray.length == 0) {
            alert("请先选择数据");
        } else {
            if (confirm('确定删除数据吗？')) {
                $.ajax({
                    url: '${base}/rbacModule/del',
                    data: {"ids": idArray},
                    success: function (result, status, xhr) {
                        alert("删除成功！");
                        moduleTable.ajax.reload();
                    }
                })
            }
        }
    });

    var options = {
        success: function (responseText, statusText, xhr) {
            if (responseText.responseCode != "200") {
                toastr.error(responseText.responseMessage, "失败");
            } else {
                $('.bs-example-modal-sm').modal('hide');//关闭模态框
                toastr.success("操作成功！", "成功");
                moduleTable.ajax.reload();
            }
        },
        resetForm: true,
        timeout: 3000
    };

    showModuleModal = function (id) {
        if (id) {
            $("#modalTitle").html("编辑模块");
            options.url = "${base}/rbacModule/update";
            $.get(
                    "${base}/rbacModule/findOne/" + id,
                    function (response, status, xhr) {
                        var module = response.data;
                        $("#moduleId").attr("value", module.id);
                        $("#codeId").val(module.code);
                        $("#pathId").val(module.path);
                        $("#titleId").val(module.title);
                        $("#iconId").val(module.icon);
                        $("#select_id").val(module.parent);
                    }
            );
        } else {
            $("#modalTitle").html("新增模块");
            options.url = "${base}/rbacModule/add";
        }
        $(".bs-example-modal-sm").modal('show');
    }

    //模态框关闭
    $('.bs-example-modal-sm').on('hidden.bs.modal', function () {
        $("form").resetForm();
    })

    $(document).ready(function () {
        $('form').submit(function () {
            $(this).ajaxSubmit(options);
            // !!! Important !!!
            // always return false to prevent standard browser submit and page navigation
            return false;
        });
    })
</script>
</body>
</html>